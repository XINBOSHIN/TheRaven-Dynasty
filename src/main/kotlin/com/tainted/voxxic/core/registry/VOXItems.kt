package com.tainted.voxxic.core.registry

import com.tainted.voxxic.common.item.ArcaneDust
import com.tainted.voxxic.core.registry.registryHelpers.ItemRegistryHelper
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Rarity

//TODO Add More Items
class VOXItems {

    companion object {
        var CHARCOAL_DUST: Item? = null
        var COAL_DUST: Item? = null
        var IRON_DUST: Item? = null
        var COPPER_DUST: Item? = null
        var GOLD_DUST: Item? = null
        var LAPIS_DUST: Item? = null
        var AMETHYST_DUST: Item? = null
        var DIAMOND_DUST: Item? = null
        var EMERALD_DUST: Item? = null
        var ARCANE_DUST: Item? = null
    }

    fun register() {
        val HELPER = ItemRegistryHelper()
        CHARCOAL_DUST = HELPER.registerItem("charcoal_dust", FabricItemSettings().group(ItemGroup.MATERIALS))
        COAL_DUST = HELPER.registerItem("coal_dust", FabricItemSettings().group(ItemGroup.MATERIALS))
        IRON_DUST = HELPER.registerItem("iron_dust", FabricItemSettings().group(ItemGroup.MATERIALS))
        COPPER_DUST = HELPER.registerItem("copper_dust", FabricItemSettings().group(ItemGroup.MATERIALS))
        GOLD_DUST = HELPER.registerItem("gold_dust", FabricItemSettings().group(ItemGroup.MATERIALS))
        LAPIS_DUST = HELPER.registerItem("lapis_dust", FabricItemSettings().group(ItemGroup.MATERIALS))
        AMETHYST_DUST = HELPER.registerItem("amethyst_dust", FabricItemSettings().group(ItemGroup.MATERIALS))
        DIAMOND_DUST = HELPER.registerItem("diamond_dust", FabricItemSettings().group(ItemGroup.MATERIALS))
        EMERALD_DUST = HELPER.registerItem("emerald_dust", FabricItemSettings().group(ItemGroup.MATERIALS))
        ARCANE_DUST = HELPER.registerItem("arcane_dust", ArcaneDust(FabricItemSettings().rarity(Rarity.UNCOMMON).group(ItemGroup.MATERIALS)))
    }

}