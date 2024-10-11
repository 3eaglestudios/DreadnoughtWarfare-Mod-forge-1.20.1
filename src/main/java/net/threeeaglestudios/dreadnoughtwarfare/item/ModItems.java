package net.threeeaglestudios.dreadnoughtwarfare.item;


import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.block.custom.HelleniumKingdomFlag;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DreadnoughtWarfare.MOD_ID);


    public static final RegistryObject<Item> KALPIUM_INGOT = ITEMS.register("kalpium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_KALPIUM = ITEMS.register("raw_kalpium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TORZENITE_INGOT = ITEMS.register("torzenite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_TORZENITE = ITEMS.register("raw_torzenite",
            () -> new Item(new Item.Properties()));






    public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
}
