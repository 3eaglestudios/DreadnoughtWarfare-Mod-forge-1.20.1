package net.threeeaglestudios.dreadnoughtwarfare.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.block.custom.HelleniumKingdomFlag;
import net.threeeaglestudios.dreadnoughtwarfare.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DreadnoughtWarfare.MOD_ID);


    public static final RegistryObject<Block> HELLENIUM_KINGDOM_FLAG = registerBlock("hellenium_kingdom_flag",
            () -> new HelleniumKingdomFlag(BlockBehaviour.Properties.of()
                    .strength(4).noOcclusion()));

//    public static final RegistryObject<Block> ITALY_FLAG = registerBlock("italy_flag",
//            () -> new HelleniumKingdomFlag(BlockBehaviour.Properties.of()
//                    .strength(4).noOcclusion()));

    public static final RegistryObject<Block> KALPIUM_BLOCK = registerBlock("kalpium_block",
            () -> new Block(BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> RAW_KALPIUM_BLOCK = registerBlock("raw_kalpium_block",
            () -> new Block(BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> KALPIUM_ORE = registerBlock("kalpium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(2,5)));

    public static final RegistryObject<Block> KALPIUM_DEEPSLATE_ORE = registerBlock("kalpium_deepslate_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(2,5)));

    public static final RegistryObject<Block> TORZENITE_ORE = registerBlock("torzenite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(2,5)));

    public static final RegistryObject<Block> TORZENITE_DEEPSLATE_ORE = registerBlock("torzenite_deepslate_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(2,5)));

    public static final RegistryObject<Block> TORZENITE_BLOCK = registerBlock("torzenite_block",
            () -> new Block(BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> RAW_TORZENITE_BLOCK = registerBlock("raw_torzenite_block",
            () -> new Block(BlockBehaviour.Properties.of()));




    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
