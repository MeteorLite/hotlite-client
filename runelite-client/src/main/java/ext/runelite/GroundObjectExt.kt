package ext.runelite

import ext.kotlin.KClassExt.getInstance
import ext.runelite.SceneExt.getObjects
import net.runelite.api.Client
import net.runelite.api.GroundObject

object GroundObjectExt {

    val client = Client::class.getInstance()

    fun GroundObject.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }

    fun GroundObject.isOf(vararg names: String) : Boolean {
        return names.contains(client.getObjectDefinition(id).name) || names.contains(
            client.getObjectDefinition(id).impostor.name)
    }

    fun<T: GroundObject> Iterable<T>.filterIDs(vararg ids: Int) : List<T> {
        return filter { ids.contains(it.id) }
    }

    fun<T: GroundObject> Iterable<T>.filterNames(vararg names: String) : List<T> {
        return filter { it.isOf(*names) }
    }

    @JvmStatic
    fun GroundObject.Companion.withIDs(vararg ids: Int) : List<GroundObject> {
        return client.scene.getObjects().filterIsInstance<GroundObject>().filter { it.isOf(*ids)}
    }

    @JvmStatic
    fun GroundObject.Companion.withNames(vararg names: String) : List<GroundObject> {
        return client.scene.getObjects().filterIsInstance<GroundObject>().filter { it.isOf(*names)}
    }
}