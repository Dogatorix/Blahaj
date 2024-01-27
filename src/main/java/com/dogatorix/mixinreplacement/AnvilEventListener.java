package com.dogatorix.mixinreplacement;

import com.dogatorix.CuddlyItem;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AnvilEventListener {

	@SubscribeEvent
	public static void onAnvilUpdate(AnvilUpdateEvent event) {
		if(event.getLeft().getItem() instanceof CuddlyItem) {
			//todo: readd compatibility
			//event.getLeft().addTagElement(CuddlyItem.OWNER_KEY, StringTag.valueOf(event.getPlayer().getName().getString()));
		}
	}
}
