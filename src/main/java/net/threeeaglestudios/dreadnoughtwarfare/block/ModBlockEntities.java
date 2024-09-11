package net.threeeaglestudios.dreadnoughtwarfare.block;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.block.entity.HelleniumKingdomFlagEntity;
import software.bernie.example.registry.BlockRegistry;

public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITY_TYPES, DreadnoughtWarfare.MOD_ID);

    public static final RegistryObject<BlockEntityType<HelleniumKingdomFlagEntity>> HELLENIUM_KINGDOM_FLAG = TILES.register("hellenium_kingdom_flag",
            () -> BlockEntityType.Builder.of(HelleniumKingdomFlagEntity::new, ModBlocks.HELLENIUM_KINGDOM_FLAG.get()).build(null));

}