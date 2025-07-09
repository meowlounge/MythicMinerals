package dev.meowlounge.mythicminerals.datagen.tags;

import dev.meowlounge.mythicminerals.item.Frostium;
import dev.meowlounge.mythicminerals.util.Tags;
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
        valueLookupBuilder(Tags.Items.FROSTIUM_REPAIR)
                .add(Frostium.FROSTIUM);
        valueLookupBuilder(net.minecraft.registry.tag.ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(Frostium.FROSTIUM_SWORD)
                .add(Frostium.FROSTIUM_AXE);
        valueLookupBuilder(net.minecraft.registry.tag.ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(Frostium.FROSTIUM_SHOVEL)
                .add(Frostium.FROSTIUM_AXE)
                .add(Frostium.FROSTIUM_HOE);
        valueLookupBuilder(net.minecraft.registry.tag.ItemTags.MINING_ENCHANTABLE)
                .add(Frostium.FROSTIUM_PICKAXE);
        valueLookupBuilder(net.minecraft.registry.tag.ItemTags.ARMOR_ENCHANTABLE)
                .add(Frostium.FROSTIUM_BOOTS)
                .add(Frostium.FROSTIUM_CHESTPLATE)
                .add(Frostium.FROSTIUM_HELMET)
                .add(Frostium.FROSTIUM_LEGGINGS);
    }


    @Override
    public String getName() {
        return "Item";
    }
}
