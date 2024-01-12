package ext.java

import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.awt.Rectangle

object RectangleExt {
    fun Rectangle.contains(worldPoint: WorldPoint) : Boolean {
        return this.contains(worldPoint.x, worldPoint.y)
    }

    fun Rectangle.contains(localPoint: LocalPoint) : Boolean {
        return this.contains(localPoint.x, localPoint.y)
    }
}