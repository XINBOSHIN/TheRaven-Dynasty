package com.tainted.voxxic.common.block

import net.minecraft.block.BlockState
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ScoriteBlock(settings: Settings): AbstractScoriteBlock(settings) {

    override fun onSteppedOn(world: World, pos: BlockPos, state: BlockState, entity: Entity) {
        if (isSoaked(state) && !entity.isFireImmune && (entity is LivingEntity) && !EnchantmentHelper.hasFrostWalker(entity)) {
            entity.damage(DamageSource.HOT_FLOOR, 1.0f)
        }
        super.onSteppedOn(world, pos, state, entity)
    }
    private fun isSoaked(state: BlockState): Boolean {
        return state.get(SOAKED) as Boolean
    }
}