package ext.runelite

import ext.kotlin.KClassExt.getInstance
import ext.runelite.SceneExt.getObjects
import net.runelite.api.Client
import net.runelite.api.DecorativeObject

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

    @JvmStatic
    fun DecorativeObject.Companion.withIDs(vararg ids: Int) : List<DecorativeObject> {
        return client.scene.getObjects().filterIsInstance<DecorativeObject>().filter { it.isOf(*ids)}
    }

    @JvmStatic
    fun DecorativeObject.Companion.withNames(vararg names: String) : List<DecorativeObject> {
        return client.scene.getObjects().filterIsInstance<DecorativeObject>().filter { it.isOf(*names)}
    }
}