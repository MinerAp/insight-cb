package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

public abstract class NMSItemStack {

    private static NMSItemStack INSTANCE;

    public static final NMSItemStack getInstance() {
        return INSTANCE;
    }

    public abstract String getTag(@Nonnull ItemStack stack);
}
