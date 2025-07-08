package meowlounge.oreveil.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block FROSTIUM_ORE;

    public static void registerModBlocks() {
        FROSTIUM_ORE = Registry.register(
                Registries.BLOCK,
                Identifier.of("oreveil", "frostium_ore"),
                new Block(Block.Settings.copy(Blocks.IRON_ORE))
        );
        System.out.println("[oreveil] → Frostium Block registered");
    }
}
