package com.dogatorix;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import java.util.function.Predicate;

public class CustomSlot extends SlotItemHandler {
    private final Predicate<ItemStack> fuelPredicate;

    public CustomSlot(IItemHandler inventory, int index, int xPosition, int yPosition) {
        this(inventory, index, xPosition, yPosition, stack -> ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0);
    }

    public CustomSlot(IItemHandler inventory, int index, int xPosition, int yPosition,
            Predicate<ItemStack> fuelPredicate) {
        super(inventory, index, xPosition, yPosition);
        this.fuelPredicate = fuelPredicate;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return this.fuelPredicate.test(stack);
    }
}