package com.dogatorix.init;

import com.dogatorix.Blahaj;
import com.dogatorix.CuddlyBlock;
import com.dogatorix.YarnSpinnerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        Blahaj.MOD_ID);

        public static final RegistryObject<CuddlyBlock> BLUE_SHARK = BLOCKS.register("blue_shark",
                        () -> new CuddlyBlock(
                                        BlockBehaviour.Properties.copy(Blocks.CYAN_WOOL)));
        public static final RegistryObject<CuddlyBlock> GRAY_SHARK = BLOCKS.register("gray_shark",
                        () -> new CuddlyBlock(
                                        BlockBehaviour.Properties.copy(Blocks.GRAY_WOOL)));
        public static final RegistryObject<CuddlyBlock> BLUE_WHALE = BLOCKS.register("blue_whale",
                        () -> new CuddlyBlock(
                                        BlockBehaviour.Properties.copy(Blocks.BLUE_WOOL)));
        public static final RegistryObject<CuddlyBlock> REAPER = BLOCKS.register("reaper",
                        () -> new CuddlyBlock(
                                        BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL)));
        public static final RegistryObject<CuddlyBlock> KILLER_WHALE = BLOCKS.register("killer_whale",
                        () -> new CuddlyBlock(
                                        BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
        public static final RegistryObject<CuddlyBlock> BREAD = BLOCKS.register("bread",
                        () -> new CuddlyBlock(
                                        BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).sound(SoundType.WOOL)));

        public static final RegistryObject<CuddlyBlock> HAMMERHEAD_SHARK = BLOCKS.register("hammerhead_shark",
                        () -> new CuddlyBlock(
                                        BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_WOOL)));

        public static final RegistryObject<Block> YARN_SPINNER = BLOCKS.register("yarn_spinner",
                        () -> new YarnSpinnerBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

}
