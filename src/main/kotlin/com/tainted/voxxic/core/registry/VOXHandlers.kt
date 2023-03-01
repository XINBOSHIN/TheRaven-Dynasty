package com.tainted.voxxic.core.registry

import com.tainted.voxxic.common.screen.MortarScreenHandler
import com.tainted.voxxic.core.Voxxic
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier

class VOXHandlers {

    companion object {
        var MORTAR_SCREEN_TYPE: ScreenHandlerType<MortarScreenHandler>? = null;
    }

    fun register() {
        MORTAR_SCREEN_TYPE = ScreenHandlerRegistry.registerSimple(Identifier(Voxxic.MOD_ID, "voxxic_mortar"), ::MortarScreenHandler);
    }

}