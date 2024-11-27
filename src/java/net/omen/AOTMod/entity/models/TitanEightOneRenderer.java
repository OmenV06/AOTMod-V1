package net.omen.AOTMod.entity.models;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.omen.AOTMod.AOTMod;
import net.omen.AOTMod.entity.custom.TitanEightOneEntity;

public class TitanEightOneRenderer extends MobRenderer<TitanEightOneEntity, TitanEightOneModel<TitanEightOneEntity>> {
    public TitanEightOneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TitanEightOneModel<>(pContext.bakeLayer(ModModelLayers.TITAN_EIGHT_ONE_LAYER)), 1.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(TitanEightOneEntity TitanEightOneEntity) {
        return new ResourceLocation(AOTMod.MOD_ID, "textures/entity/titan_eight_one.png");
    }
}
