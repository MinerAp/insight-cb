package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public abstract class Anvil {

    private static Anvil INSTANCE;

    static final Anvil getInstance() {
        return INSTANCE;
    }

    public abstract Location getLocation(@Nonnull Inventory inventory);
}
