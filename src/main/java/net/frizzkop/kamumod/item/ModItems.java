package net.frizzkop.kamumod.item;

import net.frizzkop.kamumod.KamuMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    // Para registar items tenemos que usar un "Deferred register", ya que los items necesitan "registrarse" siempre.
    // Para ello creamos un ArrayList de tipo "DeferredRegister" que contendrá objetos tipo "Item" y le ponemos nombre, en este caso "ITEMS"
    // A este ArrayList vamos a ir anadiendo los objetos que creemos, y entonces se van a ir registrando en un momento determinado cuando FORGE cargue los items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KamuMod.MOD_ID);

    // Para crear y registrar objetos lo hacemos de la siguiente manera
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire", () -> new Item(new Item.Properties()));

    // El ArrayList "ITEMS" que hemos creado tambien necesita ser registrado, lo hacemos de la siguiente manera
    // Creamos un metodo llamado "register" que recibe un parametro tipo "IEventBus". Este metodo lo llamaremos desde la clase principal "KamuMod"
    // para que cuando FORGE cargue el mod, registre el metodo.
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
