package mekanism.generators.common.item.generator;

import mekanism.common.item.IItemSustainedInventory;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.generators.common.block.generator.BlockTurbineValve;

public class ItemBlockTurbineValve extends ItemBlockTooltip implements IItemSustainedInventory {

    public ItemBlockTurbineValve(BlockTurbineValve block) {
        super(block);
    }
}