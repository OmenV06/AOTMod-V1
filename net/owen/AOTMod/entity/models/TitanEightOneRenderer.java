package net.owen.AOTMod.entity.models;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.owen.AOTMod.AOTMod;
import net.owen.AOTMod.entity.custom.TitanEightOneEntity;
import net.owen.AOTMod.entity.custom.TitanThreeOneEntity;

public class TitanEightOneRenderer extends MobRenderer<TitanEightOneEntity, TitanEightOneModel<TitanEightOneEntity>> {
    public TitanEightOneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TitanEightOneModel<>(pContext.bakeLayer(ModModelLayers.TITAN_EIGHT_ONE_LAYER)), 1.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(TitanEightOneEntity TitanEightOneEntity) {
        return new ResourceLocation(AOTMod.MOD_ID, "textures/entity/titan_eight_one.png");
    }
}
