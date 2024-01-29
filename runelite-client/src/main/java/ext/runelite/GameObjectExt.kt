package ext.runelite

import ext.kotlin.KClassExt.getInstance
import ext.runelite.SceneExt.getObjects
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

    fun GameObject.isOf(vararg names: String) : Boolean {
        return names.contains(client.getObjectDefinition(id).name) || names.contains(client.getObjectDefinition(id).impostor.name)
    }

    fun<T: GameObject> Iterable<T>.filterIDs(vararg ids: Int) : List<T> {
        return filter { ids.contains(it.id) }
    }

    fun<T: GameObject> Iterable<T>.filterNames(vararg names: String) : List<T> {
        return filter { it.isOf(*names) }
    }

    @JvmStatic
    fun GameObject.Companion.withIDs(vararg ids: Int) : List<GameObject> {
        return client.scene.getObjects().filterIsInstance<GameObject>().filter { it.isOf(*ids)}
    }

    @JvmStatic
    fun GameObject.Companion.withNames(vararg names: String) : List<GameObject> {
        return client.scene.getObjects().filterIsInstance<GameObject>().filter { it.isOf(*names)}
    }
}