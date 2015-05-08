package com.amshulman.insight.util.craftbukkit.v1_8_R2;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_8_R2.EntityVillager;
import net.minecraft.server.v1_8_R2.InventoryMerchant;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.inventory.CraftInventoryMerchant;
import org.bukkit.inventory.Inventory;

public final class Merchant extends com.amshulman.insight.util.craftbukkit.Merchant {

    private final Field merchantField;

    public Merchant() throws NoSuchFieldException, SecurityException {
        merchantField = InventoryMerchant.class.getDeclaredField("merchant");
        merchantField.setAccessible(true);
    }

    @Override
    public Location getLocation(@Nonnull Inventory inventory) {
        try {
            EntityVillager entity = (EntityVillager) merchantField.get(((CraftInventoryMerchant) inventory).getInventory());
            return new Location(entity.world.getWorld(), entity.locX, entity.locY, entity.locZ, entity.yaw, entity.pitch);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
