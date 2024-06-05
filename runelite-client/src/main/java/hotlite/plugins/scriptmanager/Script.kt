package hotlite.plugins.scriptmanager

import com.example.EthanApiPlugin.EthanApiPlugin
import ext.kotlin.KClassExt.getInstance
import ext.runelite.PluginManagerExt.get
import net.runelite.api.Client
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import net.runelite.client.RuneLite
import net.runelite.client.plugins.PluginManager

open class Script(var priority: Int = Int.MAX_VALUE-1) {
    val client = Client::class.getInstance()
    val childScripts = arrayListOf<Script>()
    var message: String = ""
    val ethans = PluginManager::class.getInstance().get<EthanApiPlugin>()
    open fun onGameTick() : ((Script) -> ScriptState)? = null

    fun getWidget(group: Int, child: Int): Widget? {
        return client.getWidget(WidgetInfo.PACK(group, child))
    }

    fun error(message: String) : ScriptState {
        println("ERROR: $message")
        return ScriptState.ABORTED
    }
}