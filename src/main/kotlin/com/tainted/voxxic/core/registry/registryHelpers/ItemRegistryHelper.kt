package com.tainted.voxxic.core.registry.registryHelpers

import com.tainted.voxxic.core.Voxxic.MOD_ID
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

class ItemRegistryHelper() {

    fun registerItem(id: String, item: Item): Item {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, id), item)
        return item
    }
    fun registerItem(id: String, itemSettings: FabricItemSettings): Item {
        val item = Item(itemSettings)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, id), item)
        return item
    }

}