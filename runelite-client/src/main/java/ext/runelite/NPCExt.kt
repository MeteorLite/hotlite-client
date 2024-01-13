package ext.runelite

import com.example.InteractionApi.NPCInteraction
import net.runelite.api.NPC

object NPCExt {
    fun NPC.interact(vararg actions: String) {
        NPCInteraction.interact(this, *actions)
    }

    fun<T: NPC> Iterable<T>.withID(vararg ids: Int) : List<T> {
        return filter { ids.contains(it.id) }
    }

}