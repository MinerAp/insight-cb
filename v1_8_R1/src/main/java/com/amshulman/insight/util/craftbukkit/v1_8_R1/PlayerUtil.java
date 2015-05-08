package com.amshulman.insight.util.craftbukkit.v1_8_R1;

import javax.annotation.Nonnull;

import lombok.SneakyThrows;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.ExceptionInvalidSyntax;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.bukkit.craftbukkit.libs.com.google.gson.JsonParseException;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public final class PlayerUtil extends com.amshulman.insight.util.craftbukkit.PlayerUtil {

    @Override
    @SneakyThrows
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
