package net.owen.AOTMod.entity.models;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.owen.AOTMod.AOTMod;
import net.owen.AOTMod.entity.custom.TitanFourOneEntity;

public class TitanFourOneRenderer extends MobRenderer<TitanFourOneEntity, TitanFourOneModel<TitanFourOneEntity>> {
    public TitanFourOneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TitanFourOneModel<>(pContext.bakeLayer(ModModelLayers.TITAN_FOUR_ONE_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(TitanFourOneEntity TitanFourOneEntity) {
        return new ResourceLocation(AOTMod.MOD_ID, "textures/entity/titan_four_one.png");
    }
}
