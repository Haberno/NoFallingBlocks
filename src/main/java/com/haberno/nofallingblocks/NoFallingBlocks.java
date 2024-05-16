package com.haberno.nofallingblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;


public class NoFallingBlocks implements ModInitializer {
    public static final GameRules.Key<GameRules.BooleanRule> PREVENT_BLOCK_FALLING_RULE =
            GameRuleRegistry.register("noFallingBlocks", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));

    @Override
    public void onInitialize() {
    }
}
