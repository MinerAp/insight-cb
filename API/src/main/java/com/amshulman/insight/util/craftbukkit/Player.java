package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

public abstract class Player {

    private static Player INSTANCE;

    public static final Player getInstance() {
        return INSTANCE;
    }

    public abstract void sendRawMessage(@Nonnull org.bukkit.entity.Player player, @Nonnull String message);
}
