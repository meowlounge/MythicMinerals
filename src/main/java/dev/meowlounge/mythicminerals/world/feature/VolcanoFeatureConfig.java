package dev.meowlounge.mythicminerals.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.FeatureConfig;

public record VolcanoFeatureConfig() implements FeatureConfig {
    public static final Codec<VolcanoFeatureConfig> CODEC = Codec.unit(VolcanoFeatureConfig::new);
}