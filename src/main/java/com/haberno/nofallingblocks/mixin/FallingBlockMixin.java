package com.haberno.nofallingblocks.mixin;

import com.haberno.nofallingblocks.NoFallingBlocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(FallingBlock.class)
public class FallingBlockMixin {
    @Inject(method = "scheduledTick", at = @At("HEAD"), cancellable = true)
    private void cancelFalling(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random, CallbackInfo ci) {
        if (world.getGameRules().getBoolean(NoFallingBlocks.PREVENT_BLOCK_FALLING_RULE)) {
            ci.cancel();
        }
    }

    @Inject(method = "randomDisplayTick", at = @At("HEAD"), cancellable = true)
    private void cancelFallingParticle(BlockState state, World world, BlockPos pos, net.minecraft.util.math.random.Random random, CallbackInfo ci) {
        if (world.getGameRules().getBoolean(NoFallingBlocks.PREVENT_BLOCK_FALLING_RULE)) {
            ci.cancel();
        }
    }
}
