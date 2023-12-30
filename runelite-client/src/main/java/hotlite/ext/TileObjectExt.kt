package hotlite.ext

import com.example.InteractionApi.TileObjectInteraction
import net.runelite.api.TileObject

object TileObjectExt {
    fun TileObject.interact(vararg actions: String) {
        TileObjectInteraction.interact(this, *actions)
    }
}