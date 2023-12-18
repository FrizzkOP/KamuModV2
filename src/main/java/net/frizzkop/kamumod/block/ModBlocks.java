package net.frizzkop.kamumod.block;

import net.frizzkop.kamumod.KamuMod;
import net.frizzkop.kamumod.block.custom.*;
import net.frizzkop.kamumod.item.ModItems;
import net.frizzkop.kamumod.item.custom.EmptyBongItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // DEFERRED REGISTER
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, KamuMod.MOD_ID);

    public static final RegistryObject<Block> BLOQUE_HACHIS = registerBlock("bloque_hachis",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD).strength(1.0F).sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<Block> FARDO_HACHIS = registerBlock("fardo_hachis",
            () -> new FardoHachisBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).noOcclusion().sound(SoundType.STONE)),1);
    public static final RegistryObject<Block> SMOKER_TABLE = registerBlock("smoker_table",
            () -> new SmokerTableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion()),1);
    public static final RegistryObject<Block> EMPTY_BONG = registerBlock("empty_bong_block",
            () -> new EmptyBongBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistryObject<Block> FILLED_BONG = registerBlock("filled_bong_block",
            () -> new FilledBongBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));


    // CONSOLES
    public static final RegistryObject<Block> XBOX360 = registerBlock("xbox360",
            () -> new Xbox360Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()),1);
    public static final RegistryObject<Block> PS1_FAT = registerBlock("ps1_fat",
            () -> new Ps1FatBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()),1);
    public static final RegistryObject<Block> PS2 = registerBlock("ps2",
            () -> new Ps2Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()),1);
    public static final RegistryObject<Block> PS3 = registerBlock("ps3",
            () -> new Ps3Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()),1);
    public static final RegistryObject<Block> PS4 = registerBlock("ps4",
            () -> new Ps4Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()),1);
    public static final RegistryObject<Block> PS5 = registerBlock("ps5",
            () -> new Ps5Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()),1);
    public static final RegistryObject<Block> SWITCH_DOCK = registerBlock("switch_dock",
            () -> new SwitchDockBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()),1);

    public static final RegistryObject<Block> DOCKED_SWITCH = registerBlock("docked_switch",
            () -> new DockedSwitchBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()),1);

    public static final RegistryObject<Block> GAMECUBE = registerBlock("gamecube",
            () -> new GamecubeBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()),1);


    // CROPS
    public static final RegistryObject<Block> TOBACCO_CROP = BLOCKS.register("tobacco_crop", () -> new TobaccoCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> WEED_CROP = BLOCKS.register("weed_crop", () -> new WeedCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> ALUCINOGEN_MUSHROOM_CROP = BLOCKS.register("alucinogen_mushroom_crop", () -> new AlucinogenMushroomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));


    // METHODS
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, int maxStackSize){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerStackableBlockItem(name, toReturn, maxStackSize);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerStackableBlockItem(String name, RegistryObject<T> block, int maxStackSize) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(maxStackSize)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
