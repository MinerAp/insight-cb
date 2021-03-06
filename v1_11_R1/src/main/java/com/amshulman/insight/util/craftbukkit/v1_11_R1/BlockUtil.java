package com.amshulman.insight.util.craftbukkit.v1_11_R1;

import javax.annotation.Nonnull;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;

import net.minecraft.server.v1_11_R1.BlockPosition;
import net.minecraft.server.v1_11_R1.Blocks;

public final class BlockUtil extends com.amshulman.insight.util.craftbukkit.BlockUtil {

    @Override
    public boolean willIgnite(@Nonnull Block block) {
        return Blocks.FIRE.c(((CraftWorld) block.getWorld()).getHandle(), new BlockPosition(block.getLocation().getX(), block.getLocation().getY(), block.getLocation().getZ()));
    }
}
