package com.tainted.voxxic.common.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.Direction

abstract class AbstractBurnerBlock(settings: Settings): Block(settings) {

    init {defaultState = defaultState.with(FACING, Direction.NORTH).with(LIT, false)}

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)
        builder.add(FACING, LIT)
    }
    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        return this.defaultState.with(FACING, ctx.playerFacing.opposite)
    }

    companion object {
        val FACING = Properties.HORIZONTAL_FACING
        val LIT = Properties.LIT
    }

}