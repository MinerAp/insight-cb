package com.amshulman.insight.util.craftbukkit.v1_7_R4;

import javax.annotation.Nonnull;

import org.bukkit.craftbukkit.v1_7_R4.util.CraftMagicNumbers;

public final class Block extends com.amshulman.insight.util.craftbukkit.Block {

    @Override
    public boolean willIgnite(@Nonnull org.bukkit.block.Block block) {
        return CraftMagicNumbers.getBlock(block).d();
    }
}
