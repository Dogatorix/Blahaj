package dogatorix.blahaj;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(Common.MOD_ID)
public class Common {
	public static final String MOD_ID = "blahaj";

	public Common() {
		DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
		items.register("blue_shark", () -> new CuddlyItem(new Item.Properties().stacksTo(1), "item.blahaj.blue_shark.tooltip"));
		items.register("gray_shark", () -> new CuddlyItem(new Item.Properties().stacksTo(1), "item.blahaj.gray_shark.tooltip"));
		items.register("blue_whale", () -> new CuddlyItem(new Item.Properties().stacksTo(1), "item.blahaj.blue_whale.tooltip"));
		items.register("bread", () -> new CuddlyItem(new Item.Properties().stacksTo(1), null));
		items.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
