package net.owen.AOTMod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.owen.AOTMod.AOTMod;
import net.owen.AOTMod.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AOTMod.MOD_ID);

    public static final RegistryObject<Item> ICEBURST = ITEMS.register("iceburst",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> IRON_BAMBOO = ITEMS.register("iron_bamboo",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> ULTRA_HARD_STEEL = ITEMS.register("ultra_hard_steel",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> ODMG_BLADE = ITEMS.register( "odmg_blade",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> ODMG_HANDLE = ITEMS.register( "odmg_handle",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> ODMG_SWORD = ITEMS.register( "odmg_sword",
            () -> new SwordItem (ModToolTiers.ODMG_SWORD, 4, -2, new Item.Properties()
                    .tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> ODMG_GEAR = ITEMS.register( "odmg_gear",
            () -> new ODMGDeviceItem ());

    public static final RegistryObject<Item> STEEL_WIRE = ITEMS.register("steel_wire",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> THUNDER_SPEAR = ITEMS.register("thunder_spear",
            () -> new ThunderSpearItem(new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB).stacksTo(1)));

    public static final RegistryObject<Item> THUNDER_SPEAR4X = ITEMS.register("thunder_spear4x",
            () -> new ThunderSpear4XItem(new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB).stacksTo(1)));

    public static final RegistryObject<Item> ODMG_CANISTER = ITEMS.register("odmg_canister",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> ODMG_SHEATH = ITEMS.register("odmg_sheath",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> ODMG_CORE = ITEMS.register("odmg_core",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> WIRE_CASING = ITEMS.register("wire_casing",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> TURBINE = ITEMS.register("turbine",
            () -> new Item (new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> TITAN_SERUM = ITEMS.register("titan_serum",
            () -> new TitanSerumItem(new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));

    public static final RegistryObject<Item> ATTACK_TITAN_SERUM = ITEMS.register("attack_titan_serum",
            () -> new AttackTitanSerumItem(new Item.Properties().tab(ModCreativeModeTabs.AOT_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
