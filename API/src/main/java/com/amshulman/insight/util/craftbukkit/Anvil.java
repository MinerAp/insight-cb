package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public abstract class Anvil {

    private static Anvil INSTANCE;

    public static final Anvil getInstance() {
        return INSTANCE;
    }

    public abstract Location getLocation(@Nonnull Inventory inv);
}
