package com.tainted.voxxic.client

import com.tainted.voxxic.client.color.VOXBlockColors
import net.fabricmc.api.ClientModInitializer
import com.tainted.voxxic.client.registry.VOXScreens
import com.tainted.voxxic.client.render.VOXRenderLayer

@Suppress("UNUSED")
object VOXClient : ClientModInitializer{

    override fun onInitializeClient() {
        VOXScreens().register()
        VOXBlockColors().register()
        VOXRenderLayer().register()

        println("Voxxic client initialized");
    }
}