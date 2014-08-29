package com.amshulman.insight.util.craftbukkit.v1_7_R2;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_7_R2.ContainerEnchantTable;
import net.minecraft.server.v1_7_R2.ContainerEnchantTableInventory;
import net.minecraft.server.v1_7_R2.World;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R2.inventory.CraftInventoryEnchanting;
import org.bukkit.inventory.Inventory;

public final class EnchantingTable extends com.amshulman.insight.util.craftbukkit.EnchantingTable {

    private static Field containerEnchantTableField;
    private static Field enchantTableWorldField;
    private static Field enchantTableXField;
    private static Field enchantTableYField;
    private static Field enchantTableZField;

    public EnchantingTable() throws NoSuchFieldException, SecurityException {
        containerEnchantTableField = ContainerEnchantTableInventory.class.getDeclaredField("enchantTable");
        enchantTableWorldField = ContainerEnchantTable.class.getDeclaredField("world");
        enchantTableXField = ContainerEnchantTable.class.getDeclaredField("x");
        enchantTableYField = ContainerEnchantTable.class.getDeclaredField("y");
        enchantTableZField = ContainerEnchantTable.class.getDeclaredField("z");

        containerEnchantTableField.setAccessible(true);
        enchantTableWorldField.setAccessible(true);
        enchantTableXField.setAccessible(true);
        enchantTableYField.setAccessible(true);
        enchantTableZField.setAccessible(true);
    }

    @Override
    public Location getLocation(@Nonnull Inventory inventory) {
        try {
            ContainerEnchantTable enchantTable = (ContainerEnchantTable) containerEnchantTableField.get(((CraftInventoryEnchanting) inventory).getInventory());
            World w = (World) enchantTableWorldField.get(enchantTable);
            int x = (Integer) enchantTableXField.get(enchantTable);
            int y = (Integer) enchantTableYField.get(enchantTable);
            int z = (Integer) enchantTableZField.get(enchantTable);
            return new Location(w.getWorld(), x, y, z);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
