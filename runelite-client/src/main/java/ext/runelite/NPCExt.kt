package ext.runelite

import com.example.EthanApiPlugin.EthanApiPlugin
import com.example.InteractionApi.NPCInteraction
import net.runelite.api.NPC
import net.runelite.api.Player
import net.runelite.api.SkullIcon

object NPCExt {
    fun NPC.interact(vararg actions: String) {
        NPCInteraction.interact(this, *actions)
    }

    fun<T: NPC> Iterable<T>.withID(vararg ids: Int) : List<T> {
        return filter { ids.contains(it.id) }
    }

    fun NPC.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }
    
    fun NPC.getRawAnimation() : Int {
        return EthanApiPlugin.getAnimation(this)
    }

    fun NPC.getRawPathLength() : Int {
        return EthanApiPlugin.pathLength(this)
    }

    fun Player.getRawSkullIcon() : SkullIcon {
        return EthanApiPlugin.getSkullIcon(this)
    }
}