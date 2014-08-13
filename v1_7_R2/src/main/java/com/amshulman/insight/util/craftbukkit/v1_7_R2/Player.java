package com.amshulman.insight.util.craftbukkit.v1_7_R2;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_7_R2.ChatSerializer;
import net.minecraft.server.v1_7_R2.EntityPlayer;
import net.minecraft.server.v1_7_R2.ExceptionInvalidSyntax;
import net.minecraft.server.v1_7_R2.IChatBaseComponent;
import net.minecraft.util.com.google.gson.JsonParseException;
import net.minecraft.util.org.apache.commons.lang3.exception.ExceptionUtils;

import org.bukkit.craftbukkit.v1_7_R2.entity.CraftPlayer;

public final class Player extends com.amshulman.insight.util.craftbukkit.Player {

    @Override
    public void sendRawMessage(@Nonnull org.bukkit.entity.Player player, @Nonnull String message) {
        EntityPlayer localEntityPlayer = ((CraftPlayer) player).getHandle();

        try {
            IChatBaseComponent localIChatBaseComponent = ChatSerializer.a(message);
            localEntityPlayer.sendMessage(localIChatBaseComponent);
        } catch (JsonParseException localJsonParseException) {
            Throwable localThrowable = ExceptionUtils.getRootCause(localJsonParseException);
            throw new ExceptionInvalidSyntax("commands.tellraw.jsonException", new Object[] { localThrowable == null ? "" : localThrowable.getMessage() });
        }
    }
}
