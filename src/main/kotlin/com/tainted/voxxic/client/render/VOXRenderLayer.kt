package com.tainted.voxxic.client.render

import com.tainted.voxxic.core.registry.VOXBlocks
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.block.Blocks
import net.minecraft.client.render.RenderLayer

@Environment(EnvType.CLIENT)
class VOXRenderLayer {

    fun register() {
        BlockRenderLayerMap.INSTANCE.putBlock(VOXBlocks.BREWING_POT, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WATER_CAULDRON, RenderLayer.getTranslucent())
    }

}