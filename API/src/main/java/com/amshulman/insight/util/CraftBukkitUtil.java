package com.amshulman.insight.util;

import java.lang.reflect.Field;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.bukkit.plugin.java.JavaPlugin;

import com.amshulman.insight.util.craftbukkit.BlockUtil;
import com.amshulman.insight.util.craftbukkit.ItemStackUtil;
import com.amshulman.insight.util.craftbukkit.PlayerUtil;
import com.amshulman.insight.util.craftbukkit.Workbench;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CraftBukkitUtil {

    public static void initialize(JavaPlugin plugin) throws ClassCastException, IllegalArgumentException, NoSuchFieldException, ReflectiveOperationException, SecurityException {
        String packageName = plugin.getServer().getClass().getPackage().getName();
        String version = packageName.substring(packageName.lastIndexOf('.') + 1);

        plugin.getLogger().info("Detected NMS " + version);

        initialize(BlockUtil.class, version);
        initialize(ItemStackUtil.class, version);
        initialize(PlayerUtil.class, version);
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
