package dev.meowlounge.mythicminerals.group;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.item.DebugItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DebugItemGroup {
	public static final RegistryKey<net.minecraft.item.ItemGroup> MM_DEBUG_GROUP_KEY = RegistryKey.of(
			Registries.ITEM_GROUP.getKey(),
			Identifier.of(MythicMinerals.MOD_ID, "mythicminerals_debug_items")
	);

	public static final net.minecraft.item.ItemGroup MM_DEBUG_ITEM_GROUP = Registry.register(
			Registries.ITEM_GROUP,
			MM_DEBUG_GROUP_KEY.getValue(),
			FabricItemGroup.builder()
					.icon(() -> new ItemStack(DebugItems.VOIDSTONE_ORE_LOCATOR))
					.displayName(Text.translatable("mythicminerals.debug_item_group"))
					.entries((displayContext, entries) -> {
						entries.add(DebugItems.FROSTIUM_ORE_LOCATOR);
						entries.add(DebugItems.VOIDSTONE_ORE_LOCATOR);
						entries.add(DebugItems.STELLARIUM_ORE_LOCATOR);
						entries.add(DebugItems.FOGSTONE_ORE_LOCATOR);
					})
					.build()
	);

	public static void registerDebugItemGroup() {
		//? registration triggered on class load
	}
}
