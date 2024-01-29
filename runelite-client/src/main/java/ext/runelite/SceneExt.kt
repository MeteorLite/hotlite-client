package ext.runelite

import ext.kotlin.KClassExt.getInstance
import ext.runelite.DecorativeObjectExt.isOf
import ext.runelite.GameObjectExt.isOf
import ext.runelite.GroundObjectExt.isOf
import ext.runelite.NPCCompositionExt.isOf
import ext.runelite.NPCExt.isOf
import ext.runelite.TileObjectExt.isOf
import ext.runelite.WallObjectExt.isOf
import net.runelite.api.*


object SceneExt {
    val client = Client::class.getInstance()

    val Scene.Companion.objects : ArrayList<TileObject>
        get() {
            val objects = ArrayList<TileObject>()
            client.scene.tiles.forEach { it?.forEach { it?.forEach {
                it?.gameObjects?.forEach { objects.add(it) }
                it?.decorativeObject?.let { objects.add(it) }
                it?.groundObject?.let { objects.add(it) }
                it?.wallObject?.let { objects.add(it) }
            } }}
            return objects
        }

    fun Scene.Companion.objectsWithID(vararg ids: Int) : List<TileObject> {
        return objects.filter { it.isOf(*ids) }
    }

    fun Scene.Companion.gameObjectsWithID(vararg ids: Int) : List<GameObject> {
        return objects.filterIsInstance<GameObject>().filter { it.isOf(*ids) }
    }

    fun Scene.Companion.groundObjectsWithID(vararg ids: Int) : List<GroundObject> {
        return objects.filterIsInstance<GroundObject>().filter { it.isOf(*ids) }
    }

    fun Scene.Companion.wallObjectsWithID(vararg ids: Int) : List<WallObject> {
        return objects.filterIsInstance<WallObject>().filter { it.isOf(*ids) }
    }

    fun Scene.Companion.decorativeObjectsWithID(vararg ids: Int) : List<DecorativeObject> {
        return objects.filterIsInstance<DecorativeObject>().filter { it.isOf(*ids) }
    }

    fun Scene.Companion.objectsWithName(vararg names: String) : List<TileObject> {
        return objects.filter {
            names.contains(client.getObjectDefinition(it.id).name)
        }
    }

    fun Scene.Companion.playersWithName(vararg names: String) : List<Player> {
        return client.players.filter {
            names.contains(it.name)
        }
    }

    fun Scene.Companion.npcsWithID(vararg ids: Int) : List<NPC> {
        return client.npcs.filter { it.isOf(*ids) || it.transformedComposition?.isOf(*ids) == true}
    }

    fun Scene.Companion.npcsWithName(vararg names: String) : List<NPC> {
        return client.npcs.filter {
            it.isOf(*names)
        }
    }
}