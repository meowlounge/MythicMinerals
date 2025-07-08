package meowlounge.oreveil.item;

import meowlounge.oreveil.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void registerModItems() {
        Registry.register(
                Registries.ITEM,
                Identifier.of("oreveil", "frostium_ore"),
                new BlockItem(ModBlocks.FROSTIUM_ORE, new Item.Settings())
        );
        System.out.println("[oreveil] → Frostium Item registered");
    }
}
