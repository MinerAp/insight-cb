package com.amshulman.insight.util.craftbukkit;

import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryUtil {

    public static Location getLocation(Inventory inventory) {
        // All cases are listed for documentation purposes
        switch (inventory.getType()) {
            case CHEST:
                if (inventory.getHolder() instanceof DoubleChest) {
                    return null;
                } else if (inventory.getHolder() instanceof Entity) {
                    return ((Entity) inventory.getHolder()).getLocation();
                } else {
                    return ((BlockState) inventory.getHolder()).getLocation();
                }

            case ENDER_CHEST:
                return EnderChest.getInstance().getLocation(inventory);

            case WORKBENCH:
                return Workbench.getInstance().getLocation(inventory);

            case CRAFTING:
            case CREATIVE:
            case PLAYER:
                return ((Player) inventory.getHolder()).getLocation();

            case ANVIL:
            case BEACON:
            case BREWING:
            case DISPENSER:
            case DROPPER:
            case ENCHANTING:
            case FURNACE:
            case HOPPER:
            case MERCHANT:
                return inventory.getLocation();
        }

        return null;
    }
}
