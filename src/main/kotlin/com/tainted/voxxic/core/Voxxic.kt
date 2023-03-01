package com.tainted.voxxic.core
import com.tainted.voxxic.core.registry.VOXBlocks
import com.tainted.voxxic.core.registry.VOXItems
import com.tainted.voxxic.core.registry.VOXHandlers
import net.fabricmc.api.ModInitializer

@Suppress("UNUSED")
object Voxxic: ModInitializer {
    const val MOD_ID = "voxxic"

    override fun onInitialize() {
        // Initialize Mod Components:
        VOXItems().register()
        VOXBlocks().register()
        VOXHandlers().register()

        println("Voxxic has been initialized.")
    }
}