package net.frizzkop.kamumod.block.custom;

import net.frizzkop.kamumod.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class WeedCropBlock extends CropBlock {
    public static final int MAX_AGE = 5; // EDAD MAXIMA DEL CULTIVO
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5; // PROPIEDADES DE EDAD 5

    public WeedCropBlock(Properties pProperties){
        super(pProperties);
    }



    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.WEED_SEEDS.get();
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
    }
}
