package org.jlortiz.BrainCrashFix.mixin;

import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Brain.class)
public abstract class BrainMixin<E extends LivingEntity> {
	@Inject(at = @At("HEAD"), method = "tick", cancellable = true)
	protected void onTick(ServerWorld l, E e, CallbackInfo ci) {
		if (!e.isAlive()) {
            ci.cancel();
		}
	}
	
	
}
