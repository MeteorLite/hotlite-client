package ext.runelite

import ext.kotlin.KClassExt.getInstance
import ext.runelite.SceneExt.getObjects
import net.runelite.api.Client
import net.runelite.api.WallObject

object WallObjectExt {

    val client = Client::class.getInstance()

    fun WallObject.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }

    fun WallObject.isOf(vararg names: String) : Boolean {
        return names.contains(client.getObjectDefinition(id).name) || names.contains(
            client.getObjectDefinition(id).impostor.name)
    }

    fun<T: WallObject> Iterable<T>.filterIDs(vararg ids: Int) : List<T> {
        return filter { ids.contains(it.id) }
    }

    fun<T: WallObject> Iterable<T>.filterNames(vararg names: String) : List<T> {
        return filter { it.isOf(*names) }
    }

    @JvmStatic
    fun WallObject.Companion.withIDs(vararg ids: Int) : List<WallObject> {
        return client.scene.getObjects().filterIsInstance<WallObject>().filter { it.isOf(*ids)}
    }

    @JvmStatic
    fun WallObject.Companion.withNames(vararg names: String) : List<WallObject> {
        return client.scene.getObjects().filterIsInstance<WallObject>().filter { it.isOf(*names)}
    }
}