package net.frizzkop.kamumod.item;

import net.frizzkop.kamumod.KamuMod;
import net.frizzkop.kamumod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier WEED = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1800, 1F, 2.0F, 14,
                    ModTags.Blocks.NEEDS_WEED_TOOL, () -> Ingredient.of(ModItems.WEED_BUD.get())),
            new ResourceLocation(KamuMod.MOD_ID, "weed_bud"), List.of(Tiers.DIAMOND), List.of());

}