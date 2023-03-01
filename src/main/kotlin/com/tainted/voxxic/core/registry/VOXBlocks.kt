package com.tainted.voxxic.core.registry

import com.tainted.voxxic.common.block.BrewingPotBlock
import com.tainted.voxxic.common.block.BurnerBlock
import com.tainted.voxxic.common.block.MortarAndPestleBlock
import com.tainted.voxxic.common.block.ScoriteBlock
import com.tainted.voxxic.common.property.VOXProperties
import com.tainted.voxxic.core.registry.registryHelpers.BlockRegistryHelper
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.MapColor
import net.minecraft.block.Material
import net.minecraft.item.ItemGroup
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView
import java.util.function.ToIntFunction

//TODO Add More Blocks
class VOXBlocks {

    companion object: VOXProperties() {
        //Functions
        private fun createLightLevelFromLitState(lightLevel: Int): ToIntFunction<BlockState> {
            return ToIntFunction {blockState: BlockState -> if (blockState.get(LIT) as Boolean) lightLevel else 0 }}
        private fun createLightLevelFromSoakedState(lightLevel: Int): ToIntFunction<BlockState> {
            return ToIntFunction {blockState: BlockState -> if (blockState.get(SOAKED) as Boolean) lightLevel else 0 }}
        private fun whenSoaked(state: BlockState, world: BlockView, pos: BlockPos): Boolean {return state.get(SOAKED)}

        //Properties
        val SOAKED = LAVA_SOAKED
        val LIT = Properties.LIT

        //Blocks
        var BREWING_POT: Block? = null
        var MORTAR_AND_PESTLE: Block? = null
        var BURNER: Block? = null
        var SCORITE: Block? = null
    }

    fun register() {
        val HELPER = BlockRegistryHelper()
        MORTAR_AND_PESTLE = HELPER.registerBlock("mortar_and_pestle", MortarAndPestleBlock(FabricBlockSettings.of(Material.DECORATION, MapColor.DIRT_BROWN).breakInstantly()), FabricItemSettings().group(ItemGroup.DECORATIONS))
        BREWING_POT = HELPER.registerBlock("brewing_pot", BrewingPotBlock(FabricBlockSettings.of(Material.METAL, MapColor.STONE_GRAY).requiresTool().strength(3.5f).sounds(BlockSoundGroup.LANTERN).nonOpaque()), FabricItemSettings().group(ItemGroup.DECORATIONS))
        BURNER = HELPER.registerBlock("burner", BurnerBlock(FabricBlockSettings.of(Material.STONE, MapColor.RED).requiresTool().strength(3.5f)
            .luminance(createLightLevelFromLitState(10))), FabricItemSettings().group(ItemGroup.DECORATIONS))
        SCORITE = HELPER.registerBlock("scorite", ScoriteBlock(FabricBlockSettings.of(Material.STONE, MapColor.RED).requiresTool().strength(5.0f).sounds(BlockSoundGroup.NETHERRACK)
            .luminance(createLightLevelFromSoakedState(5)).postProcess(VOXBlocks::whenSoaked).emissiveLighting(VOXBlocks::whenSoaked)), FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS))
    }

}