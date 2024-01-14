package ext.runelite

import net.runelite.api.GameState

object GameStateExt {

    fun GameState.isOf(vararg gameStates: GameState): Boolean {
        return gameStates.contains(this)
    }
}