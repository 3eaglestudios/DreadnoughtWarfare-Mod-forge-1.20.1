package net.threeeaglestudios.dreadnoughtwarfare.item;


import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DreadnoughtWarfare.MOD_ID);



        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
}
