package meowlounge.oreveil;

import meowlounge.oreveil.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroup {
	public static final RegistryKey<net.minecraft.item.ItemGroup> OREVEIL_ORE_GROUP_KEY = RegistryKey.of(
			Registries.ITEM_GROUP.getKey(),
			Identifier.of(Oreveil.MOD_ID, "oreveil_ores")
	);

	public static final net.minecraft.item.ItemGroup SUPER_ITEM_GROUP = Registry.register(
			Registries.ITEM_GROUP,
			OREVEIL_ORE_GROUP_KEY.getValue(),
			FabricItemGroup.builder()
					.icon(() -> new ItemStack(ModItems.FROSTIUM))
					.displayName(Text.translatable("oreveil.item_group_ore"))
					.entries((displayContext, entries) -> {
						entries.add(ModItems.FROSTIUM);
						entries.add(ModItems.RAW_FROSTIUM);
						entries.add(ModBlocks.FROSTIUM_BLOCK);
						entries.add(ModBlocks.DEEPSLATE_FROSTIUM_ORE);
						entries.add(ModBlocks.FROSTIUM_ORE);
						entries.add(ModBlocks.RAW_FROSTIUM_BLOCK);
					})
					.build()
	);

	public static void registerItemGroups() {
		Oreveil.LOGGER.info("⛏️ [OREVEIL]: Register ItemGroup");
	}
}