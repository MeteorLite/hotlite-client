package hotlite.ext

import com.example.InteractionApi.PlayerInteractionHelper
import net.runelite.api.Player

object PlayerExt {
    fun Player.interact(vararg actions: String) {
        PlayerInteractionHelper.interact(this, *actions)
    }
}