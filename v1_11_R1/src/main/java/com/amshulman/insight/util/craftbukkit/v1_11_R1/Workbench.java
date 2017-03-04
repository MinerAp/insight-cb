package com.amshulman.insight.util.craftbukkit.v1_11_R1;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftInventoryCrafting;
import org.bukkit.inventory.Inventory;

import net.minecraft.server.v1_11_R1.BlockPosition;
import net.minecraft.server.v1_11_R1.ContainerWorkbench;
import net.minecraft.server.v1_11_R1.InventoryCrafting;
import net.minecraft.server.v1_11_R1.World;

public final class Workbench extends com.amshulman.insight.util.craftbukkit.Workbench {

    private static Field containerWorkbenchField;
    private static Field workbenchWorldField;
    private static Field workbenchPositionField;

    public Workbench() throws NoSuchFieldException, SecurityException {
        containerWorkbenchField = InventoryCrafting.class.getDeclaredField("d");
        workbenchWorldField = ContainerWorkbench.class.getDeclaredField("g");
        workbenchPositionField = ContainerWorkbench.class.getDeclaredField("h");

        containerWorkbenchField.setAccessible(true);
        workbenchWorldField.setAccessible(true);
        workbenchPositionField.setAccessible(true);
    }

    @Override
    public Location getLocation(@Nonnull Inventory inventory) {
        try {
            ContainerWorkbench workbench = (ContainerWorkbench) containerWorkbenchField.get(((CraftInventoryCrafting) inventory).getInventory());
            World w = (World) workbenchWorldField.get(workbench);
            BlockPosition pos = (BlockPosition) workbenchPositionField.get(workbench);
            return new Location(w.getWorld(), pos.getX(), pos.getY(), pos.getZ());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
