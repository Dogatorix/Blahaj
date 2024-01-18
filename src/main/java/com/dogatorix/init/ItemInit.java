package com.dogatorix.init;

import com.dogatorix.Blahaj;
import com.dogatorix.CuddlyItem;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
 import static com.dogatorix.init.CreativeTabInit.addToTab;

public class ItemInit {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        Blahaj.MOD_ID);

        public static final RegistryObject<BlockItem> BLUE_SHARK = addToTab(ITEMS.register("blue_shark",
            () -> new CuddlyItem(BlockInit.BLUE_SHARK.get(), new Item.Properties().stacksTo(1), "block.blahaj.blue_shark.tooltip")));
        public static final RegistryObject<BlockItem> GRAY_SHARK = addToTab(ITEMS.register("gray_shark",
            () -> new CuddlyItem(BlockInit.GRAY_SHARK.get(), new Item.Properties().stacksTo(1), "block.blahaj.gray_shark.tooltip")));
        public static final RegistryObject<BlockItem> BLUE_WHALE = addToTab(ITEMS.register("blue_whale",
            () -> new CuddlyItem(BlockInit.BLUE_WHALE.get(), new Item.Properties().stacksTo(1), "block.blahaj.blue_whale.tooltip")));
        public static final RegistryObject<BlockItem> REAPER = addToTab(ITEMS.register("reaper",
            () -> new CuddlyItem(BlockInit.REAPER.get(), new Item.Properties().stacksTo(1), "block.blahaj.reaper.tooltip")));
        public static final RegistryObject<BlockItem> KILLER_WHALE = addToTab(ITEMS.register("killer_whale",
            () -> new CuddlyItem(BlockInit.KILLER_WHALE.get(), new Item.Properties().stacksTo(1), "block.blahaj.killer_whale.tooltip")));
        public static final RegistryObject<BlockItem> BREAD = addToTab(ITEMS.register("bread",
            () -> new CuddlyItem(BlockInit.BREAD.get(), new Item.Properties().stacksTo(1), null)));

}