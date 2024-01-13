package ext.runelite

import net.runelite.client.plugins.Plugin

object PluginExt {
    inline fun <reified T> Plugin.getInjectedInstance(): T {
        return injector.getInstance(T::class.java)
    }
}