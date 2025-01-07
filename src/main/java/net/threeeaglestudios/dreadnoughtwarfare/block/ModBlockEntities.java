package net.threeeaglestudios.dreadnoughtwarfare.block;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.block.entity.HelleniumKingdomFlagEntity;
//import net.threeeaglestudios.dreadnoughtwarfare.block.entity.ItalyFlagEntity;
import software.bernie.example.registry.BlockRegistry;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DreadnoughtWarfare.MOD_ID);

    public static final RegistryObject<BlockEntityType<HelleniumKingdomFlagEntity>> HELLENIUM_KINGDOM_FLAG = BLOCK_ENTITIES.register("hellenium_kingdom_flag",
            () -> BlockEntityType.Builder.of(HelleniumKingdomFlagEntity::new, ModBlocks.HELLENIUM_KINGDOM_FLAG.get()).build(null));

//    public static final RegistryObject<BlockEntityType<ItalyFlagEntity>> ITALY_FLAG = BLOCK_ENTITIES.register("italy_flag",
//            () -> BlockEntityType.Builder.of(ItalyFlagEntity::new, ModBlocks.ITALY_FLAG.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}