package com.dogatorix.init;

import com.dogatorix.Blahaj;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Blahaj.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            Blahaj.MOD_ID);

    public static final List<Supplier<? extends ItemLike>> BLAHAJ_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> TAB = TABS.register("blahaj_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.blahaj_tab"))
                    .icon(ItemInit.BLUE_SHARK.get()::getDefaultInstance)
                    .displayItems((displayParams, output) -> BLAHAJ_TAB_ITEMS
                            .forEach(itemLike -> output.accept(itemLike.get())))
                    .build());

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        BLAHAJ_TAB_ITEMS.add(itemLike);
        return itemLike;
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
    }
}