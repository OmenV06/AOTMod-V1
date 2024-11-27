package net.owen.AOTMod.client.abilitybar;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AbilityBarHandler {
    private static boolean isAbilityBarActive = false;

    public static void toggleAbilityBar() {
        isAbilityBarActive = !isAbilityBarActive;
        // You might want to send a packet to the server to notify about this state change
    }

    public static boolean isAbilityBarActive() {
        return isAbilityBarActive;
    }

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent event) {
        if (AbilityBarHandler.isAbilityBarActive()) {
            PoseStack matrixStack = event.getPoseStack();
            // Custom rendering code for the ability bar


            renderAbilityBar(matrixStack);
        }
    }

    public static void renderAbilityBar(PoseStack matrixStack) {
        Minecraft minecraft = Minecraft.getInstance();
        Gui gui = minecraft.gui;

        RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);

        // Adjust these values to properly align with the default hotbar
        int xStart = (minecraft.getWindow().getGuiScaledWidth() / 2) - 91;
        int yStart = minecraft.getWindow().getGuiScaledHeight() - 22;

        // Apply additional translation if necessary
        int xOffset = 0; // Adjust this value as needed
        int yOffset = 0; // Adjust this value as needed
        xStart += xOffset;
        yStart += yOffset;

        // Draw the hotbar background
        gui.blit(matrixStack, xStart, yStart, 0, 0, 182, 22);

        // Loop through hotbar slots (0-8) and render each ability icon
        for (int i = 0; i < 9; i++) {
            // For demonstration, this uses the inventory slot texture.
            // You'll replace this with your ability icon rendering logic.
            int x = xStart + i * 20 + 2;
            int y = yStart + 3;
            gui.blit(matrixStack, x, y, 2, 3, 16, 16, 256, 256);

            // Add ability icon rendering here
            // Example: Render your ability icons based on the player's current abilities
        }
    }
    private static final ResourceLocation WIDGETS_LOCATION = new ResourceLocation("textures/gui/widgets.png");



}