package ext.runelite

import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.Tile
import net.runelite.api.coords.LocalPoint

object LocalPointExt {
    val client = Client::class.getInstance()
    fun LocalPoint.tile() : Tile? {
        if (x > (104 * 128) || y > (104 * 128) || x < 0 || y < 0)
            return null
        return client.scene.tiles[client.plane][x / 128][x / 128]
    }
}