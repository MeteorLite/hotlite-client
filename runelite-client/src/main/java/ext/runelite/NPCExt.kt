package ext.runelite

import com.example.EthanApiPlugin.EthanApiPlugin
import ext.kotlin.KClassExt.getInstance
import ext.runelite.NPCCompositionExt.isOf
import net.runelite.api.Client
import net.runelite.api.NPC

object NPCExt {
    val client = Client::class.getInstance()

    fun NPC.isOf(vararg ids: Int) : Boolean {
        return composition?.isOf(*ids) == true || ids.contains(id)
    }

    fun NPC.isOf(vararg names: String) : Boolean {
        return composition?.isOf(*names) == true || names.contains(name)
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

    fun NPC.getTrueAnimation() : Int {
        return EthanApiPlugin.getAnimation(this)
    }
}