package hotlite.plugins.scriptmanager

import net.runelite.api.events.GameTick
import net.runelite.client.eventbus.Subscribe
import net.runelite.client.plugins.Plugin
import net.runelite.client.plugins.PluginDescriptor

/**
 * This controls the execution flow of [Script]s and their childScripts
 */
@PluginDescriptor(
    name = "Z-ScriptManager",
    description = "Script runner",
    tags = ["kotlin"]
)
class ScriptManager : Plugin(){
    val scripts = ArrayList<Script>()
    val scriptsPendingRemoval = ArrayList<Script>()

    fun onGameTickExecution(script: Script, execution: ((Script) -> ScriptState)) {
        val result = execution.invoke(script)
        when (result) {
            ScriptState.RUNNING -> {}
            ScriptState.PAUSED -> {}
            ScriptState.FINISHED -> {
                scriptsPendingRemoval.add(script)
            }
            ScriptState.ABORTED -> {
                scriptsPendingRemoval.add(script)
            }
        }
    }

    fun ArrayList<Script>.priorityForEach(unit: (Script) -> ScriptState?) {
        this
            .sortedBy { it.priority }
            .forEach {
                val result = unit.invoke(it)
            }
    }

    @Subscribe
    private fun onGameTick(gameTick: GameTick) {
        try {
            scripts.priorityForEach { script ->
                val rootResult = script.onGameTick()?.invoke(script)
                script.childScripts.priorityForEach { childScript ->
                    childScript.onGameTick()?.invoke(childScript)
                }
                return@priorityForEach rootResult
            }

            scriptsPendingRemoval.forEach { scripts.remove(it) }
        } catch (e: Exception) {
            println("Uncaught Script Exception:")
            e.printStackTrace()
        }
    }

    fun registerScript(script: Script) {
        scripts.add(script)
    }
}