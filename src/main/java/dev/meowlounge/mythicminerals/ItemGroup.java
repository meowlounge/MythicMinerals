package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.item.FrostiumItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroup {
	public static final RegistryKey<net.minecraft.item.ItemGroup> MM_GROUP_KEY = RegistryKey.of(
			Registries.ITEM_GROUP.getKey(),
			Identifier.of(MythicMinerals.MOD_ID, "mythicminerals_ores")
	);

	public static final net.minecraft.item.ItemGroup MM_ITEM_GROUP = Registry.register(
			Registries.ITEM_GROUP,
			MM_GROUP_KEY.getValue(),
			FabricItemGroup.builder()
					.icon(() -> new ItemStack(Frostium.FROSTIUM))
					.displayName(Text.translatable("mythicminerals.item_group_ore"))
					.entries((displayContext, entries) -> {
						entries.add(Frostium.FROSTIUM);
						entries.add(Frostium.RAW_FROSTIUM);
						entries.add(Frostium.FROSTIUM_LEGGINGS);
						entries.add(Frostium.FROSTIUM_SHOVEL);
						entries.add(Frostium.FROSTIUM_AXE);
						entries.add(Frostium.FROSTIUM_BOOTS);
						entries.add(Frostium.FROSTIUM_CHESTPLATE);
						entries.add(Frostium.FROSTIUM_HELMET);
						entries.add(Frostium.FROSTIUM_HOE);
						entries.add(Frostium.FROSTIUM_PICKAXE);
						entries.add(Frostium.FROSTIUM_SWORD);

						entries.add(FrostiumBlocks.FROSTIUM_BLOCK);
						entries.add(FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE);
						entries.add(FrostiumBlocks.FROSTIUM_ORE);
						entries.add(FrostiumBlocks.RAW_FROSTIUM_BLOCK);
					})
					.build()
	);

	public static void registerItemGroup() {
	}
}