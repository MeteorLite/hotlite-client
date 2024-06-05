package ext.runelite

import com.example.EthanApiPlugin.EthanApiPlugin
import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.HeadIcon
import net.runelite.api.Player
import net.runelite.api.SkullIcon

object PlayerExt {
    val client = Client::class.getInstance()

    fun Player.isOf(vararg names: String) : Boolean {
        return names.contains(name)
    }

    fun Player.Companion.forEach(task : (Player) -> Unit) {
        client.players.filterNotNull().forEach(task)
    }

    fun Player.getSkullIcon() : SkullIcon {
        return EthanApiPlugin.getSkullIcon(this)
    }
}