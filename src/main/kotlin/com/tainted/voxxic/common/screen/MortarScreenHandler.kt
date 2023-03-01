package com.tainted.voxxic.common.screen

import com.tainted.voxxic.core.registry.VOXHandlers
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot


class MortarScreenHandler(syncId: Int, inventory: PlayerInventory) : ScreenHandler(VOXHandlers.MORTAR_SCREEN_TYPE, syncId) {

    val mortarSegment: Inventory = SimpleInventory(4);

    override fun canUse(player: PlayerEntity): Boolean {
        return mortarSegment.canPlayerUse(player);
    }

    init {
        var m: Int;
        var l: Int;
        // Recipe Output
        addSlot(object : Slot(mortarSegment, 3, 132, 38) {
            override fun canInsert(stack: ItemStack): Boolean {
                return false
            }
        })

        // Recipe Inputs
        m = 0
        while (m < 3) {
            addSlot(Slot(mortarSegment,  m, 25 + m * 20, 38))
            m++
        }

        //Player inventory
        m = 0
        while (m < 3) {
            l = 0
            while (l < 9) {
                addSlot(Slot(inventory, l + m * 9 + 9, 8 + l * 18, 83 + m * 18))
                ++l
            }
            ++m
        }
        // Player Hotbar
        m = 0
        while (m < 9) {
            addSlot(Slot(inventory, m, 8 + m * 18, 141))
            ++m
        }
    }

    
    override fun transferSlot(player: PlayerEntity, index: Int): ItemStack {
        var itemStack: ItemStack = ItemStack.EMPTY;
        var slot: Slot? = slots[index];
        if (slot != null && slot.hasStack()) {
            var itemStack2: ItemStack = slot.stack;
            itemStack = itemStack2.copy();
            if(index == 0) {
                if(!insertItem(itemStack2, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (index in 4..40) {
                if(!insertItem(itemStack2, 1, 4, false)) {
                    if (index < 32) {
                        if(!insertItem(itemStack2, 32, 40, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if(!insertItem(itemStack2, 4, 32, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if(!insertItem(itemStack2, 4, 40, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty) {
                slot.stack = ItemStack.EMPTY;
            } else {
                slot.markDirty();
            }

            if (itemStack2.count == itemStack.count) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, itemStack2);
            if(index == 0) {
                player.dropItem(itemStack2, false);
            }
        }
        return itemStack;
    }
}