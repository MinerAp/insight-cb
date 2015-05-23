package com.amshulman.insight.util.craftbukkit.v1_8_R3;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.ContainerAnvil;
import net.minecraft.server.v1_8_R3.World;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftInventoryAnvil;
import org.bukkit.inventory.Inventory;

public final class Anvil extends com.amshulman.insight.util.craftbukkit.Anvil {

    private static Field containerAnvilField;
    private static Field anvilWorldField;
    private static Field anvilPositionField;

    public Anvil() throws NoSuchFieldException, SecurityException, ClassNotFoundException {
        containerAnvilField = Class.forName(ContainerAnvil.class.getName() + "$1").getDeclaredField("this$0");
        anvilWorldField = ContainerAnvil.class.getDeclaredField("i");
        anvilPositionField = ContainerAnvil.class.getDeclaredField("j");

        containerAnvilField.setAccessible(true);
        anvilWorldField.setAccessible(true);
        anvilPositionField.setAccessible(true);
    }

    @Override
    public Location getLocation(@Nonnull Inventory inventory) {
        try {
            ContainerAnvil anvil = (ContainerAnvil) containerAnvilField.get(((CraftInventoryAnvil) inventory).getInventory());
            World w = (World) anvilWorldField.get(anvil);
            BlockPosition pos = (BlockPosition) anvilPositionField.get(anvil);
            return new Location(w.getWorld(), pos.getX(), pos.getY(), pos.getZ());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
