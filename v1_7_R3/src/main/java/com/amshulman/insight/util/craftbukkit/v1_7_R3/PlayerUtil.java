package com.amshulman.insight.util.craftbukkit.v1_7_R3;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_7_R3.ChatSerializer;
import net.minecraft.server.v1_7_R3.EntityPlayer;
import net.minecraft.server.v1_7_R3.ExceptionInvalidSyntax;
import net.minecraft.server.v1_7_R3.IChatBaseComponent;
import net.minecraft.util.com.google.gson.JsonParseException;
import net.minecraft.util.org.apache.commons.lang3.exception.ExceptionUtils;

import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public final class PlayerUtil extends com.amshulman.insight.util.craftbukkit.PlayerUtil {

    @Override
    public void sendRawMessages(@Nonnull Player player, @Nonnull String[] messages) {
        EntityPlayer localEntityPlayer = ((CraftPlayer) player).getHandle();

        try {
            for (String message : messages) {
                IChatBaseComponent localIChatBaseComponent = ChatSerializer.a(message);
                localEntityPlayer.sendMessage(localIChatBaseComponent);
            }
        } catch (JsonParseException localJsonParseException) {
            Throwable localThrowable = ExceptionUtils.getRootCause(localJsonParseException);
            throw new ExceptionInvalidSyntax("commands.tellraw.jsonException", new Object[] { localThrowable == null ? "" : localThrowable.getMessage() });
        }
    }
}
