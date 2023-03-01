package com.tainted.voxxic.common.block

import com.tainted.voxxic.common.screen.MortarScreenHandler
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.SimpleNamedScreenHandlerFactory
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

//TODO Implement Block Function
class MortarAndPestleBlock(settings: Settings): AbstractMortarAndPestleBlock(settings) {
    val TITLE: Text = Text.of("Mortar");
    override fun onUse(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, hit: BlockHitResult): ActionResult {
        if (!world.isClient) {
            var screenHandlerFactory: NamedScreenHandlerFactory? = state.createScreenHandlerFactory(world, pos);
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    override fun createScreenHandlerFactory(state: BlockState, world: World, pos: BlockPos): NamedScreenHandlerFactory {
        return SimpleNamedScreenHandlerFactory({ syncId: Int, inventory: PlayerInventory, player: PlayerEntity ->
            MortarScreenHandler(
                syncId,
                inventory,
            )
        }, TITLE);
    }
}