package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public abstract class Merchant {

    private static Merchant INSTANCE;

    static final Merchant getInstance() {
        return INSTANCE;
    }

    public abstract Location getLocation(@Nonnull Inventory inv);
}
