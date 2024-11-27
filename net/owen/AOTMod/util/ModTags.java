package net.owen.AOTMod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.owen.AOTMod.AOTMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> TITAN_HARDENING = tag("titan_hardening");
        public static final TagKey<Block> ULTRA_HARD_STEEL_BLOCK = tag("ultra_hard_steel_block");


        private static TagKey<Block> tag(String name) {
           return BlockTags.create(new ResourceLocation(AOTMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(AOTMod.MOD_ID, name));
        }
    }
}