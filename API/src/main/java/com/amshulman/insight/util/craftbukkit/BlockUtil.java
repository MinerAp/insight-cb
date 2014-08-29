package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.block.Block;

public abstract class BlockUtil {

    private static BlockUtil INSTANCE;

    public static final BlockUtil getInstance() {
        return INSTANCE;
    }

    public abstract boolean willIgnite(@Nonnull Block block);
}
