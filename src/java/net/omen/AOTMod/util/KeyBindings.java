package net.omen.AOTMod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final String KEY_CATEGORY_AOT = "key.category.aotmod";

    public static final String KEY_GEAR_BOOST = "key.aotmod.gear_boost";
    public static final String KEY_RACE_MENU = "key.aotmod.race_menu";

    public static final String KEY_ABILITY_BAR = "key.aotmod.ability_bar";
    public static final String KEY_ABILITY_ONE = "key.aotmod.ability_one";
    public static final String KEY_ABILITY_TWO = "key.aotmod.ability_two";
    public static final String KEY_ABILITY_THREE = "key.aotmod.ability_three";
    public static final String KEY_ABILITY_FOUR = "key.aotmod.ability_four";
    public static final String KEY_ABILITY_FIVE = "key.aotmod.ability_five";
    public static final String KEY_ABILITY_SIX = "key.aotmod.ability_six";
    public static final String KEY_ABILITY_SEVEN = "key.aotmod.ability_seven";
    public static final String KEY_ABILITY_EIGHT = "key.aotmod.ability_eight";
    public static final String KEY_ABILITY_NINE = "key.aotmod.ability_nine";


    public static final KeyMapping GEAR_BOOST = new KeyMapping(KEY_GEAR_BOOST, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_AOT);

    public static final KeyMapping RACE_MENU = new KeyMapping(KEY_RACE_MENU, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_DOWN, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_BAR = new KeyMapping(KEY_ABILITY_BAR, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_ALT, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_ONE = new KeyMapping(KEY_ABILITY_ONE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_1, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_TWO = new KeyMapping(KEY_ABILITY_TWO, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_2, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_THREE = new KeyMapping(KEY_ABILITY_THREE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_3, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_FOUR = new KeyMapping(KEY_ABILITY_FOUR, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_4, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_FIVE = new KeyMapping(KEY_ABILITY_FIVE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_5, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_SIX = new KeyMapping(KEY_ABILITY_SIX, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_6, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_SEVEN = new KeyMapping(KEY_ABILITY_SEVEN, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_7, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_EIGHT = new KeyMapping(KEY_ABILITY_EIGHT, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_8, KEY_CATEGORY_AOT);

    public static final KeyMapping ABILITY_NINE = new KeyMapping(KEY_ABILITY_NINE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_9, KEY_CATEGORY_AOT);

}
