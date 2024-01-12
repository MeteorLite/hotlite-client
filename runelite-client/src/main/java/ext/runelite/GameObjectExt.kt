package ext.runelite

import net.runelite.api.DynamicObject
import net.runelite.api.GameObject
import java.awt.Rectangle

object GameObjectExt {
    fun GameObject.asDynamic(): DynamicObject? {
        if (renderable is DynamicObject)
            return (renderable as DynamicObject)
        return null
    }

    fun GameObject.localTileArea() : Rectangle {
        return Rectangle(localLocation.x, localLocation.y, sizeX(), sizeY())
    }

    fun GameObject.worldTileArea() : Rectangle {
        return Rectangle(worldLocation.x - 1, worldLocation.y - 1, sizeX(), sizeY())
    }
}