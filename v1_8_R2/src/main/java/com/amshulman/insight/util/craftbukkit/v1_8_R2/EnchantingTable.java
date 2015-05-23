package com.amshulman.insight.util.craftbukkit.v1_8_R2;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_8_R2.BlockPosition;
import net.minecraft.server.v1_8_R2.ContainerEnchantTable;
import net.minecraft.server.v1_8_R2.World;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.inventory.CraftInventoryEnchanting;
import org.bukkit.inventory.Inventory;

public final class EnchantingTable extends com.amshulman.insight.util.craftbukkit.EnchantingTable {

    private static Field containerEnchantTableField;
    private static Field enchantTableWorldField;
    private static Field enchantTablePositionField;

    public EnchantingTable() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
        containerEnchantTableField = Class.forName(ContainerEnchantTable.class.getName() + "$1").getDeclaredField("this$0");
        enchantTableWorldField = ContainerEnchantTable.class.getDeclaredField("world");
        enchantTablePositionField = ContainerEnchantTable.class.getDeclaredField("position");

        containerEnchantTableField.setAccessible(true);
        enchantTableWorldField.setAccessible(true);
        enchantTablePositionField.setAccessible(true);
    }

    @Override
    public Location getLocation(@Nonnull Inventory inventory) {
        try {
            ContainerEnchantTable enchantTable = (ContainerEnchantTable) containerEnchantTableField.get(((CraftInventoryEnchanting) inventory).getInventory());
            World w = (World) enchantTableWorldField.get(enchantTable);
            BlockPosition pos = (BlockPosition) enchantTablePositionField.get(enchantTable);
            return new Location(w.getWorld(), pos.getX(), pos.getY(), pos.getZ());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
