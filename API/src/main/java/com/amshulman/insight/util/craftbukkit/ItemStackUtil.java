package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

public abstract class ItemStackUtil {

    private static ItemStackUtil INSTANCE;

    public static final ItemStackUtil getInstance() {
        return INSTANCE;
    }

    public abstract String getTag(@Nonnull ItemStack itemStack);
}
