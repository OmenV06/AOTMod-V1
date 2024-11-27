package net.omen.AOTMod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.omen.AOTMod.AOTMod;
import net.omen.AOTMod.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier ODMG_SWORD = TierSortingRegistry.registerTier(
            new ForgeTier(2, 5, 5f, 5f, 10,
                    ModTags.Blocks.ULTRA_HARD_STEEL_BLOCK, () -> Ingredient.of(ModItems.ODMG_SWORD.get())),
            new ResourceLocation(AOTMod.MOD_ID, "odmg_sword"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
}
//uses was 200