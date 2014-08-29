package com.amshulman.insight.util.craftbukkit;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;

public abstract class PlayerUtil {

    private static PlayerUtil INSTANCE;

    public static final PlayerUtil getInstance() {
        return INSTANCE;
    }

    public abstract void sendRawMessages(@Nonnull Player player, @Nonnull String[] messages);
}
