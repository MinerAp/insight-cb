package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public abstract class Workbench {

    private static Workbench INSTANCE;

    static final Workbench getInstance() {
        return INSTANCE;
    }

    public abstract Location getLocation(@Nonnull Inventory inventory);
}
