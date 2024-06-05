package hotlite.plugins.tutorial

import com.example.Packets.MousePackets
import com.example.Packets.WidgetPackets
import hotlite.plugins.scriptmanager.Script
import hotlite.plugins.scriptmanager.ScriptState
import net.runelite.api.widgets.Widget

object ChooseNameScript : Script() {
    override fun onGameTick(): (Script) -> ScriptState = script@{
        fetchSetDisplayNameRootWidget()?.let { rootWidget ->
            if (rootWidget.isHidden)
                return@script error("SetDisplayNameRootWidget must not be hidden")
            else {
                fetchSetDisplayNameTextFieldWidget()?.let { textField ->
                    if (textField.isHidden)
                        return@script error("SetDisplayNameTextFieldWidget must not be hidden")
                    else {
/*                        if (textField.text != "AliBaba") {
                            textField.setText("AliBaba")
                            return@script ScriptState.PAUSED
                        }*/
                        fetchLookupNameButtonWidget()?.let {
                            if (it.onOpListener != null) {
                                println("sending packet")
                                lookupName()
                                return@script ScriptState.PAUSED
                            } else {

                            }
                        }
                    }
                }
            }

        }
        return@script ScriptState.RUNNING
    }

    fun fetchSetDisplayNameRootWidget(): Widget? {
        return getWidget(558, 3)
    }

    fun fetchSetDisplayNameTextFieldWidget(): Widget? {
        return getWidget(558, 12)
    }

    fun fetchNameAvailabilityResponseTextWidget(): Widget? {
        return getWidget(558, 13)
    }

    fun fetchLookupNameButtonWidget(): Widget? {
        return getWidget(558, 18)
    }

    fun lookupName() {
        fetchLookupNameButtonWidget()?.let {
            if (it.onOpListener.isEmpty()) {
                //name already taken and text field not edited yet
            } else {
                MousePackets.queueClickPacket()
                WidgetPackets.queueWidgetActionPacket(1, it.id, it.itemId, it.index)
            }
        }
    }

    private fun Widget.lookupName() {

    }
}