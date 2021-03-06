package mekanism.additions.common.block.plastic;

import mekanism.api.text.EnumColor;
import mekanism.common.block.interfaces.IColoredBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;

public class BlockPlasticGlowSlab extends SlabBlock implements IColoredBlock {

    private final EnumColor color;

    public BlockPlasticGlowSlab(EnumColor color) {
        super(Block.Properties.create(BlockPlastic.PLASTIC, color.getMapColor()).hardnessAndResistance(5F, 10F).setLightLevel(state -> 10));
        this.color = color;
    }

    @Override
    public EnumColor getColor() {
        return color;
    }
}