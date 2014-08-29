package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public abstract class EnchantingTable {

    private static EnchantingTable INSTANCE;

    static final EnchantingTable getInstance() {
        return INSTANCE;
    }

    public abstract Location getLocation(@Nonnull Inventory inventory);
}
