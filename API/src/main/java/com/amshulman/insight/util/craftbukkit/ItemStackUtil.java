package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

import com.google.gson.JsonElement;

public abstract class ItemStackUtil {

    private static ItemStackUtil INSTANCE;

    public static final ItemStackUtil getInstance() {
        return INSTANCE;
    }

    public abstract JsonElement serializeItemAsJson(@Nonnull ItemStack itemStack);
}
