package ext.runelite

import net.runelite.client.plugins.PluginManager

object PluginManagerExt {
    inline fun<reified T> PluginManager.get(): T {
        return plugins.first { it is T } as T
    }
}