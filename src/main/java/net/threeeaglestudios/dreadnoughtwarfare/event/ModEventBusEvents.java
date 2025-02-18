package net.threeeaglestudios.dreadnoughtwarfare.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.entity.ModEntities;
import net.threeeaglestudios.dreadnoughtwarfare.entity.client.ArtilleryModel;
import net.threeeaglestudios.dreadnoughtwarfare.entity.custom.ArtilleryEntity;
import net.threeeaglestudios.dreadnoughtwarfare.entity.layers.ModModelLayers;

@Mod.EventBusSubscriber(modid = DreadnoughtWarfare.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.ARTILLERY_LAYER, ArtilleryModel::createBodyLayer);
    }

//    @SubscribeEvent
//    public static void registerAttributes(EntityAttributeCreationEvent event) {
//        event.put(ModEntities.ARTILLERY.get(), ArtilleryEntity.createAttributes().build());
//    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }

}
