package com.tainted.voxxic.client.gui.screen

import com.tainted.voxxic.common.screen.MortarScreenHandler
import com.mojang.blaze3d.systems.RenderSystem
import com.tainted.voxxic.core.Voxxic
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class MortarScreen(handler: MortarScreenHandler, inventory: PlayerInventory, title: Text) : HandledScreen<MortarScreenHandler>(handler, inventory, title) {
    private val TEXTURE: Identifier = Identifier(Voxxic.MOD_ID, "textures/gui/container/mortar_and_pestle.png");
    private var backgroundWidth = 176;
    private var backgroundHeight = 168;
    private var playerInventoryTitleY = backgroundHeight - 93;

    override fun drawBackground(matrices: MatrixStack?, delta: Float, mouseX: Int, mouseY: Int) {
        renderBackground(matrices);
        RenderSystem.setShaderTexture(0, TEXTURE);
        val x = (width - backgroundWidth) / 2;
        val y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    override fun render(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    override fun init() {
        super.init();
        titleX = backgroundWidth / 7 - textRenderer.getWidth(title) / 2;
    }
}