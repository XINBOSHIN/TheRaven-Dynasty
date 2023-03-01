package com.tainted.voxxic.common.block

import com.tainted.voxxic.common.property.VOXProperties
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.state.StateManager
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

//TODO Implement Block Functions
//TODO Implement Incrementing Level System
class BrewingPotBlock(settings: Settings): AbstractBrewingPotBlock(settings) {
    init {defaultState = defaultState.with(LEVEL, 0)}

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)
        builder.add(LEVEL)
    }

    override fun onUse(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, hit: BlockHitResult): ActionResult {
        if (!world.isClient) {


        }
        return super.onUse(state, world, pos, player, hand, hit)
    }

    fun isFull(state: BlockState): Boolean {return state.get(LEVEL) as Int == 7}

    fun incrementFluidLevel(state: BlockState, world: World, pos: BlockPos) {
        val i = state.get(LEVEL) as Int + 1
        world.setBlockState(pos, if(!isFull(state)) state else state.with(LEVEL, i))
    }

    fun decrementFluidLevel(state: BlockState, world: World, pos: BlockPos) {
        val i = state.get(LEVEL) as Int - 1
        world.setBlockState(pos, if(i == 0) state else state.with(LEVEL, i))
    }

    companion object: VOXProperties() {
        val LEVEL = LEVEL_7
    }
}