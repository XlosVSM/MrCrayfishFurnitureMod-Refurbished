package com.mrcrayfish.furniture.refurbished.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrcrayfish.furniture.refurbished.data.tag.BlockTagSupplier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.List;

/**
 * Author: MrCrayfish
 */
public class ColouredKitchenCabinetryBlock extends KitchenCabinetryBlock implements BlockTagSupplier
{
    private static final MapCodec<ColouredKitchenCabinetryBlock> CODEC = RecordCodecBuilder.mapCodec(builder -> {
        return builder.group(DyeColor.CODEC.fieldOf("color").forGetter(block -> {
            return block.color;
        }), propertiesCodec()).apply(builder, ColouredKitchenCabinetryBlock::new);
    });

    private final DyeColor color;

    public ColouredKitchenCabinetryBlock(DyeColor color, Properties properties)
    {
        super(properties);
        this.color = color;
    }

    public DyeColor getDyeColor()
    {
        return this.color;
    }

    @Override
    protected MapCodec<ColouredKitchenCabinetryBlock> codec()
    {
        return CODEC;
    }

    @Override
    public List<TagKey<Block>> getTags()
    {
        return List.of(BlockTags.MINEABLE_WITH_AXE);
    }
}
