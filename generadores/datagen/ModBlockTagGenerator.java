package net.frizzkop.kamumod.datagen;

import net.frizzkop.kamumod.KamuMod;
import net.frizzkop.kamumod.block.ModBlocks;
import net.frizzkop.kamumod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, KamuMod.MOD_ID, existingFileHelper);
    }

    // Este metodo se va a encargar de generar Tags para los Blocks
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.HACHIS_BLOCKS).add(ModBlocks.BLOQUE_PRUEBA.get()).addTag(Tags.Blocks.ORES);
    }
}
