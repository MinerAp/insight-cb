package com.amshulman.insight.util.craftbukkit.v1_7_R4;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_7_R4.ContainerWorkbench;
import net.minecraft.server.v1_7_R4.InventoryCrafting;
import net.minecraft.server.v1_7_R4.World;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftInventoryCrafting;
import org.bukkit.inventory.Inventory;

public final class Workbench extends com.amshulman.insight.util.craftbukkit.Workbench {

    private static Field containerWorkbenchField;
    private static Field workbenchWorldField;
    private static Field workbenchXField;
    private static Field workbenchYField;
    private static Field workbenchZField;

    public Workbench() throws NoSuchFieldException, SecurityException {
        containerWorkbenchField = InventoryCrafting.class.getDeclaredField("c");
        workbenchWorldField = ContainerWorkbench.class.getDeclaredField("g");
        workbenchXField = ContainerWorkbench.class.getDeclaredField("h");
        workbenchYField = ContainerWorkbench.class.getDeclaredField("i");
        workbenchZField = ContainerWorkbench.class.getDeclaredField("j");

        containerWorkbenchField.setAccessible(true);
        workbenchWorldField.setAccessible(true);
        workbenchXField.setAccessible(true);
        workbenchYField.setAccessible(true);
        workbenchZField.setAccessible(true);
    }

    @Override
    public Location getLocation(@Nonnull Inventory inventory) {
        try {
            ContainerWorkbench workbench = (ContainerWorkbench) containerWorkbenchField.get(((CraftInventoryCrafting) inventory).getInventory());
            World w = (World) workbenchWorldField.get(workbench);
            int x = (Integer) workbenchXField.get(workbench);
            int y = (Integer) workbenchYField.get(workbench);
            int z = (Integer) workbenchZField.get(workbench);
            return new Location(w.getWorld(), x, y, z);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
