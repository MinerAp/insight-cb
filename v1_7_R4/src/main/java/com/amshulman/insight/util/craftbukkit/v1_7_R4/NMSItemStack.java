package com.amshulman.insight.util.craftbukkit.v1_7_R4;

import net.minecraft.server.v1_7_R4.NBTTagCompound;

import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public final class NMSItemStack extends com.amshulman.insight.util.craftbukkit.NMSItemStack {

    @Override
    public String getTag(ItemStack stack) {
        NBTTagCompound tag = CraftItemStack.asNMSCopy(stack).getTag();
        return tag == null ? null : tag.toString();
    }
}
