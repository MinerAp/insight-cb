package com.amshulman.insight.util.craftbukkit.v1_11_R1;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.google.gson.JsonParseException;

import lombok.SneakyThrows;
import net.minecraft.server.v1_11_R1.EntityPlayer;
import net.minecraft.server.v1_11_R1.ExceptionInvalidSyntax;
import net.minecraft.server.v1_11_R1.IChatBaseComponent;
import net.minecraft.server.v1_11_R1.IChatBaseComponent.ChatSerializer;

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
