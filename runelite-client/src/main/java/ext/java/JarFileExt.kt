package ext.java

import java.io.ByteArrayOutputStream
import java.util.jar.JarEntry
import java.util.jar.JarFile

object JarFileExt {
    fun JarFile.getBytes(entry: JarEntry): ByteArray {
        getInputStream(entry).use { inputStream ->
            ByteArrayOutputStream().use { byteArrayOutputStream ->
                val buffer = ByteArray(4096)
                var bytesRead: Int
                while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead)
                }
                return byteArrayOutputStream.toByteArray()
            }
        }
    }
}