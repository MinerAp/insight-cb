package com.amshulman.insight.util.craftbukkit.v1_10_R1;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_10_R1.ItemStack;
import net.minecraft.server.v1_10_R1.NBTTagCompound;

import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;

public final class ItemStackUtil extends com.amshulman.insight.util.craftbukkit.ItemStackUtil {

    @Override
    public String serializeItemAsJson(@Nonnull org.bukkit.inventory.ItemStack itemStack) {
        ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);
        NBTTagCompound compound = new NBTTagCompound();
        compound = nmsItemStack.save(compound);
        return compound.toString();
    }
}
