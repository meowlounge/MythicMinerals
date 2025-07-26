package dev.meowlounge.mythicminerals.providers;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;


public class TagsProvider {
	public static class Blocks {
		public static final TagKey<Block> NEEDS_NETHERITE_TOOL = createBlockTag("needs_netherite_tool");
		public static final TagKey<Block> INCORRECT_FOR_FROSTIUM_TOOL = createBlockTag("incorrect_for_frostium_tool");

		private static TagKey<Block> createBlockTag(String name) {
			return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MythicMinerals.MOD_ID, name));
		}
	}

	//* ---------------------- //

	public static class Items {
		public static final TagKey<Item> FROSTIUM_REPAIR = createItemTag("frostium_repair");
		public static final TagKey<Item> VOIDSTONE_REPAIR = createItemTag("voidstone_repair");
		public static final TagKey<Item> STELLARIUM_REPAIR = createItemTag("stellarium_repair");
		public static final TagKey<Item> FOGSTONE_REPAIR = createItemTag("fogstone_repair");
		public static final TagKey<Item> PYROSTONE_REPAIR = createItemTag("pyrostone_repair");
		public static final TagKey<Item> MAGMARIT_REPAIR = createItemTag("magmarit_repair");

		private static TagKey<Item> createItemTag(String name) {
			return TagKey.of(RegistryKeys.ITEM, Identifier.of(MythicMinerals.MOD_ID, name));
		}
	}

}
