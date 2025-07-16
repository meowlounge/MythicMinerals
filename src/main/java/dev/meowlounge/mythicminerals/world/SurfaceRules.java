package dev.meowlounge.mythicminerals.world;

import dev.meowlounge.mythicminerals.world.biome.Biomes;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class SurfaceRules {
    public static MaterialRules.MaterialRule createRules() {
        return MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(Biomes.VOLCANIC_HIGHLANDS),
                        MaterialRules.sequence(
                                MaterialRules.condition(
                                        MaterialRules.stoneDepth(0, false, 0, VerticalSurfaceType.FLOOR),
                                        MaterialRules.sequence(
                                                MaterialRules.condition(
                                                        MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.5, -0.25),
                                                        MaterialRules.block(Blocks.STONE.getDefaultState())
                                                ),
                                                MaterialRules.condition(
                                                        MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.25, 0.0),
                                                        MaterialRules.block(Blocks.ANDESITE.getDefaultState())
                                                ),
                                                MaterialRules.condition(
                                                        MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.0, 0.25),
                                                        MaterialRules.block(Blocks.BLACKSTONE.getDefaultState())
                                                ),
                                                MaterialRules.condition(
                                                        MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.25, 0.5),
                                                        MaterialRules.block(Blocks.BASALT.getDefaultState())
                                                )
                                        )
                                )
                        )
                )
        );
    }
}