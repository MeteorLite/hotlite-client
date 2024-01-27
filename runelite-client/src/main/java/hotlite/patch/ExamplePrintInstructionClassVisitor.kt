package hotlite.patch

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.MethodVisitor

//TODO: methodDesc is inconsistent atm
class ExamplePrintInstructionClassVisitor(api: Int, private val methodName: String, private val methodDesc: String, classWriter: ClassWriter) : ClassVisitor(api, classWriter) {
        override fun visitMethod(access: Int, name: String, descriptor: String, signature: String?, exceptions: Array<out String>?): MethodVisitor {
            if (methodName == name) {
                val originalMethodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
                return PrintingMethodVisitor(api, originalMethodVisitor)
            }
            return super.visitMethod(access, name, descriptor, signature, exceptions)
        }
    }