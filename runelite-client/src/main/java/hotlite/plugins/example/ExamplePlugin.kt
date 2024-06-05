package hotlite.plugins.example

import com.example.EthanApiPlugin.Collections.query.QuickPrayer
import com.example.EthanApiPlugin.EthanApiPlugin
import com.google.inject.Inject
import com.google.inject.Provides
import ext.ethans.QuickPrayerExt.isActive
import ext.runelite.NPCExt.getTrueAnimation
import ext.runelite.PlayerExt.getSkullIcon
import ext.runelite.PluginExt.getClient
import ext.runelite.PluginExt.getInjectedInstance
import net.runelite.api.Prayer
import net.runelite.api.events.GameTick
import net.runelite.client.config.ConfigManager
import net.runelite.client.eventbus.Subscribe
import net.runelite.client.plugins.Plugin
import net.runelite.client.plugins.PluginDescriptor
import net.runelite.client.ui.overlay.OverlayManager

@PluginDescriptor(
    name = "K-Example",
    description = "Kotlin Example",
    tags = ["kotlin"],
    enabledByDefault = false
)
class ExamplePlugin : Plugin() {

    @Inject val overlay = ExampleOverlay()
    @Inject lateinit var overlayManager: OverlayManager

    override fun startUp() {
        overlayManager.add(overlay)
    }

    override fun shutDown() {
        overlayManager.remove(overlay)
    }

    @Subscribe fun onGameTick(event: GameTick) {
        println("Game Tick")
    }

    @Provides fun getConfig(configManager: ConfigManager): ExampleConfig {
        return configManager.getConfig(ExampleConfig::class.java)
    }
}