package net.omen.AOTMod.race.eldian;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import java.util.HashMap;
import java.util.Map;

public class TitanDataHandler extends SavedData {
    private static final String DATA_NAME = "Titan_Data";
    private final Map<String, String> titanHolders = new HashMap<>(); // Map of Titan names to player UUIDs

    public TitanDataHandler() {
        super();
    }

    @Override
    public CompoundTag save(CompoundTag compound) {
        CompoundTag titanData = new CompoundTag();
        for (Map.Entry<String, String> entry : titanHolders.entrySet()) {
            titanData.putString(entry.getKey(), entry.getValue());
        }
        compound.put("TitanHolders", titanData);
        return compound;
    }

    public static TitanDataHandler load(CompoundTag nbt) {
        TitanDataHandler data = new TitanDataHandler();
        CompoundTag titanData = nbt.getCompound("TitanHolders");
        for (String key : titanData.getAllKeys()) {
            data.titanHolders.put(key, titanData.getString(key));
        }
        return data;
    }

    public String getTitanHolder(String titanName) {
        return titanHolders.getOrDefault(titanName, "");
    }

    public void setTitanHolder(String titanName, String playerUUID) {
        titanHolders.put(titanName, playerUUID);
        setDirty();
    }

    public static TitanDataHandler get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(TitanDataHandler::load, TitanDataHandler::new, DATA_NAME);
    }

    // Additional methods as needed, e.g., to remove a Titan holder
}