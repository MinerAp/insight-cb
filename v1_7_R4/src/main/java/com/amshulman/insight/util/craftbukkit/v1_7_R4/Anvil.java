package com.amshulman.insight.util.craftbukkit.v1_7_R4;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_7_R4.ContainerAnvil;
import net.minecraft.server.v1_7_R4.ContainerAnvilInventory;
import net.minecraft.server.v1_7_R4.World;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftInventoryAnvil;
import org.bukkit.inventory.Inventory;

public final class Anvil extends com.amshulman.insight.util.craftbukkit.Anvil {

    private static Field containerAnvilField;
    private static Field anvilWorldField;
    private static Field anvilXField;
    private static Field anvilYField;
    private static Field anvilZField;

    public Anvil() throws NoSuchFieldException, SecurityException {
        containerAnvilField = ContainerAnvilInventory.class.getDeclaredField("a");
        anvilWorldField = ContainerAnvil.class.getDeclaredField("i");
        anvilXField = ContainerAnvil.class.getDeclaredField("j");
        anvilYField = ContainerAnvil.class.getDeclaredField("k");
        anvilZField = ContainerAnvil.class.getDeclaredField("l");

        containerAnvilField.setAccessible(true);
        anvilWorldField.setAccessible(true);
        anvilXField.setAccessible(true);
        anvilYField.setAccessible(true);
        anvilZField.setAccessible(true);
    }

    @Override
    public Location getLocation(@Nonnull Inventory inventory) {
        try {
            ContainerAnvil anvil = (ContainerAnvil) containerAnvilField.get(((CraftInventoryAnvil) inventory).getInventory());
            World w = (World) anvilWorldField.get(anvil);
            int x = (Integer) anvilXField.get(anvil);
            int y = (Integer) anvilYField.get(anvil);
            int z = (Integer) anvilZField.get(anvil);
            return new Location(w.getWorld(), x, y, z);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
