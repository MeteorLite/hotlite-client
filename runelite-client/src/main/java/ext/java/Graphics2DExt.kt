package ext.java

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Shape

object Graphics2DExt {
    fun Graphics2D.fillColor(color: Color, shape: Shape) {
        setColor(color)
        fill(shape)
    }

    fun Graphics2D.drawColor(color: Color, shape: Shape) {
        setColor(color)
        draw(shape)
    }

    fun Color.fillColor() : Color {
        return Color(this.red, this.green, this.blue, 150)
    }

    fun Color.darkerFillColor() : Color {
        return fillColor().darker()
    }
}