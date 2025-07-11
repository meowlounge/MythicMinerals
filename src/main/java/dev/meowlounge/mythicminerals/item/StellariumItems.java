package dev.meowlounge.mythicminerals.item;

import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.TagsProvider;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;

import java.util.List;

import static dev.meowlounge.mythicminerals.item.Utils.registerItem;

public class StellariumItems {
    public static final ToolMaterial STELLARIUM_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3000, 25.0F, 3.0F, 15, TagsProvider.Items.STELLARIUM_REPAIR
    );
    public static final RegistryKey<ItemFeature>

    public static final Item STELLARIUM_SCRAP = registerItem("stellarium_scrap", Item::new);
    public static final Item STELLARIUM = registerItem("stellarium", Item::new);

    public static final Item STELLARIUM_SWORD = registerItem("stellarium_sword",
            settings -> new Item(settings.sword(StellariumItems.STELLARIUM_TOOL_MATERIAL, 5, -2.2F)));

    public static final Item STELLARIUM_SHOVEL = registerItem("stellarium_shovel",
            settings -> new ShovelItem(StellariumItems.STELLARIUM_TOOL_MATERIAL, -0.5F, -3, settings));

    public static final Item STELLARIUM_PICKAXE = registerItem("stellarium_pickaxe",
            settings -> new Item(settings.pickaxe(StellariumItems.STELLARIUM_TOOL_MATERIAL, -0.5F, -3)));

    public static final Item STELLARIUM_AXE = registerItem("stellarium_axe",
            settings -> new AxeItem(StellariumItems.STELLARIUM_TOOL_MATERIAL, 7, -2.8F, settings));

    public static final Item STELLARIUM_HOE = registerItem("stellarium_hoe",
            settings -> new HoeItem(StellariumItems.STELLARIUM_TOOL_MATERIAL, -0.5F, -3, settings));

    // ---------------------- //

    public static final Item STELLARIUM_HELMET = registerItem("stellarium_helmet",
            settings -> new Item(settings.armor(Armor.STELLARIUM_ARMOR_MATERIAL, EquipmentType.HELMET)));

    public static final Item STELLARIUM_CHESTPLATE = registerItem("stellarium_chestplate",
            settings -> new Item(settings.armor(Armor.STELLARIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));

    public static final Item STELLARIUM_LEGGINGS = registerItem("stellarium_leggings",
            settings -> new Item(settings.armor(Armor.STELLARIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));

    public static final Item STELLARIUM_BOOTS = registerItem("stellarium_boots",
            settings -> new Item(settings.armor(Armor.STELLARIUM_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    // ---------------------- //

    public static final Item STELLARIUM_SMITHING_TEMPLATE = registerItem("stellarium_smithing_template",
            settings -> new SmithingTemplateItem(
                    Text.translatable("item.minecraft.smithing_template.applies_to.netherite").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
                    Text.literal("Stellarium").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
                    Text.translatable("item.minecraft.smithing_template.base_slot_description").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
                    Text.translatable("item.mythicminerals.stellarium_smithing_template.additions_slot_description").fillStyle(Style.EMPTY.withColor(Formatting.BLUE)),
                    List.of(
                            Identifier.ofVanilla("container/slot/sword"),
                            Identifier.ofVanilla("container/slot/pickaxe"),
                            Identifier.ofVanilla("container/slot/axe"),
                            Identifier.ofVanilla("container/slot/hoe"),
                            Identifier.ofVanilla("container/slot/shovel"),
                            Identifier.ofVanilla("container/slot/armor")
                    ),
                    List.of(
                            Identifier.ofVanilla("container/slot/ingot")
                    ),
                    new Item.Settings().registryKey("stellarium_smithing_template")
            ));

    // ---------------------- //

    public static void registerStellariumItems() {
        MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Stellarium Items");
    }
}
