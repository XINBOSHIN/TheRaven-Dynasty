package com.tainted.voxxic.common.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

class ArcaneDust(settings: FabricItemSettings): Item(settings) {

    override fun hasGlint(stack: ItemStack): Boolean {return true}

}