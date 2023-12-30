package hotlite.plugins.example

import com.google.inject.Provides
import hotlite.ext.NPCExt.interact
import net.runelite.api.events.GameTick
import net.runelite.api.events.NpcSpawned
import net.runelite.client.config.ConfigManager
import net.runelite.client.eventbus.Subscribe
import net.runelite.client.plugins.Plugin
import net.runelite.client.plugins.PluginDescriptor

@PluginDescriptor(
    name = "K-Example",
    description = "Kotlin Example",
    tags = ["kotlin"]
)
class ExamplePlugin : Plugin() {

    @Subscribe
    fun onGameTick(event: GameTick) {
        println("Game Tick")
    }

    @Subscribe
    fun onNPCSpawned(npcSpawned: NpcSpawned) {
        when (npcSpawned.npc.name) {
            "impossible" -> npcSpawned.npc.interact("something")
        }
    }

    @Provides
    fun getConfig(configManager: ConfigManager): ExampleConfig {
        return configManager.getConfig(ExampleConfig::class.java)
    }
}