package ext.runelite

import ext.kotlin.KClassExt.getInstance
import ext.runelite.SceneExt.objects
import net.runelite.api.Client
import net.runelite.api.Scene
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

    fun WallObject.Companion.withID(vararg ids: Int) : List<WallObject> {
        return Scene.objects<WallObject>().filter { it.isOf(*ids)}
    }

    fun WallObject.Companion.withName(vararg names: String) : List<WallObject> {
        return Scene.objects<WallObject>().filter { it.isOf(*names)}
    }
}