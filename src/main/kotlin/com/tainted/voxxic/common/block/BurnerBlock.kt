package com.tainted.voxxic.common.block

import net.minecraft.block.BlockState
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class BurnerBlock(settings: Settings): AbstractBurnerBlock(settings) {

    override fun onSteppedOn(world: World, pos: BlockPos, state: BlockState, entity: Entity) {
        if (isLit(state) && !entity.isFireImmune && (entity is LivingEntity) && !EnchantmentHelper.hasFrostWalker(entity) && !hasBootsOn(entity)) {
            entity.damage(DamageSource.HOT_FLOOR, 1.0f)
        }
        super.onSteppedOn(world, pos, state, entity)
    }

    fun isLit(state: BlockState): Boolean {
        return state.get(LIT) as Boolean
    }
    fun hasBootsOn(entity: Entity): Boolean {
        if((entity is LivingEntity)) {
            val boots: ItemStack = entity.getEquippedStack(EquipmentSlot.FEET)
            return boots != ItemStack.EMPTY;
        }
        return false
    }

}
