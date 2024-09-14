package net.threeeaglestudios.dreadnoughtwarfare.datagen;

import net.minecraftforge.fml.common.Mod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DreadnoughtWarfare.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.KALPIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_KALPIUM_BLOCK);
        blockWithItem(ModBlocks.KALPIUM_ORE);
        blockWithItem(ModBlocks.KALPIUM_DEEPSLATE_ORE);

//       blockWithItem(ModBlocks.HELLENIUM_KINGDOM_FLAG);
//
//
//        simpleBlockWithItem(ModBlocks.HELLENIUM_KINGDOM_FLAG.get(),
//                new ModelFile.UncheckedModelFile(modLoc("geo/hellenium_kingdom_flag.geo")));

    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
