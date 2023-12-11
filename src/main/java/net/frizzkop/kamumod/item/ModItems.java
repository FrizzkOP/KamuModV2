package net.frizzkop.kamumod.item;

import net.frizzkop.kamumod.KamuMod;
import net.frizzkop.kamumod.block.ModBlocks;
import net.frizzkop.kamumod.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
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

    // ITEMS
    public static final RegistryObject<Item> PLACA_HACHIS = ITEMS.register("placa_hachis", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> MEDIA_PLACA_HACHIS = ITEMS.register("media_placa_hachis", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BOLA_HACHIS = ITEMS.register("bola_hachis", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEED_BUD = ITEMS.register("weed_bud", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRINDED_WEED = ITEMS.register("grinded_weed", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PORRITO_MARIHUANA = ITEMS.register("porrito_marihuana", () -> new PorritoMarihuanaItem(new Item.Properties().durability(4)));
    public static final RegistryObject<Item> PORRITO_HACHIS = ITEMS.register("porrito_hachis", () -> new PorritoHachisItem(new Item.Properties().durability(4)));
    public static final RegistryObject<Item> TOBACCO_LEAVES = ITEMS.register("tobacco_leaves", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRY_TOBACCO_LEAVES = ITEMS.register("dry_tobacco_leaves", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIRAS_TABACO = ITEMS.register("tiras_tabaco", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TABACO_MEZCLADO = ITEMS.register("tabaco_mezclado", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PAPEL_RAW = ITEMS.register("papel_raw", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> GRINDER = ITEMS.register("grinder", () -> new GrinderItem(new Item.Properties().durability(20)));
    public static final RegistryObject<Item> BOQUILLA_CARTON = ITEMS.register("boquilla_carton", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOQUILLA_ALGODON = ITEMS.register("boquilla_algodon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEED_CIGARRETE_CASE = ITEMS.register("weed_cigarrete_case", () -> new WeedCigarreteCaseItem(new Item.Properties().durability(6)));
    public static final RegistryObject<Item> HACHIS_CIGARRETE_CASE = ITEMS.register("hachis_cigarrete_case", () -> new HachisCigarreteCaseItem(new Item.Properties().durability(6)));
    public static final RegistryObject<Item> ROLLING_PAPER_BOOKLET = ITEMS.register("rolling_paper_booklet", () -> new RollingPaperBookletItem(new Item.Properties().durability(18)));
    public static final RegistryObject<Item> EMPTY_BONG = ITEMS.register("empty_bong_item", () -> new EmptyBongItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> FILLED_BONG = ITEMS.register("filled_bong_item", () -> new FilledBongItem(new Item.Properties().stacksTo(1)));


    // ARMORS




    // TOOLS


    // FOOD
    public static final RegistryObject<Item> WEED_BROWNIE = ITEMS.register("weed_brownie", () -> new Item(new Item.Properties().food(ModFoods.WEED_BROWNIE).stacksTo(16)));
    public static final RegistryObject<Item> HALF_WEED_BROWNIE = ITEMS.register("half_weed_brownie", () -> new Item(new Item.Properties().food(ModFoods.HALF_WEED_BROWNIE).stacksTo(16)));
    public static final RegistryObject<Item> WEED_BROWNIE_DOUGH = ITEMS.register("weed_brownie_dough", () -> new Item(new Item.Properties().food(ModFoods.WEED_BROWNIE_DOUGH).stacksTo(16)));


    // SEEDS
    public static final RegistryObject<Item> TOBACCO_SEEDS = ITEMS.register("tobacco_seeds", () -> new ItemNameBlockItem(ModBlocks.TOBACCO_CROP.get(),new Item.Properties()));
    public static final RegistryObject<Item> WEED_SEEDS = ITEMS.register("weed_seeds", () -> new ItemNameBlockItem(ModBlocks.WEED_CROP.get(),new Item.Properties()));


    // El ArrayList "ITEMS" que hemos creado tambien necesita ser registrado, lo hacemos de la siguiente manera
    // Creamos un metodo llamado "register" que recibe un parametro tipo "IEventBus". Este metodo lo llamaremos desde la clase principal "KamuMod"
    // para que cuando FORGE cargue el mod, registre el metodo.
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
