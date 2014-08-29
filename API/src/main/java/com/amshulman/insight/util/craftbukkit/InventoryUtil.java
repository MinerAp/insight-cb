package com.amshulman.insight.util.craftbukkit;

import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryUtil {

    public static Location getLocation(Inventory inventory) {
        // All cases are listed for documentation purposes
        switch (inventory.getType()) {
            case CHEST:
                if (inventory.getHolder() instanceof DoubleChest) {
                    return null;
                } else if (inventory.getHolder() instanceof Player) {
                    return ((Player) inventory.getHolder()).getLocation();
                } else {
                    return ((BlockState) inventory.getHolder()).getLocation();
                }

            case ANVIL:
                return Anvil.getInstance().getLocation(inventory);

            case ENCHANTING:
                return EnchantingTable.getInstance().getLocation(inventory);

            case ENDER_CHEST:
                return EnderChest.getInstance().getLocation(inventory);

            case MERCHANT:
                return Merchant.getInstance().getLocation(inventory);

            case WORKBENCH:
                return Workbench.getInstance().getLocation(inventory);

            case CRAFTING:
            case CREATIVE:
            case PLAYER:
                return ((Player) inventory.getHolder()).getLocation();

            case BEACON:
            case BREWING:
            case DISPENSER:
            case DROPPER:
            case FURNACE:
            case HOPPER:
                return ((BlockState) inventory.getHolder()).getLocation();
        }

        return null;
    }
}
