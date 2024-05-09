package com.dogatorix;

import java.util.List;
import java.util.function.Consumer;
import net.minecraft.world.level.block.Block;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import com.dogatorix.mixinreplacement.HumanoidModelReplacement;
import com.dogatorix.sound.ModSounds;

public class CuddlyItem extends BlockItem {

	public static final String OWNER_KEY = "Owner";

	private final Component subtitle;

	private static final long COOLDOWN_TIME = 500;

	private static final String COOLDOWN_KEY = "lastPlayTime";

	public CuddlyItem(Block block, Properties properties, String subtitle) {
		super(block, properties);
		this.subtitle = subtitle == null ? null : Component.translatable(subtitle).withStyle(ChatFormatting.GRAY);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag context) {
		if (this.subtitle != null) {
			tooltip.add(this.subtitle);
		}
		if (stack.hasTag()) {
			CompoundTag nbt = stack.getTag();
			String owner = nbt.getString(OWNER_KEY);
			if (owner == "") {
				return;
			}
			if (stack.hasCustomHoverName()) {
				tooltip.add(Component
						.translatable("tooltip.blahaj.owner.rename", this.getDescription(), Component.literal(owner))
						.withStyle(ChatFormatting.GRAY));
			} else {
				tooltip.add(Component.translatable("tooltip.blahaj.owner.craft", Component.literal(owner))
						.withStyle(ChatFormatting.GRAY));
			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		long currentTime = System.currentTimeMillis();

		ItemStack stack = player.getItemInHand(hand);
		if (!level.isClientSide) {
			if (stack.hasTag()) {
				CompoundTag nbt = stack.getTag();
				String lastPlayTime = nbt.getString(COOLDOWN_KEY);
				if (currentTime - Long.parseLong(lastPlayTime) >= COOLDOWN_TIME) {
					BlockPos pos = player.blockPosition();
					level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), ModSounds.SQUEAK.get(),
							SoundSource.BLOCKS, 1, 1.0f);
					nbt.putString(COOLDOWN_KEY, String.valueOf(currentTime));
				}
			} else {
				CompoundTag nbt = new CompoundTag();
				nbt.putString(COOLDOWN_KEY, String.valueOf(currentTime));
				stack.setTag(nbt);
				BlockPos pos = player.blockPosition();
				level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), ModSounds.SQUEAK.get(), SoundSource.BLOCKS, 1,
						1.0f);
			}
		}

		return super.use(level, player, hand);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		HumanoidModelReplacement.consume(consumer);
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		return super.getDestroySpeed(stack, state);
	}
}
