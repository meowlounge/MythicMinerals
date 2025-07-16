package dev.meowlounge.mythicminerals.world.feature;


import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class VolcanoFeature extends Feature<VolcanoFeatureConfig> {
    public VolcanoFeature() {
        super(VolcanoFeatureConfig.CODEC);
    }


    @Override
    public boolean generate(FeatureContext<VolcanoFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();

        int radius = 20 + random.nextInt(10);
        int height = 30 + random.nextInt(20);

        for (int y = 0; y < height; y++) {
            int currentRadius = radius - (y * radius / height);
            for (int x = -currentRadius; x <= currentRadius; x++) {
                for (int z = -currentRadius; z <= currentRadius; z++) {
                    if (x * x + z * z <= currentRadius * currentRadius) {
                        BlockPos pos = origin.add(x, y, z);
                        world.setBlockState(pos, Blocks.BASALT.getDefaultState(), 2);
                    }
                }
            }
        }

        int craterRadius = 5 + random.nextInt(3);
        for (int y = height - 5; y < height; y++) {
            for (int x = -craterRadius; x <= craterRadius; x++) {
                for (int z = -craterRadius; z <= craterRadius; z++) {
                    if (x * x + z * z <= craterRadius * craterRadius) {
                        BlockPos pos = origin.add(x, y, z);
                        world.setBlockState(pos, Blocks.LAVA.getDefaultState(), 2);
                    }
                }
            }
        }

        return true;
    }
}