package ext.runelite

import com.example.EthanApiPlugin.Collections.query.QuickPrayer
import com.example.EthanApiPlugin.EthanApiPlugin
import ext.kotlin.KClassExt.getInstance
import ext.runelite.PluginManagerExt.get
import hotlite.plugins.scriptmanager.ScriptManager
import net.runelite.api.ChatMessageType
import net.runelite.api.Client
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import net.runelite.client.plugins.Plugin
import net.runelite.client.plugins.PluginManager

object PluginExt {
    val client = Client::class.getInstance()
    val pluginManager = PluginManager::class.getInstance()

    inline fun <reified T> Plugin.getInjectedInstance(): T {
        return injector.getInstance(T::class.java)
    }

    fun Plugin.loggedIn() : Boolean {
        return EthanApiPlugin.loggedIn()
    }

    fun Plugin.getClient() : Client {
        return EthanApiPlugin.getClient()
    }

    fun Plugin.isQuickPrayerEnabled() : Boolean {
        return EthanApiPlugin.isQuickPrayerEnabled()
    }

    fun Plugin.sendGameMessage(message: String) {
        getClient().addChatMessage(ChatMessageType.GAMEMESSAGE, "", message, "")
    }

    fun Plugin.getWidget(group: Int, child: Int): Widget? {
        return client.getWidget(WidgetInfo.PACK(group, child))
    }

    fun Plugin.getScriptManager() : ScriptManager {
        return pluginManager.get<ScriptManager>()
    }
}