package net.owen.AOTMod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.owen.AOTMod.AOTMod;
import net.owen.AOTMod.item.ModCreativeModeTabs;
import net.owen.AOTMod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AOTMod.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    //Add blocks below

    public static final RegistryObject<Block> ULTRA_HARD_STEEL_BLOCK = registerBlock("ultra_hard_steel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(10.0f, 12.0f)
                    .sound(SoundType.METAL)), ModCreativeModeTabs.AOT_TAB);

    public static final RegistryObject<Block> TITAN_HARDENING = registerBlock("titan_hardening",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(50.0f, 1200.0f)
                    .lightLevel(blockState -> 3).sound(SoundType.GLASS)), ModCreativeModeTabs.AOT_TAB);



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
