package com.tainted.voxxic.client.registry

import com.tainted.voxxic.client.gui.screen.MortarScreen
import com.tainted.voxxic.core.registry.VOXHandlers
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry


class VOXScreens {

    companion object {

    }

    fun register() {
        ScreenRegistry.register(VOXHandlers.MORTAR_SCREEN_TYPE, ::MortarScreen);
    }
}