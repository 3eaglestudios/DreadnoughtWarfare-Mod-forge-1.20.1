package net.threeeaglestudios.dreadnoughtwarfare.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.entity.custom.ArtilleryEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DreadnoughtWarfare.MOD_ID);

    public static final RegistryObject<EntityType<ArtilleryEntity>> ARTILLERY =
            ENTITY_TYPES.register("artillery", () -> EntityType.Builder.of(ArtilleryEntity::new, MobCategory.MISC)
                    .sized(1.5f,1.5f).build("artillery"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
