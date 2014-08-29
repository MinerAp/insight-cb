package com.amshulman.insight.util.craftbukkit.v1_7_R1;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_7_R1.InventoryEnderChest;
import net.minecraft.server.v1_7_R1.TileEntity;
import net.minecraft.server.v1_7_R1.TileEntityEnderChest;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R1.inventory.CraftInventory;
import org.bukkit.inventory.Inventory;

public final class EnderChest extends com.amshulman.insight.util.craftbukkit.EnderChest {

    private final Field tileEntityField;

    public EnderChest() throws NoSuchFieldException, SecurityException {
        tileEntityField = InventoryEnderChest.class.getDeclaredField("a");
        tileEntityField.setAccessible(true);
    }

    @Override
    public Location getLocation(@Nonnull Inventory inventory) {
        try {
            TileEntity tileEntity = (TileEntityEnderChest) tileEntityField.get(((CraftInventory) inventory).getInventory());
            return new Location(tileEntity.getWorld().getWorld(), tileEntity.x, tileEntity.y, tileEntity.z);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
