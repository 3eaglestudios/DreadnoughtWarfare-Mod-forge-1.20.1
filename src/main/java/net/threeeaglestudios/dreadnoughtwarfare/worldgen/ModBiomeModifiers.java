package net.threeeaglestudios.dreadnoughtwarfare.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;


public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_KALPIUM_ORE = registerKey("add_kalpium_ore");
    public static final ResourceKey<BiomeModifier> ADD_KALPIUM_DEEPSLATE_ORE = registerKey("add_kalpium_deepslate_ore");


    //register... Nether | etc. ...


    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placeFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_KALPIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placeFeatures.getOrThrow(ModPlacedFeatures.KALPIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_KALPIUM_DEEPSLATE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placeFeatures.getOrThrow(ModPlacedFeatures.KALPIUM_DEEPSLATE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));



        //register... Nether | etc. ...

    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(DreadnoughtWarfare.MOD_ID, name));
    }

}
