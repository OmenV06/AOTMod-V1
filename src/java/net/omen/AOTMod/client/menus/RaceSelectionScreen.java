package net.omen.AOTMod.client.menus;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.omen.AOTMod.networking.ModPackets;
import net.omen.AOTMod.networking.packet.RaceC2SPacket;

import java.util.Random;
import java.util.UUID;

public class RaceSelectionScreen extends Screen {

    public RaceSelectionScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        int buttonWidth = 200;
        int buttonHeight = 20;
        int spacing = 30;


        int startY = (this.height - (3 * buttonHeight + 2 * spacing)) / 2;

        this.addRenderableWidget(new Button(this.width / 2 - buttonWidth / 2, startY, buttonWidth, buttonHeight,
                Component.literal("Eldian"), button -> {

            String race = "Eldian";
            Random random = new Random();
            if (random.nextInt(100) == 0) {
                race = "Royal Eldian";
            }

            ModPackets.sendToServer(new RaceC2SPacket(Minecraft.getInstance().player.getUUID(), race));
            Minecraft.getInstance().setScreen(null);
        }));

        this.addRenderableWidget(new Button(this.width / 2 - buttonWidth / 2, startY + buttonHeight + spacing, buttonWidth, buttonHeight,
                Component.literal("Ackerman"), button -> {

            ModPackets.sendToServer(new RaceC2SPacket(Minecraft.getInstance().player.getUUID(), "Ackerman"));
            Minecraft.getInstance().setScreen(null);
        }));

        this.addRenderableWidget(new Button(this.width / 2 - buttonWidth / 2, startY + 2 * (buttonHeight + spacing), buttonWidth, buttonHeight,
                Component.literal("Marleyan"), button -> {

            ModPackets.sendToServer(new RaceC2SPacket(Minecraft.getInstance().player.getUUID(), "Marleyan"));
            Minecraft.getInstance().setScreen(null);
        }));

        if (Minecraft.getInstance().player.getUUID().equals(MY_UUID)) {
            this.addRenderableWidget(new Button(this.width / 2 - buttonWidth / 2, startY + 3 * (buttonHeight + spacing), buttonWidth, buttonHeight,
                    Component.literal("Royal Eldian"), button -> {
                ModPackets.sendToServer(new RaceC2SPacket(Minecraft.getInstance().player.getUUID(), "Royal Eldian"));
                Minecraft.getInstance().setScreen(null);
            }));
        }
    }

    private static final UUID MY_UUID = UUID.fromString("3be683c5-84eb-4a4b-adc9-cf57cc1f7d88");

    @Override
    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        // Additional rendering like drawing text
    }
}
