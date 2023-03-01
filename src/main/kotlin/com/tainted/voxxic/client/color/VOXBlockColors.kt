package com.tainted.voxxic.client.color

import com.tainted.voxxic.common.property.VOXProperties
import com.tainted.voxxic.core.registry.VOXBlocks
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.block.BlockState
import net.minecraft.client.color.world.BiomeColors

@Environment(EnvType.CLIENT)
open class VOXBlockColors {

    fun isEmpty(state: BlockState): Boolean {
        return state.get(LEVEL) < 1
    }

    fun register() {
        val blockColor = ColorProviderRegistry.BLOCK
        blockColor.register({state, world, pos, tintIndex ->
            if (world != null && pos != null && !isEmpty(state)) BiomeColors.getWaterColor(world, pos) else -1
        }, VOXBlocks.BREWING_POT)
    }

    companion object: VOXProperties() {
        val LEVEL = LEVEL_7
    }

}
