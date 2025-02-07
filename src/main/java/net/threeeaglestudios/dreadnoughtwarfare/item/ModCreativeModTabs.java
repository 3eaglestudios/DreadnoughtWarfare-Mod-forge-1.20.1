package net.threeeaglestudios.dreadnoughtwarfare.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DreadnoughtWarfare.MOD_ID);

    public  static final RegistryObject<CreativeModeTab> DREADNOUGHT_WARFARE_ORES_TAB = CREATIVE_MODE_TABS.register("dreadnought_warfare_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.NETHERITE_CHESTPLATE))
                    .title(Component.translatable("creativetab.dreadnought_warfare_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        //Put them in the right order, please...

                        //Items

                        pOutput.accept(ModItems.RAW_KALPIUM.get());
                        pOutput.accept(ModItems.KALPIUM_INGOT.get());
                        pOutput.accept(ModItems.RAW_TORZENITE.get());
                        pOutput.accept(ModItems.TORZENITE_INGOT.get());


                        //Blocks
                        pOutput.accept(ModBlocks.KALPIUM_ORE.get());
                        pOutput.accept(ModBlocks.KALPIUM_DEEPSLATE_ORE.get());
                        pOutput.accept(ModBlocks.RAW_KALPIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.KALPIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.TORZENITE_ORE.get());
                        pOutput.accept(ModBlocks.TORZENITE_DEEPSLATE_ORE.get());
                        pOutput.accept(ModBlocks.RAW_TORZENITE_BLOCK.get());
                        pOutput.accept(ModBlocks.TORZENITE_BLOCK.get());


                        //Custom
                        pOutput.accept(ModBlocks.HELLENIUM_KINGDOM_FLAG.get());

                        //Entities




                        //pOutput.accept(ModItems.EXAMPLE.get())



                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
