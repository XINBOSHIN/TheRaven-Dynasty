package com.xinboshin.theravendynasty.blocks;

import jdk.nashorn.internal.ir.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlocksRegister {
    public static Block MIRROR_BLOCK = new BlockMirror("mirror_block");
    public static void register() {
    setRegister(MIRROR_BLOCK);
    }
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(MIRROR_BLOCK);
    }

    private static void setRegister(Block block) {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Block block) {

    }
}



//регистрация блоков и остальных классов