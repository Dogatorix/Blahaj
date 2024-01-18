package com.dogatorix;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.dogatorix.init.*;

import net.minecraftforge.eventbus.api.IEventBus;

@Mod(Blahaj.MOD_ID)
public class Blahaj {
	public static final String MOD_ID = "blahaj";

	public Blahaj() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		CreativeTabInit.TABS.register(bus);
	}
}
