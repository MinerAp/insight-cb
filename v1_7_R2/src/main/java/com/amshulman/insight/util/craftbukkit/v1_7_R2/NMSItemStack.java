package com.amshulman.insight.util.craftbukkit.v1_7_R2;

import net.minecraft.server.v1_7_R2.NBTTagCompound;

import org.bukkit.craftbukkit.v1_7_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public final class NMSItemStack extends com.amshulman.insight.util.craftbukkit.NMSItemStack {

    @Override
    public String getTag(ItemStack itemStack) {
        NBTTagCompound tag = CraftItemStack.asNMSCopy(itemStack).getTag();
        return tag == null ? null : tag.toString();
    }
}
