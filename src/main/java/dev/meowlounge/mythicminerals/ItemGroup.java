package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.block.PhantomiumBlocks;
import dev.meowlounge.mythicminerals.item.FrostiumItems;
import dev.meowlounge.mythicminerals.item.PhantomiumItems;
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
					.icon(() -> new ItemStack(FrostiumItems.FROSTIUM))
					.displayName(Text.translatable("mythicminerals.item_group_ore"))
					.entries((displayContext, entries) -> {
						entries.add(FrostiumItems.FROSTIUM);
						entries.add(FrostiumItems.RAW_FROSTIUM);
						entries.add(FrostiumItems.FROSTIUM_LEGGINGS);
						entries.add(FrostiumItems.FROSTIUM_SHOVEL);
						entries.add(FrostiumItems.FROSTIUM_AXE);
						entries.add(FrostiumItems.FROSTIUM_BOOTS);
						entries.add(FrostiumItems.FROSTIUM_CHESTPLATE);
						entries.add(FrostiumItems.FROSTIUM_HELMET);
						entries.add(FrostiumItems.FROSTIUM_HOE);
						entries.add(FrostiumItems.FROSTIUM_PICKAXE);
						entries.add(FrostiumItems.FROSTIUM_SWORD);

						entries.add(FrostiumBlocks.FROSTIUM_BLOCK);
						entries.add(FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE);
						entries.add(FrostiumBlocks.FROSTIUM_ORE);
						entries.add(FrostiumBlocks.RAW_FROSTIUM_BLOCK);

						entries.add(PhantomiumItems.PHANTOMIUM);
						entries.add(PhantomiumItems.RAW_PHANTOMIUM);
						entries.add(PhantomiumItems.PHANTOMIUM_LEGGINGS);
						entries.add(PhantomiumItems.PHANTOMIUM_SHOVEL);
						entries.add(PhantomiumItems.PHANTOMIUM_AXE);
						entries.add(PhantomiumItems.PHANTOMIUM_BOOTS);
						entries.add(PhantomiumItems.PHANTOMIUM_CHESTPLATE);
						entries.add(PhantomiumItems.PHANTOMIUM_HELMET);
						entries.add(PhantomiumItems.PHANTOMIUM_HOE);
						entries.add(PhantomiumItems.PHANTOMIUM_PICKAXE);
						entries.add(PhantomiumItems.PHANTOMIUM_SWORD);

						entries.add(PhantomiumBlocks.PHANTOMIUM_BLOCK);
						entries.add(PhantomiumBlocks.PHANTOMIUM_ORE);
						entries.add(PhantomiumBlocks.RAW_PHANTOMIUM_BLOCK);
					})
					.build()
	);

	public static void registerItemGroup() {
	}
}