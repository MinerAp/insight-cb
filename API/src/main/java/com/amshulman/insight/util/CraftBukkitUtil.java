package com.amshulman.insight.util;

import java.lang.reflect.Field;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.bukkit.plugin.java.JavaPlugin;

import com.amshulman.insight.util.craftbukkit.Anvil;
import com.amshulman.insight.util.craftbukkit.Block;
import com.amshulman.insight.util.craftbukkit.EnchantingTable;
import com.amshulman.insight.util.craftbukkit.EnderChest;
import com.amshulman.insight.util.craftbukkit.Merchant;
import com.amshulman.insight.util.craftbukkit.NMSItemStack;
import com.amshulman.insight.util.craftbukkit.Player;
import com.amshulman.insight.util.craftbukkit.Workbench;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CraftBukkitUtil {

    public static void initialize(JavaPlugin plugin) throws ClassCastException, IllegalArgumentException, NoSuchFieldException, ReflectiveOperationException, SecurityException {
        String packageName = plugin.getServer().getClass().getPackage().getName();
        String version = packageName.substring(packageName.lastIndexOf('.') + 1);

        plugin.getLogger().info("Detected NMS " + version);

        initialize(Anvil.class, version);
        initialize(Block.class, version);
        initialize(EnchantingTable.class, version);
        initialize(EnderChest.class, version);
        initialize(NMSItemStack.class, version);
        initialize(Merchant.class, version);
        initialize(Player.class, version);
        initialize(Workbench.class, version);
    }

    @SuppressWarnings("unchecked")
    public static <T> void initialize(Class<T> apiClass, String version) throws ClassCastException, IllegalArgumentException, ReflectiveOperationException, SecurityException {
        Class<T> clazz = (Class<T>) Class.forName("com.amshulman.insight.util.craftbukkit." + version + "." + apiClass.getSimpleName());

        Field instanceField = apiClass.getDeclaredField("INSTANCE");
        instanceField.setAccessible(true);
        instanceField.set(null, clazz.getConstructor().newInstance());
        instanceField.setAccessible(false);
    }
}
