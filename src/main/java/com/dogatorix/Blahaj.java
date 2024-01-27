package com.dogatorix;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.dogatorix.init.*;
import com.dogatorix.screen.YarnSpinnerScreen;
import com.dogatorix.screen.ModMenuTypes;
import com.dogatorix.sound.ModSounds;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod(Blahaj.MOD_ID)
public class Blahaj {
	public static final String MOD_ID = "blahaj";

	public Blahaj() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		CreativeTabInit.TABS.register(bus);
		BlockEntityInit.BLOCK_ENTITIES.register(bus);
		ModSounds.register(bus);

		ModMenuTypes.register(bus);
	}

	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			MenuScreens.register(ModMenuTypes.YARN_SPINNER_MENU.get(), YarnSpinnerScreen::new);
		}
	}
}
