package net.frizzkop.kamumod.item;

import net.frizzkop.kamumod.KamuMod;
import net.frizzkop.kamumod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

// EN ESTA CLASE CREAREMOS NUESTRAS PESTANYAS DEL MENU DE CREATIVO
public class ModCreativeModTabs {
    // Creamos el DeferredRegister como con los Items pero esta vez en lugar de registrar objetos, registraremos las pestanyas
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KamuMod.MOD_ID);

    // Creamos la pestanya y le asignamos los items que queremos que contenga
    public static final RegistryObject<CreativeModeTab> KAMU_TAB = CREATIVE_MODE_TABS.register("kamu_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PORRITO_MARIHUANA.get()))
            .title(Component.translatable("creativetab.kamu_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.PLACA_HACHIS.get());
                pOutput.accept(ModItems.MEDIA_PLACA_HACHIS.get());
                pOutput.accept(ModItems.BOLA_HACHIS.get());
                pOutput.accept(ModItems.PORRITO_MARIHUANA.get());
                pOutput.accept(ModItems.PORRITO_HACHIS.get());
                pOutput.accept(ModItems.TIRAS_TABACO.get());
                pOutput.accept(ModItems.TABACO_MEZCLADO.get());
                pOutput.accept(ModItems.PAPEL_RAW.get());
                pOutput.accept(ModItems.BOQUILLA_CARTON.get());
                pOutput.accept(ModItems.BOQUILLA_ALGODON.get());
                pOutput.accept(ModBlocks.BLOQUE_HACHIS.get());
            })
            .build());

    // Registramos el DeferredRegister
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
