package hotlite.scripts.quests.restlessghost

import hotlite.plugins.scriptmanager.Script
import hotlite.plugins.scriptmanager.ScriptState

class RestlessGhostScript : Script(){
    override fun onGameTick(): (Script) -> ScriptState = script@{

        return@script ScriptState.RUNNING
    }
}