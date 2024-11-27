package net.owen.AOTMod.client.menus;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.owen.AOTMod.networking.packet.SyncPlayerRacePacket;

public class AbilitiesMenu extends Screen {
    private final Screen parent;

    public AbilitiesMenu(Screen parent) {
        super(Component.literal("Abilities"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        super.init();
        // List and display abilities here
        // For each ability, create a button or interactive element
        // that allows assigning it to a slot in the Ability Bar

        // Example: Button for each ability
        // this.addRenderableWidget(new Button(x, y, width, height, Component.literal("Ability Name"), button -> assignAbilityToSlot("Ability Name")));
    }

    private void assignAbilityToSlot(String abilityName) {
        // Logic to assign the selected ability to a slot
        // This might involve communicating with the server or updating some client-side data structure
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public void onClose() {
        // Return to the parent screen (PlayerStatMenu) when this screen is closed
        Minecraft.getInstance().setScreen(parent);
    }
}