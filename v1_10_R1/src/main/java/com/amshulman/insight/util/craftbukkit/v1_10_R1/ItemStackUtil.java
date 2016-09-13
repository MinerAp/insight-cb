package com.amshulman.insight.util.craftbukkit.v1_10_R1;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_10_R1.ItemStack;
import net.minecraft.server.v1_10_R1.NBTTagCompound;

import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

public final class ItemStackUtil extends com.amshulman.insight.util.craftbukkit.ItemStackUtil {

    @Override
    public JsonElement serializeItemAsJson(@Nonnull org.bukkit.inventory.ItemStack itemStack) {
        ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);
        if (nmsItemStack == null) {
            return JsonNull.INSTANCE;
        }
        NBTTagCompound compound = new NBTTagCompound();
        compound = nmsItemStack.save(compound);
        return new JsonPrimitive(compound.toString());
    }
}
