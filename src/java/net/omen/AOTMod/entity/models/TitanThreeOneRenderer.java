package net.omen.AOTMod.entity.models;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.omen.AOTMod.AOTMod;
import net.omen.AOTMod.entity.custom.TitanThreeOneEntity;

public class TitanThreeOneRenderer extends MobRenderer<TitanThreeOneEntity, TitanThreeOneModel<TitanThreeOneEntity>> {
    public TitanThreeOneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TitanThreeOneModel<>(pContext.bakeLayer(ModModelLayers.TITAN_THREE_ONE_LAYER)), 0.90f);
    }

    @Override
    public ResourceLocation getTextureLocation(TitanThreeOneEntity TitanThreeOneEntity) {
        return new ResourceLocation(AOTMod.MOD_ID, "textures/entity/titan_three_one.png");
    }
}
