package com.amshulman.insight.util.craftbukkit.v1_8_R2;

import javax.annotation.Nonnull;

import net.minecraft.server.v1_8_R2.BlockPosition;
import net.minecraft.server.v1_8_R2.Blocks;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R2.CraftWorld;

public final class BlockUtil extends com.amshulman.insight.util.craftbukkit.BlockUtil {

    @Override
    public boolean willIgnite(@Nonnull Block block) {
        return Blocks.FIRE.e(((CraftWorld) block.getWorld()).getHandle(), new BlockPosition(block.getLocation().getX(), block.getLocation().getY(), block.getLocation().getZ()));
    }
}
