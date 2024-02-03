package ext.runelite

import com.example.EthanApiPlugin.EthanApiPlugin
import com.example.InteractionApi.NPCInteraction
import ext.kotlin.KClassExt.getInstance
import ext.runelite.NPCCompositionExt.isOf
import net.runelite.api.Client
import net.runelite.api.NPC
import net.runelite.api.Player
import net.runelite.api.SkullIcon

object NPCExt {
    val client = Client::class.getInstance()
    fun NPC.interact(vararg actions: String) {
        NPCInteraction.interact(this, *actions)
    }

    fun NPC.isOf(vararg ids: Int) : Boolean {
        return composition?.isOf(*ids) == true || ids.contains(id)
    }

    fun NPC.isOf(vararg names: String) : Boolean {
        return composition?.isOf(*names) == true || names.contains(name)
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

    fun<T: NPC> Iterable<T>.filterID(vararg ids: Int) : List<T> {
        return filter { it.isOf(*ids) }
    }

    fun<T: NPC> Iterable<T>.filterName(vararg names: String) : List<T> {
        return filter { it.isOf(*names) }
    }

    fun NPC.Companion.withID(vararg ids: Int) : List<NPC> {
        return client.npcs.filter { it.isOf(*ids) }
    }

    fun NPC.Companion.withName(vararg names: String) : List<NPC> {
        return client.npcs.filter { it.isOf(*names) }
    }

    fun NPC.Companion.forEach(task : (NPC) -> Unit) {
        client.npcs.filterNotNull().forEach(task)
    }
}