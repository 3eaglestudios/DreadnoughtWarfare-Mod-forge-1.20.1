package net.threeeaglestudios.dreadnoughtwarfare.datagen;

import net.minecraftforge.fml.common.Mod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DreadnoughtWarfare.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.KALPIUM_BLOCK.get(),
                        ModBlocks.RAW_KALPIUM_BLOCK.get(),
                        ModBlocks.KALPIUM_ORE.get(),
                        ModBlocks.KALPIUM_DEEPSLATE_ORE.get(),
                        ModBlocks.TORZENITE_BLOCK.get(),
                        ModBlocks.TORZENITE_ORE.get(),
                        ModBlocks.TORZENITE_DEEPSLATE_ORE.get(),
                        ModBlocks.RAW_TORZENITE_BLOCK.get());



        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.KALPIUM_BLOCK.get(),
                        ModBlocks.RAW_KALPIUM_BLOCK.get(),
                        ModBlocks.KALPIUM_ORE.get(),
                        ModBlocks.KALPIUM_DEEPSLATE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);


        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);








    }
}
