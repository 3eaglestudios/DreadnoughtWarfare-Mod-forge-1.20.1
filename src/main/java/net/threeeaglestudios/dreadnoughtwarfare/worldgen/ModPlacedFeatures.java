package net.threeeaglestudios.dreadnoughtwarfare.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> KALPIUM_ORE_PLACED_KEY = registerKey("kalpium_ore_placed");
    public static final ResourceKey<PlacedFeature> KALPIUM_DEEPSLATE_ORE_PLACED_KEY = registerKey("kalpium_deepslate_ore_placed");
    public static final ResourceKey<PlacedFeature> TORZENITE_ORE_PLACED_KEY = registerKey("torzenite_ore_placed");
    public static final ResourceKey<PlacedFeature> TORZENITE_DEEPSLATE_ORE_PLACED_KEY = registerKey("torzenite_deepslate_ore_placed");

    public  static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //KALPIUM
        register(context, KALPIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_KALPIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(70))));

        register(context, KALPIUM_DEEPSLATE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_KALPIUM_DEEPSLATE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(25))));

        //TORZENITE
        register(context, TORZENITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TORZENITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(70))));

        register(context, TORZENITE_DEEPSLATE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TORZENITE_DEEPSLATE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(25))));


            //register... Nether | etc. ...

    }



    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DreadnoughtWarfare.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }


}
