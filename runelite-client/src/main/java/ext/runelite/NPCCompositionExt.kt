package ext.runelite

import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.NPCComposition

object NPCCompositionExt {
    val client = Client::class.getInstance()
    fun NPCComposition.isOf(vararg ids: Int) : Boolean {
        if (ids.contains(id))
            return true
        this.configs?.let {
            return this.transform()?.id?.let { ids.contains(it) } == true
        }
        return false
    }

    fun NPCComposition.isOf(vararg names: String) : Boolean {
        if (names.contains(name))
            return true
        this.configs?.let {
            return this.transform()?.name?.let { names.contains(it) } == true
        }
        return false
    }
}