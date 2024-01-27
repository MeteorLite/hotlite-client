package hotlite.patch

import ext.java.JarFileExt.getBytes
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import java.io.IOException
import java.util.jar.JarFile
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod


object PatchManager {
    lateinit var PATCHED_JAR: String
    lateinit var CLASSLOADER: ClassLoader
    val classNames = HashSet<String>()
    val classes = HashMap<KClass<*>, ByteArray>()

    fun init(pathToJar: String, classLoader: ClassLoader) {
        PATCHED_JAR = pathToJar
        CLASSLOADER = classLoader

        loadPatch(PATCHED_JAR, CLASSLOADER)

        println("Loaded ${classes.size} patch classes")

        printChangeWorldInstructions()
    }

    fun loadPatch(pathToPatch: String, classLoader: ClassLoader) {
        try {
            val jarFile = JarFile(pathToPatch)
            val entries = jarFile.entries()

            while (entries.hasMoreElements()) {
                val entry = entries.nextElement()
                if (entry.name.endsWith(".class")) {
                    val className = entry.name.replace('/', '.').substring(0, entry.name.length - 6)
                    classNames.add(className)
                    classes[classLoader.loadClass(className).kotlin] =
                        jarFile.getBytes(entry)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun printChangeWorldInstructions() {
        for (c in classes.keys) {
            for (m in c.memberFunctions) {
                if (m.name == "changeWorld") {
                    m.javaMethod?.let {
                        try {
                            val classBytes = classes[c]
                            val reader = ClassReader(classBytes)
                            val classWriter = ClassWriter(ClassWriter.COMPUTE_MAXS)
                            val visitor = ExamplePrintInstructionClassVisitor(Opcodes.ASM9, m.name, getMethodDescriptor(m), classWriter)
                            reader.accept(visitor, 0)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        }
    }

    //FIXME
    fun getMethodDescriptor(kFunction: KFunction<*>): String {
        val javaMethod = kFunction.javaMethod ?: error("Java method not found for the provided Kotlin function")
        val methodDescriptor = javaMethod.toGenericString()

        // If you specifically want just the method descriptor, you can extract it from the generic string
        val descriptorStart = methodDescriptor.indexOf('(')
        val descriptorEnd = methodDescriptor.indexOf(')') + 1
        return methodDescriptor.substring(descriptorStart, descriptorEnd)
    }
}

