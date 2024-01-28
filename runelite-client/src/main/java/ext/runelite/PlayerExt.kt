package ext.runelite

import com.example.EthanApiPlugin.EthanApiPlugin
import com.example.InteractionApi.PlayerInteractionHelper
import net.runelite.api.Player
import net.runelite.api.SkullIcon

object PlayerExt {
    fun Player.interact(vararg actions: String) {
        PlayerInteractionHelper.interact(this, *actions)
    }

    fun Player.getRawSkullIcon() : SkullIcon {
        return EthanApiPlugin.getSkullIcon(this)
    }

    fun Player.getRawPathLength() : Int {
        return EthanApiPlugin.pathLength(this)
    }

    fun Player.isOf(vararg names: String) : Boolean {
        return names.contains(name)
    }
}