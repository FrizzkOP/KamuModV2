package net.frizzkop.kamumod.datagen;

import net.frizzkop.kamumod.KamuMod;
import net.frizzkop.kamumod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KamuMod.MOD_ID, exFileHelper);
    }

    //En este metodo es donde registramos los blocks
    @Override
    protected void registerStatesAndModels() {
    blockWithItem(ModBlocks.BLOQUE_PRUEBA);
    }

    // Este metodo hace que cuando le pasemos un RegistryObject genere automaticamente un Custom Block así como su Item
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
