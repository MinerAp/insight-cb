package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public abstract class EnderChest {

    private static EnderChest INSTANCE;

    static final EnderChest getInstance() {
        return INSTANCE;
    }

    public abstract Location getLocation(@Nonnull Inventory inventory);
}
