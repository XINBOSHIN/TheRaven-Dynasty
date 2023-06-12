package com.xinboshin.theravendynasty.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;

public class BlockOre extends Block
{
    public BlockOre()
    {
        super(Block.Properties.create(Material.ROCK)  // look at Block.Properties for further options
                // typically useful: hardnessAndResistance(), harvestLevel(), harvestTool()
        );
    }

    // render using a BakedModel (mbe01_block_simple.json --> mbe01_block_simple_model.json)
    // not strictly required because the default (super method) is MODEL.
    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }
}
