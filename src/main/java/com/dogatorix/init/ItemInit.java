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
                        () -> new CuddlyItem(BlockInit.BLUE_SHARK.get(), new Item.Properties().stacksTo(1),
                                        "block.blahaj.blue_shark.tooltip")));
        public static final RegistryObject<BlockItem> GRAY_SHARK = addToTab(ITEMS.register("gray_shark",
                        () -> new CuddlyItem(BlockInit.GRAY_SHARK.get(), new Item.Properties().stacksTo(1),
                                        "block.blahaj.gray_shark.tooltip")));
        public static final RegistryObject<BlockItem> BLUE_WHALE = addToTab(ITEMS.register("blue_whale",
                        () -> new CuddlyItem(BlockInit.BLUE_WHALE.get(), new Item.Properties().stacksTo(1),
                                        "block.blahaj.blue_whale.tooltip")));
        public static final RegistryObject<BlockItem> REAPER = addToTab(ITEMS.register("reaper",
                        () -> new CuddlyItem(BlockInit.REAPER.get(), new Item.Properties().stacksTo(1),
                                        "block.blahaj.reaper.tooltip")));
        public static final RegistryObject<BlockItem> KILLER_WHALE = addToTab(ITEMS.register("killer_whale",
                        () -> new CuddlyItem(BlockInit.KILLER_WHALE.get(), new Item.Properties().stacksTo(1),
                                        "block.blahaj.killer_whale.tooltip")));
        public static final RegistryObject<BlockItem> BREAD = addToTab(ITEMS.register("bread",
                        () -> new CuddlyItem(BlockInit.BREAD.get(), new Item.Properties().stacksTo(1), null)));

        public static final RegistryObject<BlockItem> YARN_SPINNER = addToTab(ITEMS.register("yarn_spinner",
                        () -> new BlockItem(BlockInit.YARN_SPINNER.get(), new Item.Properties().stacksTo(1))));

        public static final RegistryObject<Item> WHITE_YARN = addToTab(ITEMS.register("white_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> ORANGE_YARN = addToTab(ITEMS.register("orange_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> MAGENTA_YARN = addToTab(ITEMS.register("magenta_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> LIGHT_BLUE_YARN = addToTab(ITEMS.register("light_blue_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> YELLOW_YARN = addToTab(ITEMS.register("yellow_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> LIME_YARN = addToTab(ITEMS.register("lime_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> PINK_YARN = addToTab(ITEMS.register("pink_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> GRAY_YARN = addToTab(ITEMS.register("gray_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> LIGHT_GRAY_YARN = addToTab(ITEMS.register("light_gray_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> CYAN_YARN = addToTab(ITEMS.register("cyan_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> PURPLE_YARN = addToTab(ITEMS.register("purple_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> BLUE_YARN = addToTab(ITEMS.register("blue_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> BROWN_YARN = addToTab(ITEMS.register("brown_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> GREEN_YARN = addToTab(ITEMS.register("green_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> RED_YARN = addToTab(ITEMS.register("red_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));
        public static final RegistryObject<Item> BLACK_YARN = addToTab(ITEMS.register("black_yarn",
                        () -> new Item(new Item.Properties().stacksTo(64))));


}