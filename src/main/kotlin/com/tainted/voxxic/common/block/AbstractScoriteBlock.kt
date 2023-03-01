package com.tainted.voxxic.common.block

import com.tainted.voxxic.common.property.VOXProperties
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager

abstract class AbstractScoriteBlock(settings: Settings): Block(settings) {
    init {defaultState = defaultState.with(SOAKED, false)}

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)
        builder.add(SOAKED)
    }
    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        return this.defaultState
    }

    companion object: VOXProperties() {
        val SOAKED = LAVA_SOAKED
    }
}