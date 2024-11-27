package net.omen.AOTMod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {

    public static final CreativeModeTab AOT_TAB = new CreativeModeTab("aot_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ICEBURST.get());
        }
    };
}
