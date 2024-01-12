package hotlite.plugins.example

import com.google.inject.Inject
import com.google.inject.Provides
import ext.runelite.NPCExt.interact
import net.runelite.api.GameState
import net.runelite.api.Player
import net.runelite.api.events.*
import net.runelite.client.config.ConfigManager
import net.runelite.client.eventbus.Subscribe
import net.runelite.client.plugins.Plugin
import net.runelite.client.plugins.PluginDescriptor
import net.runelite.client.ui.overlay.OverlayManager

@PluginDescriptor(
    name = "K-Example",
    description = "Kotlin Example",
    tags = ["kotlin"]
)
class ExamplePlugin : Plugin() {

    val players = ArrayList<Player>()

    val overlay = ExampleOverlay(this)

    @Inject
    lateinit var overlayManager: OverlayManager

    override fun startUp() {
        overlayManager.add(overlay)
    }

    override fun shutDown() {
        overlayManager.remove(overlay)
    }


    @Subscribe
    fun onGameTick(event: GameTick) {
        println("Game Tick")
    }

    @Subscribe
    fun onGameStateChanged(event: GameStateChanged) {
        if (event.gameState == GameState.LOADING)
            players.clear()
    }

    @Subscribe
    fun onNPCSpawned(event: NpcSpawned) {
        when (event.npc.name) {
            "impossible" -> event.npc.interact("something")
        }
    }

    @Subscribe
    fun onPlayerSpawned(event: PlayerSpawned) {
        players.add(event.player)
    }

    @Subscribe
    fun onPlayerDespawned(event: PlayerDespawned) {
        players.remove(event.player)
    }


    @Provides
    fun getConfig(configManager: ConfigManager): ExampleConfig {
        return configManager.getConfig(ExampleConfig::class.java)
    }
}