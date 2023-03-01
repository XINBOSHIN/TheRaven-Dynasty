package com.tainted.voxxic.common.block

import com.tainted.voxxic.common.property.VOXProperties
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView

//TODO Move Level Properties to BrewingPotBlock
abstract class AbstractBrewingPotBlock(settings: Settings): Block(settings) {

    init {defaultState = defaultState.with(FACING, Direction.NORTH)}

    private val SHAPE = createCuboidShape(2.0, 0.0, 2.0, 14.0, 10.0, 14.0)
    override fun getOutlineShape(state: BlockState, view: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape {
        return SHAPE
    }
    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)
        builder.add(FACING)
    }
    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        return this.defaultState.with(FACING, ctx.playerFacing.opposite)
    }

    companion object: VOXProperties() {
        val FACING = Properties.HORIZONTAL_FACING
    }

}