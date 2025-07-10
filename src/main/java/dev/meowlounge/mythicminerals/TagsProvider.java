package dev.meowlounge.mythicminerals;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;


public class TagsProvider {
	public static class Blocks {
		public static final TagKey<Block> NEEDS_FROSTIUM_TOOL = createTag("needs_frostium_tool");
		public static final TagKey<Block> INCORRECT_FOR_FROSTIUM_TOOL = createTag("incorrect_for_frostium_tool");

		private static TagKey<Block> createTag(String name) {
			return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MythicMinerals.MOD_ID, name));
		}
	}


	public static class Items {
		public static final TagKey<Item> FROSTIUM_REPAIR = createTag();
		public static final TagKey<Item> STELLARIUM_REPAIR = createTag();

		private static TagKey<Item> createTag() {
			return TagKey.of(RegistryKeys.ITEM, Identifier.of(MythicMinerals.MOD_ID, "frostium_repair"));
		}
	}

}
