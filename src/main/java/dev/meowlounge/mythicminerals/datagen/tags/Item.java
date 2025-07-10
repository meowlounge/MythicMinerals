package dev.meowlounge.mythicminerals.datagen.tags;

import dev.meowlounge.mythicminerals.item.FrostiumItems;
import dev.meowlounge.mythicminerals.item.PhantomiumItems;
import dev.meowlounge.mythicminerals.util.TagsProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class Item extends FabricTagProvider.ItemTagProvider {
    public Item(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(TagsProvider.Items.FROSTIUM_REPAIR)
                .add(FrostiumItems.FROSTIUM);

        valueLookupBuilder(TagsProvider.Items.PHANTOMIUM_REPAIR)
                .add(PhantomiumItems.PHANTOMIUM);

        valueLookupBuilder(net.minecraft.registry.tag.ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(FrostiumItems.FROSTIUM_SWORD)
                .add(FrostiumItems.FROSTIUM_AXE)

                .add(PhantomiumItems.PHANTOMIUM_SWORD)
                .add(PhantomiumItems.PHANTOMIUM_AXE);

        valueLookupBuilder(net.minecraft.registry.tag.ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(FrostiumItems.FROSTIUM_SHOVEL)
                .add(FrostiumItems.FROSTIUM_AXE)
                .add(FrostiumItems.FROSTIUM_HOE)

                .add(PhantomiumItems.PHANTOMIUM_SHOVEL)
                .add(PhantomiumItems.PHANTOMIUM_AXE)
                .add(PhantomiumItems.PHANTOMIUM_HOE);

        valueLookupBuilder(net.minecraft.registry.tag.ItemTags.MINING_ENCHANTABLE)
                .add(FrostiumItems.FROSTIUM_PICKAXE)
                .add(PhantomiumItems.PHANTOMIUM_PICKAXE);

        valueLookupBuilder(net.minecraft.registry.tag.ItemTags.ARMOR_ENCHANTABLE)
                .add(FrostiumItems.FROSTIUM_BOOTS)
                .add(FrostiumItems.FROSTIUM_CHESTPLATE)
                .add(FrostiumItems.FROSTIUM_HELMET)
                .add(FrostiumItems.FROSTIUM_LEGGINGS)

                .add(PhantomiumItems.PHANTOMIUM_BOOTS)
                .add(PhantomiumItems.PHANTOMIUM_CHESTPLATE)
                .add(PhantomiumItems.PHANTOMIUM_HELMET)
                .add(PhantomiumItems.PHANTOMIUM_LEGGINGS);
    }


    @Override
    public String getName() {
        return "⛏️ [MythicMinerals]: Registering Item Tags";
    }
}
