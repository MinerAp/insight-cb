package com.amshulman.insight.util.craftbukkit.v1_8_R1;

import javax.annotation.Nonnull;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R1.util.CraftMagicNumbers;

public final class BlockUtil extends com.amshulman.insight.util.craftbukkit.BlockUtil {

    @Override
    public boolean willIgnite(@Nonnull Block block) {
        return CraftMagicNumbers.getBlock(block).d();
    }
}
