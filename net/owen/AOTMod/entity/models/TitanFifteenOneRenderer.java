package net.owen.AOTMod.entity.models;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.owen.AOTMod.AOTMod;
import net.owen.AOTMod.entity.custom.TitanFifteenOneEntity;

public class TitanFifteenOneRenderer extends MobRenderer<TitanFifteenOneEntity, TitanFifteenOneModel<TitanFifteenOneEntity>> {
    public TitanFifteenOneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TitanFifteenOneModel<>(pContext.bakeLayer(ModModelLayers.TITAN_FIFTEEN_ONE_LAYER)), 2.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(TitanFifteenOneEntity TitanFifteenOneEntity) {
        return new ResourceLocation(AOTMod.MOD_ID, "textures/entity/titan_fifteen_one.png");
    }
}
