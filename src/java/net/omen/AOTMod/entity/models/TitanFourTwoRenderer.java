package net.omen.AOTMod.entity.models;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.omen.AOTMod.AOTMod;
import net.omen.AOTMod.entity.custom.TitanFourTwoEntity;

public class TitanFourTwoRenderer extends MobRenderer<TitanFourTwoEntity, TitanFourTwoModel<TitanFourTwoEntity>> {
    public TitanFourTwoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TitanFourTwoModel<>(pContext.bakeLayer(ModModelLayers.TITAN_FOUR_TWO_LAYER)), 1.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(TitanFourTwoEntity TitanFourTwoEntity) {
        return new ResourceLocation(AOTMod.MOD_ID, "textures/entity/titan_four_two.png");
    }
}
