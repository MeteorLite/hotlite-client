package ext.runelite

import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.Perspective
import net.runelite.api.Projectile
import net.runelite.api.coords.LocalPoint
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

object ProjectileExt {

    val client = Client::class.getInstance()

    fun Projectile.screenPoint(graphics: Graphics2D) : Point {
        val point = LocalPoint(getX().toInt(), getY().toInt())
        val textLocation = Perspective.getCanvasTextLocation(client, graphics, point, "", 0)
        return Point(textLocation.x, textLocation.y)
    }

    fun Projectile.drawCircle(graphics: Graphics2D, radius: Int, drawColor: Color, fillColor: Color) {
        val point = screenPoint(graphics)
        graphics.color = drawColor
        graphics.drawOval(point.x - radius, point.y - radius, 2 * radius, 2 * radius)
        graphics.color = fillColor
        graphics.fillOval(point.x - radius, point.y - radius, 2 * radius, 2 * radius)
    }
}