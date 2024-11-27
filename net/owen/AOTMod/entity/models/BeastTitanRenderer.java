package net.owen.AOTMod.entity.models;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.owen.AOTMod.AOTMod;
import net.owen.AOTMod.entity.custom.BeastTitanTestEntity;
import net.owen.AOTMod.entity.custom.TitanFifteenOneEntity;

public class BeastTitanRenderer extends MobRenderer<BeastTitanTestEntity, BeastTitanModel<BeastTitanTestEntity>> {
    public BeastTitanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BeastTitanModel<>(pContext.bakeLayer(ModModelLayers.BEAST_TITAN_LAYER)), 2.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(BeastTitanTestEntity BeastTitanTestEntity) {
        return new ResourceLocation(AOTMod.MOD_ID, "textures/entity/beast_titan.png");
    }
}
