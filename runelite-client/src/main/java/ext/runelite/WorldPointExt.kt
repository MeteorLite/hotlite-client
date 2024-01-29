package ext.runelite

import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.Tile
import net.runelite.api.coords.WorldPoint

object WorldPointExt {
    val client = Client::class.getInstance()
    fun WorldPoint.tile() : Tile? {
        if (x > 104 || y > 104 || x < 0 || y < 0)
            return null
        return client.scene.tiles[client.plane]!![x - client.baseX]!![y - client.baseY]
    }
}