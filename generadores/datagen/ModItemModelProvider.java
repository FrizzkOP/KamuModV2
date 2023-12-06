package net.frizzkop.kamumod.datagen;

import net.frizzkop.kamumod.KamuMod;
import net.frizzkop.kamumod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KamuMod.MOD_ID, existingFileHelper);
    }

    // Con este metodo registramos los items
    @Override
    protected void registerModels() {
        simpleItem(ModItems.ITEM_PRUEBA);
    }

    //Este metodo se encargara de crear el modelo y la textura para los objetos que registremos
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(KamuMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
