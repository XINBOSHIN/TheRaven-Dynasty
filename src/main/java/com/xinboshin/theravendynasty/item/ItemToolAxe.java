package com.xinboshin.theravendynasty.item;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemToolAxe extends ItemAxe {
    public ItemToolAxe(String nam, Item.ToolMaterial) {
        super(material, 2, 2);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

    }
}

public static final Item.ToolMaterial TOOL_MATERIAL = EnumHelper.addToolMaterial("theravendynasty:tool", 2, 256, 50.0F, 2.0F. 12);
}