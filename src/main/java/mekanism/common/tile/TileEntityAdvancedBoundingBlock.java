package mekanism.common.tile;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mekanism.api.IConfigCardAccess.ISpecialConfigData;
import mekanism.api.energy.IStrictEnergyAcceptor;
import mekanism.common.Mekanism;
import mekanism.common.base.IAdvancedBoundingBlock;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.integration.computer.IComputerIntegration;
import mekanism.common.tile.base.MekanismTileEntityTypes;
import mekanism.common.util.InventoryUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

//TODO: IC2
/*@InterfaceList({
      @Interface(iface = "ic2.api.energy.tile.IEnergySink", modid = MekanismHooks.IC2_MOD_ID)
})*/
public class TileEntityAdvancedBoundingBlock extends TileEntityBoundingBlock implements ISidedInventory, IStrictEnergyAcceptor, IComputerIntegration, ISpecialConfigData {

    public TileEntityAdvancedBoundingBlock() {
        super(MekanismTileEntityTypes.ADVANCED_BOUNDING_BLOCK);
    }

    @Override
    public boolean isEmpty() {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return true;
        }
        return inv.isEmpty();
    }

    @Override
    public int getSizeInventory() {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return 0;
        }
        return inv.getSizeInventory();
    }

    @Nonnull
    @Override
    public ItemStack getStackInSlot(int i) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return ItemStack.EMPTY;
        }
        return inv.getStackInSlot(i);
    }

    @Nonnull
    @Override
    public ItemStack decrStackSize(int i, int j) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return ItemStack.EMPTY;
        }
        return inv.decrStackSize(i, j);
    }

    @Nonnull
    @Override
    public ItemStack removeStackFromSlot(int i) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return ItemStack.EMPTY;
        }
        return inv.removeStackFromSlot(i);
    }

    @Override
    public void setInventorySlotContents(int i, @Nonnull ItemStack itemstack) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return;
        }
        inv.setInventorySlotContents(i, itemstack);
    }

    @Override
    public int getInventoryStackLimit() {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return 0;
        }
        return inv.getInventoryStackLimit();
    }

    @Override
    public boolean isUsableByPlayer(@Nonnull PlayerEntity entityplayer) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return false;
        }
        return inv.isUsableByPlayer(entityplayer);
    }

    @Override
    public void openInventory(@Nonnull PlayerEntity player) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return;
        }
        inv.openInventory(player);
    }

    @Override
    public void closeInventory(@Nonnull PlayerEntity player) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return;
        }
        inv.closeInventory(player);
    }

    @Override
    public boolean isItemValidForSlot(int i, @Nonnull ItemStack itemstack) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return false;
        }
        return inv.isItemValidForSlot(i, itemstack);
    }

    @Override
    public void clear() {
    }

    @Nonnull
    @Override
    public int[] getSlotsForFace(@Nonnull Direction side) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return InventoryUtils.EMPTY;
        }
        return inv.getSlotsForFace(side);
    }

    @Override
    public boolean canInsertItem(int i, @Nonnull ItemStack itemstack, @Nonnull Direction side) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return false;
        }
        return inv.canInsertItem(i, itemstack, side);
    }

    @Override
    public boolean canExtractItem(int i, @Nonnull ItemStack itemstack, @Nonnull Direction side) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return false;
        }
        return inv.canExtractItem(i, itemstack, side);
    }

    @Override
    public double acceptEnergy(Direction side, double amount, boolean simulate) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null || !canReceiveEnergy(side)) {
            return 0;
        }
        return inv.acceptEnergy(side, amount, simulate);
    }

    @Override
    public boolean canReceiveEnergy(Direction side) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return false;
        }
        return inv.canBoundReceiveEnergy(getPos(), side);
    }

    //TODO: IC2
    /*@Override
    @Method(modid = MekanismHooks.IC2_MOD_ID)
    public boolean acceptsEnergyFrom(IEnergyEmitter emitter, Direction direction) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return false;
        }
        return inv.acceptsEnergyFrom(emitter, direction);
    }

    @Override
    @Method(modid = MekanismHooks.IC2_MOD_ID)
    public double getDemandedEnergy() {
        IAdvancedBoundingBlock inv = getInv();
        return inv == null ? 0 : inv.getDemandedEnergy();
    }

    @Override
    @Method(modid = MekanismHooks.IC2_MOD_ID)
    public double injectEnergy(Direction directionFrom, double amount, double voltage) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null || !canReceiveEnergy(directionFrom)) {
            return amount;
        }
        return inv.injectEnergy(directionFrom, amount, voltage);
    }

    @Override
    @Method(modid = MekanismHooks.IC2_MOD_ID)
    public int getSinkTier() {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return 0;
        }
        return inv.getSinkTier();
    }*/

    public IAdvancedBoundingBlock getInv() {
        // Return the inventory/main tile; note that it's possible, esp. when chunks are
        // loading that the inventory/main tile has not yet loaded and thus is null.
        final TileEntity tile = getMainTile();
        if (tile == null) {
            return null;
        }
        if (!(tile instanceof IAdvancedBoundingBlock)) {
            // On the off chance that another block got placed there (which seems only likely with corruption,
            // go ahead and log what we found.
            Mekanism.logger.error("Found tile {} instead of an IAdvancedBoundingBlock, at {}. Multiblock cannot function", tile, getMainPos());
            //world.removeBlock(mainPos, false);
            return null;
        }
        return (IAdvancedBoundingBlock) tile;
    }

    @Override
    public void onPower() {
        super.onPower();
        IAdvancedBoundingBlock inv = getInv();
        if (inv != null) {
            inv.onPower();
        }
    }

    @Override
    public void onNoPower() {
        super.onNoPower();
        IAdvancedBoundingBlock inv = getInv();
        if (inv != null) {
            inv.onNoPower();
        }
    }

    @Override
    public String[] getMethods() {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return new String[]{};
        }
        return inv.getMethods();
    }

    @Override
    public Object[] invoke(int method, Object[] arguments) throws NoSuchMethodException {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return new Object[]{};
        }
        return inv.invoke(method, arguments);
    }

    @Override
    public CompoundNBT getConfigurationData(CompoundNBT nbtTags) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return new CompoundNBT();
        }
        return inv.getConfigurationData(nbtTags);
    }

    @Override
    public void setConfigurationData(CompoundNBT nbtTags) {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return;
        }
        inv.setConfigurationData(nbtTags);
    }

    @Override
    public String getDataType() {
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return "null";
        }
        return inv.getDataType();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
        if (capability == Capabilities.TILE_NETWORK_CAPABILITY) {
            return super.getCapability(capability, side);
        }
        IAdvancedBoundingBlock inv = getInv();
        if (inv == null) {
            return super.getCapability(capability, side);
        }
        return inv.getOffsetCapability(capability, side, pos.subtract(getMainPos()));
    }
}