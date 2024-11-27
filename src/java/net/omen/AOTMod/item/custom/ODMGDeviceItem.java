package net.omen.AOTMod.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.omen.AOTMod.AOTMod;
import net.omen.AOTMod.item.ModArmorMaterials;
import net.omen.AOTMod.item.ModCreativeModeTabs;
import net.omen.AOTMod.item.ModItems;
import net.omen.AOTMod.util.KeyBindings;

@Mod.EventBusSubscriber(modid = AOTMod.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ODMGDeviceItem extends ArmorItem {
    private static final int COOLDOWN_TIME = 35;
    private int cooldown = 0;

    public ODMGDeviceItem() {
        super(ModArmorMaterials.ODMG_GEAR, EquipmentSlot.LEGS, new Properties().tab(ModCreativeModeTabs.AOT_TAB).durability(300));
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModItems.ODMG_CANISTER.get());
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (KeyBindings.GEAR_BOOST.isDown()) {
            Player player = Minecraft.getInstance().player;
            if (player == null) return;

            ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
            if (leggings.getItem() instanceof ODMGDeviceItem) {
                activateGearBoost(player, leggings);
            }
        }
    }

    private static void activateGearBoost(Player player, ItemStack leggings) {
        ODMGDeviceItem odmgDevice = (ODMGDeviceItem) leggings.getItem();
        if (odmgDevice.cooldown > 0 || leggings.getOrCreateTag().getBoolean("IsBroken")) {
            return;
        }

        applyBoost(player);
        spawnParticlesAroundPlayer(player.level, player);
        odmgDevice.cooldown = COOLDOWN_TIME;

        applyItemDamage(leggings);
    }

    private static void applyBoost(Player player) {
        Vec3 speed = player.getLookAngle().multiply(2.5, 2.5, 2.5);
        player.setDeltaMovement(speed.x, speed.y, speed.z);
    }

    private static void applyItemDamage(ItemStack item) {
        if (item.isDamageableItem()) {
            int newDamage = item.getDamageValue() + 6;
            item.setDamageValue(newDamage);

            if (newDamage >= item.getMaxDamage()) {
                item.getOrCreateTag().putBoolean("IsBroken", true);
                item.setDamageValue(item.getMaxDamage());
            }
            // Save damage to NBT
            item.getOrCreateTag().putInt("Damage", newDamage);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(net.minecraftforge.event.TickEvent.PlayerTickEvent event) {
        if (event.phase == net.minecraftforge.event.TickEvent.Phase.END) {
            Player player = event.player;
            ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);

            if (leggings.getItem() instanceof ODMGDeviceItem) {
                ODMGDeviceItem odmgDevice = (ODMGDeviceItem) leggings.getItem();
                // Load damage from NBT
                if (leggings.hasTag()) {
                    int storedDamage = leggings.getOrCreateTag().getInt("Damage");
                    leggings.setDamageValue(storedDamage);
                }

                if (odmgDevice.cooldown > 0) {
                    odmgDevice.cooldown--;
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof ODMGDeviceItem) {
                event.setDamageMultiplier(0.0F);
            }
        }
    }

    private static void spawnParticlesAroundPlayer(Level world, Player player) {
        for (int i = 0; i < 20; i++) {
            double offsetX = world.random.nextGaussian() * 0.2;
            double offsetY = world.random.nextGaussian() * 0.2;
            double offsetZ = world.random.nextGaussian() * 0.2;
            world.addParticle(ParticleTypes.POOF, player.getX() + offsetX, player.getY() + offsetY, player.getZ() + offsetZ, 0, 0, 0);
        }
    }
}