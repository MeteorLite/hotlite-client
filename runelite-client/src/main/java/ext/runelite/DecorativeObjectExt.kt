package ext.runelite

import ext.kotlin.KClassExt.getInstance
import ext.runelite.SceneExt.objects
import net.runelite.api.Client
import net.runelite.api.DecorativeObject
import net.runelite.api.Scene

object DecorativeObjectExt {

    val client = Client::class.getInstance()

    fun DecorativeObject.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }

    fun DecorativeObject.isOf(vararg names: String) : Boolean {
        return names.contains(client.getObjectDefinition(id).name) || names.contains(client.getObjectDefinition(id).impostor.name)
    }

    fun<T: DecorativeObject> Iterable<T>.filterIDs(vararg ids: Int) : List<T> {
        return filter { ids.contains(it.id) }
    }

    fun<T: DecorativeObject> Iterable<T>.filterNames(vararg names: String) : List<T> {
        return filter { it.isOf(*names) }
    }

    fun DecorativeObject.Companion.withID(vararg ids: Int) : List<DecorativeObject> {
        return Scene.objects<DecorativeObject>().filter { it.isOf(*ids)}
    }

    fun DecorativeObject.Companion.withName(vararg names: String) : List<DecorativeObject> {
        return Scene.objects<DecorativeObject>().filter { it.isOf(*names)}
    }
}