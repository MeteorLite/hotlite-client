package ext.runelite

import ext.kotlin.KClassExt.getInstance
import ext.runelite.DecorativeObjectExt.isOf
import ext.runelite.DequeExt.withID
import ext.runelite.GameObjectExt.isOf
import ext.runelite.GroundObjectExt.isOf
import ext.runelite.NPCCompositionExt.isOf
import ext.runelite.NPCExt.isOf
import ext.runelite.TileObjectExt.isOf
import ext.runelite.WallObjectExt.isOf
import net.runelite.api.*


object SceneExt {
    val client = Client::class.getInstance()

    inline fun<reified T : TileObject> Scene.Companion.objects() : List<T> {
        val objects = HashSet<T>()
        client.scene.tiles.forEach { it?.forEach { it?.forEach {
            when (T::class) {
                GameObject::class -> it?.gameObjects?.filterNotNull()?.forEach { objects.add(it as T) }
                DecorativeObject::class -> it?.decorativeObject?.let { objects.add(it as T) }
                GroundObject::class -> it?.groundObject?.let { objects.add(it as T) }
                WallObject::class -> it?.wallObject?.let { objects.add(it as T) }
                TileObject::class -> {
                    it?.gameObjects?.filterNotNull()?.forEach { objects.add(it as T) }
                    it?.decorativeObject?.let { objects.add(it as T) }
                    it?.groundObject?.let { objects.add(it as T) }
                    it?.wallObject?.let { objects.add(it as T) }
                }
            }
        } }}
        return objects.toList()
    }

    fun Scene.Companion.objectsWithID(vararg ids: Int) : List<TileObject> {
        return objects<TileObject>().filter { it.isOf(*ids) }
    }

    fun Scene.Companion.gameObjectsWithID(vararg ids: Int) : List<GameObject> {
        return objects<GameObject>().filter { it.isOf(*ids) }
    }

    fun Scene.Companion.groundObjectsWithID(vararg ids: Int) : List<GroundObject> {
        return objects<GroundObject>().filter { it.isOf(*ids) }
    }

    fun Scene.Companion.wallObjectsWithID(vararg ids: Int) : List<WallObject> {
        return objects<WallObject>().filter { it.isOf(*ids) }
    }

    fun Scene.Companion.decorativeObjectsWithID(vararg ids: Int) : List<DecorativeObject> {
        return objects<DecorativeObject>().filter { it.isOf(*ids) }
    }

    fun Scene.Companion.objectsWithName(vararg names: String) : List<TileObject> {
        return objects<TileObject>().filter {
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

    fun Scene.Companion.projectilesWithID(vararg ids: Int) : List<Projectile> {
        return client.projectiles.withID(*ids)
    }
}