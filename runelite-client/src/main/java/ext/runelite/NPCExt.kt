package ext.runelite

import com.example.InteractionApi.NPCInteraction
import net.runelite.api.NPC

object NPCExt {
    fun NPC.interact(vararg actions: String) {
        NPCInteraction.interact(this, *actions)
    }
}