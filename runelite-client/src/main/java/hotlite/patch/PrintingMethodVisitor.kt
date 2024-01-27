package hotlite.patch

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.util.Printer

class PrintingMethodVisitor(api: Int, mv: MethodVisitor?) : MethodVisitor(api, mv) {
    override fun visitCode() {
        println("Method Instructions:")
        super.visitCode()
    }

    override fun visitInsn(opcode: Int) {
        println(getOpcodeName(opcode))
        super.visitInsn(opcode)
    }

    override fun visitIntInsn(opcode: Int, operand: Int) {
        println(getOpcodeName(opcode) + " " + operand)
        super.visitIntInsn(opcode, operand)
    }

    override fun visitVarInsn(opcode: Int, `var`: Int) {
        println(getOpcodeName(opcode) + " " + `var`)
        super.visitVarInsn(opcode, `var`)
    }

    override fun visitTypeInsn(opcode: Int, type: String) {
        println(getOpcodeName(opcode) + " " + type)
        super.visitTypeInsn(opcode, type)
    }

    override fun visitFieldInsn(opcode: Int, owner: String, name: String, descriptor: String) {
        println(getOpcodeName(opcode) + " " + owner + " " + name + " " + descriptor)
        super.visitFieldInsn(opcode, owner, name, descriptor)
    }

    override fun visitMethodInsn(opcode: Int, owner: String, name: String, descriptor: String, isInterface: Boolean) {
        println(getOpcodeName(opcode) + " " + owner + " " + name + " " + descriptor + " " + isInterface)
        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface)
    }

    override fun visitJumpInsn(opcode: Int, label: Label) {
        println(getOpcodeName(opcode) + " " + label)
        super.visitJumpInsn(opcode, label)
    }

    override fun visitLabel(label: Label) {
        println("Label: $label")
        super.visitLabel(label)
    }

    override fun visitLdcInsn(value: Any) {
        println("LDC: $value")
        super.visitLdcInsn(value)
    }

    override fun visitIincInsn(`var`: Int, increment: Int) {
        println("IINC: $`var` $increment")
        super.visitIincInsn(`var`, increment)
    }

    override fun visitTableSwitchInsn(min: Int, max: Int, dflt: Label, vararg labels: Label) {
        println("TABLESWITCH: " + min + " " + max + " " + dflt + " " + labels.contentToString())
        super.visitTableSwitchInsn(min, max, dflt, *labels)
    }

    override fun visitLookupSwitchInsn(dflt: Label, keys: IntArray, labels: Array<Label>) {
        println("LOOKUPSWITCH: " + dflt + " " + keys.contentToString() + " " + labels.contentToString())
        super.visitLookupSwitchInsn(dflt, keys, labels)
    }

    override fun visitMultiANewArrayInsn(descriptor: String, dims: Int) {
        println("MULTIANEWARRAY: $descriptor $dims")
        super.visitMultiANewArrayInsn(descriptor, dims)
    }

    override fun visitMaxs(maxStack: Int, maxLocals: Int) {
        println("Max Stack: $maxStack, Max Locals: $maxLocals")
        super.visitMaxs(maxStack, maxLocals)
    }

    override fun visitEnd() {
        println("End of Method")
        super.visitEnd()
    }

    private fun getOpcodeName(opcode: Int): String {
        return Printer.OPCODES[opcode]
    }
}