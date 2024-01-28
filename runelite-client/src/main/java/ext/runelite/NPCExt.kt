package ext.runelite

import com.example.EthanApiPlugin.EthanApiPlugin
import com.example.InteractionApi.NPCInteraction
import ext.runelite.NPCCompositionExt.isOf
import net.runelite.api.NPC
import net.runelite.api.Player
import net.runelite.api.SkullIcon

object NPCExt {
    fun NPC.interact(vararg actions: String) {
        NPCInteraction.interact(this, *actions)
    }

    fun NPC.isOf(vararg ids: Int) : Boolean {
        return composition.isOf(*ids)
    }

    fun NPC.isOf(vararg names: String) : Boolean {
        return composition.isOf(*names)
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

    fun<T: NPC> Iterable<T>.withIDs(vararg ids: Int) : List<T> {
        return filter { ids.contains(it.id) }
    }

    fun<T: NPC> Iterable<T>.withNames(vararg names: String) : List<T> {
        return filter { it.composition.isOf(*names) }
    }
}