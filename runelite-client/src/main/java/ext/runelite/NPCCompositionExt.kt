package ext.runelite

import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.NPCComposition

object NPCCompositionExt {
    val client = Client::class.getInstance()
    fun NPCComposition.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id) || ids.contains(this.transform().id)
    }

    fun NPCComposition.isOf(vararg names: String) : Boolean {
        return names.contains(name) || names.contains(this.transform().name)
    }
}