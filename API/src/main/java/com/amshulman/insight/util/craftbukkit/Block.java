package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

public abstract class Block {

    private static Block INSTANCE;

    public static final Block getInstance() {
        return INSTANCE;
    }

    public abstract boolean willIgnite(@Nonnull org.bukkit.block.Block block);
}
