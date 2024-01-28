package ext.runelite

import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.DynamicObject
import net.runelite.api.GameObject
import java.awt.Rectangle

object GameObjectExt {

    val client = Client::class.getInstance()

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

    fun GameObject.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }
}