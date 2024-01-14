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

    /**
     * Good for calls such as
     */
    fun NPC.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }
}