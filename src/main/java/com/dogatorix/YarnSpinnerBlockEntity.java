package com.dogatorix;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.dogatorix.init.BlockEntityInit;
import com.dogatorix.init.ItemInit;
import com.dogatorix.screen.YarnSpinnerMenu;

public class YarnSpinnerBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(2);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public YarnSpinnerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityInit.YARN_SPINNER_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> YarnSpinnerBlockEntity.this.progress;
                    case 1 -> YarnSpinnerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> YarnSpinnerBlockEntity.this.progress = pValue;
                    case 1 -> YarnSpinnerBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.blahaj.yarn_spinner");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new YarnSpinnerMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("yarn_spinner.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("yarn_spinner.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }
    

    private boolean hasRecipe() {
        // boolean hasCraftingItem = this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == Items.WHITE_WOOL;
        // ItemStack result = new ItemStack(Items.STRING);

        // return hasCraftingItem && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());

        //instead of WHITE_WOOL, let's make an array of all the wool colors
        Item[] woolColors = {Items.WHITE_WOOL, Items.ORANGE_WOOL, Items.MAGENTA_WOOL, Items.LIGHT_BLUE_WOOL, Items.YELLOW_WOOL, Items.LIME_WOOL, Items.PINK_WOOL, Items.GRAY_WOOL, Items.LIGHT_GRAY_WOOL, Items.CYAN_WOOL, Items.PURPLE_WOOL, Items.BLUE_WOOL, Items.BROWN_WOOL, Items.GREEN_WOOL, Items.RED_WOOL, Items.BLACK_WOOL};
        Item[] yarnColors = {ItemInit.WHITE_YARN.get(), ItemInit.ORANGE_YARN.get(), ItemInit.MAGENTA_YARN.get(), ItemInit.LIGHT_BLUE_YARN.get(), ItemInit.YELLOW_YARN.get(), ItemInit.LIME_YARN.get(), ItemInit.PINK_YARN.get(), ItemInit.GRAY_YARN.get(), ItemInit.LIGHT_GRAY_YARN.get(), ItemInit.CYAN_YARN.get(), ItemInit.PURPLE_YARN.get(), ItemInit.BLUE_YARN.get(), ItemInit.BROWN_YARN.get(), ItemInit.GREEN_YARN.get(), ItemInit.RED_YARN.get(), ItemInit.BLACK_YARN.get()};
        //now we can check if the input slot has any of the wool colors, and if it does, return a mod item that corresponds to that color
        Boolean hasCraftingItem = false;
        for (int i = 0; i < woolColors.length; i++) {
            if (this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == woolColors[i]) {
                ItemStack result = new ItemStack(yarnColors[i]);
                if (canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem())) {
                    hasCraftingItem = true;
                    break;
                }
            }
        }
        return hasCraftingItem;
    }
    private void craftItem() {
        Item[] woolColors = {Items.WHITE_WOOL, Items.ORANGE_WOOL, Items.MAGENTA_WOOL, Items.LIGHT_BLUE_WOOL, Items.YELLOW_WOOL, Items.LIME_WOOL, Items.PINK_WOOL, Items.GRAY_WOOL, Items.LIGHT_GRAY_WOOL, Items.CYAN_WOOL, Items.PURPLE_WOOL, Items.BLUE_WOOL, Items.BROWN_WOOL, Items.GREEN_WOOL, Items.RED_WOOL, Items.BLACK_WOOL};
        Item[] yarnColors = {ItemInit.WHITE_YARN.get(), ItemInit.ORANGE_YARN.get(), ItemInit.MAGENTA_YARN.get(), ItemInit.LIGHT_BLUE_YARN.get(), ItemInit.YELLOW_YARN.get(), ItemInit.LIME_YARN.get(), ItemInit.PINK_YARN.get(), ItemInit.GRAY_YARN.get(), ItemInit.LIGHT_GRAY_YARN.get(), ItemInit.CYAN_YARN.get(), ItemInit.PURPLE_YARN.get(), ItemInit.BLUE_YARN.get(), ItemInit.BROWN_YARN.get(), ItemInit.GREEN_YARN.get(), ItemInit.RED_YARN.get(), ItemInit.BLACK_YARN.get()};
        for (int i = 0; i < woolColors.length; i++) {
            if (this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == woolColors[i]) {
                ItemStack result = new ItemStack(yarnColors[i]);
                this.itemHandler.extractItem(INPUT_SLOT, 1, false);
                this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(), this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
            }
        }
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }
}
