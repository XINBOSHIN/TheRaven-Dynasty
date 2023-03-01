package com.tainted.voxxic.common.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView

abstract class AbstractMortarAndPestleBlock(settings: Settings): Block(settings) {

    private val SHAPE = createCuboidShape(5.0, 0.0, 5.0, 11.0, 5.0, 11.0)
    override fun getOutlineShape(state: BlockState, view: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape {
        return SHAPE
    }

}
