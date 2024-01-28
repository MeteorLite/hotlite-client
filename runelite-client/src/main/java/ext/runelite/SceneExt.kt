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

    fun Scene.getObjects() : ArrayList<TileObject> {
        val objects = ArrayList<TileObject>()
        GameObjectExt.client.scene.tiles.forEach { it?.forEach { it?.forEach {
            it?.gameObjects?.forEach { objects.add(it) }
            it?.decorativeObject?.let { objects.add(it) }
            it?.groundObject?.let { objects.add(it) }
            it?.wallObject?.let { objects.add(it) }
        } }}
        return objects
    }

    fun Scene.objectsWithID(vararg ids: Int) : List<TileObject> {
        return getObjects().filter { it.isOf(*ids) }
    }

    fun Scene.gameObjectsWithID(vararg ids: Int) : List<GameObject> {
        return getObjects().filterIsInstance<GameObject>().filter { it.isOf(*ids) }
    }

    fun Scene.groundObjectsWithID(vararg ids: Int) : List<GroundObject> {
        return getObjects().filterIsInstance<GroundObject>().filter { it.isOf(*ids) }
    }

    fun Scene.wallObjectsWithID(vararg ids: Int) : List<WallObject> {
        return getObjects().filterIsInstance<WallObject>().filter { it.isOf(*ids) }
    }

    fun Scene.decorativeObjectsWithID(vararg ids: Int) : List<DecorativeObject> {
        return getObjects().filterIsInstance<DecorativeObject>().filter { it.isOf(*ids) }
    }

    fun Scene.objectsWithName(vararg names: String) : List<TileObject> {
        return getObjects().filter {
            names.contains(client.getObjectDefinition(it.id).name)
        }
    }

    fun Scene.playersWithName(vararg names: String) : List<Player> {
        return client.players.filter {
            names.contains(it.name)
        }
    }

    fun Scene.npcsWithID(vararg ids: Int) : List<NPC> {
        return client.npcs.filter { it.isOf(*ids) || it.transformedComposition?.isOf(*ids) == true}
    }

    fun Scene.npcsWithName(vararg names: String) : List<NPC> {
        return client.npcs.filter {
            it.isOf(*names)
        }
    }
}