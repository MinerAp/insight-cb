package com.amshulman.insight.util.craftbukkit.v1_7_R1;

import javax.annotation.Nonnull;

import org.bukkit.craftbukkit.v1_7_R1.util.CraftMagicNumbers;

public final class Block extends com.amshulman.insight.util.craftbukkit.Block {

    @Override
    public boolean willIgnite(@Nonnull org.bukkit.block.Block block) {
        return CraftMagicNumbers.getBlock(block).d();
    }
}
