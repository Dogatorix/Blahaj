package com.dogatorix.init;

import com.dogatorix.Blahaj;
import com.dogatorix.CuddlyBlockEntity;
import com.dogatorix.YarnSpinnerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Blahaj.MOD_ID);

    public static final RegistryObject<BlockEntityType<CuddlyBlockEntity>> BLUE_SHARK_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("blue_shark",
                    () -> BlockEntityType.Builder.of(CuddlyBlockEntity::new, BlockInit.BLUE_SHARK.get())
                            .build(null));

        // PLUSHIE_STATION_BLOCK_ENTITY
         public static final RegistryObject<BlockEntityType<YarnSpinnerBlockEntity>> YARN_SPINNER_BE =
            BLOCK_ENTITIES.register("yarn_spinner_be", () ->
                    BlockEntityType.Builder.of(YarnSpinnerBlockEntity::new,
                            BlockInit.YARN_SPINNER.get()).build(null));


                        

}