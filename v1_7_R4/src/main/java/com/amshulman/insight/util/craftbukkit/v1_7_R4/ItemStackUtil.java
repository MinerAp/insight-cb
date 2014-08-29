package com.amshulman.insight.util.craftbukkit.v1_7_R4;

import net.minecraft.server.v1_7_R4.NBTTagCompound;

import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public final class ItemStackUtil extends com.amshulman.insight.util.craftbukkit.ItemStackUtil {

    @Override
    public String getTag(ItemStack itemStack) {
        NBTTagCompound tag = CraftItemStack.asNMSCopy(itemStack).getTag();
        return tag == null ? null : tag.toString();
    }
}
