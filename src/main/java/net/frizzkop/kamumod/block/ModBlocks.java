package net.frizzkop.kamumod.block;

import net.frizzkop.kamumod.KamuMod;
import net.frizzkop.kamumod.block.custom.FardoHachisBlock;
import net.frizzkop.kamumod.block.custom.TobaccoCropBlock;
import net.frizzkop.kamumod.item.ModItems;
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
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).strength(1.0F).sound(SoundType.SAND)));

    public static final RegistryObject<Block> FARDO_HACHIS = registerBlock("fardo_hachis",
            () -> new FardoHachisBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).noOcclusion().sound(SoundType.SAND)));
    public static final RegistryObject<Block> TOBACCO_CROP = BLOCKS.register("tobacco_crop", () -> new TobaccoCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));


    // METHODS
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
