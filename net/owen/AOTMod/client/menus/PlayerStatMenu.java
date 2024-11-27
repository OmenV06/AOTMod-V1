package net.owen.AOTMod.client.menus;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.owen.AOTMod.networking.packet.SyncPlayerRacePacket;

public class PlayerStatMenu extends Screen {
    private final Player player;

    public PlayerStatMenu(Player player) {
        super(Component.literal("Player Stats"));
        this.player = player;
    }

    @Override
    protected void init() {
        super.init();

        // Other UI elements...

        // Button to open the abilities submenu
        this.addRenderableWidget(new Button(this.width / 2 - 50, this.height / 2 + 20, 100, 20,
                Component.literal("Abilities"), button -> {
            Minecraft.getInstance().setScreen(new AbilitiesMenu(this));
        }));
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);

        String race = SyncPlayerRacePacket.getClientPlayerRace();

        int textHeight = this.height / 2; // Original height
        int adjustedHeight = textHeight - 60;
        drawCenteredString(poseStack, this.font, "Race: " + race, this.width / 2, adjustedHeight, 0xFFFFFF);
    }

    @Override
    public boolean isPauseScreen() {
        return true;
    }
}