package com.dogatorix;

import com.dogatorix.init.BlockEntityInit;
import com.dogatorix.sound.ModSounds;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class CuddlyBlockEntity extends BlockEntity {
    private static final long COOLDOWN_TIME = 500;

    private long lastPlayTime = 0;

    public CuddlyBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.BLUE_SHARK_BLOCK_ENTITY.get(), pos, state);
    }

    public void playSqueakSound() {
        // Play a squeak sound at the block's position
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPlayTime >= COOLDOWN_TIME) {
            level.playSound(null, worldPosition, ModSounds.SQUEAK.get(), SoundSource.BLOCKS, 1, 1.0f);
            lastPlayTime = currentTime;
        }
    }
}
