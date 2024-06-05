package hotlite.plugins.tutorial

import ext.kotlin.KClassExt.getInstance
import ext.runelite.PluginExt.getScriptManager
import ext.runelite.PluginManagerExt.get
import hotlite.api.varp.TutorialProgressVarp
import hotlite.plugins.scriptmanager.ScriptManager
import net.runelite.api.Client
import net.runelite.api.events.VarbitChanged
import net.runelite.client.eventbus.Subscribe
import net.runelite.client.plugins.Plugin
import net.runelite.client.plugins.PluginDescriptor

@PluginDescriptor(
    name = "Z-Tutorial",
    description = "Tutorial runner",
    tags = ["kotlin"]
)
class TutorialPlugin : Plugin() {
    val client = Client::class.getInstance()
    var tutorialProgress = 0

    @Subscribe
    fun onVarbitChanged(varbitChanged: VarbitChanged) {
        when (varbitChanged.varpId) {
            TutorialProgressVarp.id -> {
                updateTutorialState(varbitChanged.value)
                handleTutorial()
            }
        }
    }

    fun handleTutorial() {
        when (tutorialProgress) {
            TutorialProgressVarp.CHOOSE_NAME -> {
                getScriptManager().registerScript(ChooseNameScript)
            }
        }
    }

    private fun fetchTutorialState() {
        tutorialProgress = client.getVarpValue(TutorialProgressVarp.id)
    }

    private fun updateTutorialState(value: Int) {
        tutorialProgress = value
    }
}