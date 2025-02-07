package mod.patrigan.structure_toolkit.init;

import com.mojang.serialization.Codec;
import mod.patrigan.structure_toolkit.world.gen.processors.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.StructureProcessor;

import static mod.patrigan.structure_toolkit.StructureToolkit.MOD_ID;

public class ModProcessors {
    // Replacers
    public static IStructureProcessorType<AirRetainerProcessor> AIR_RETAINER;
    public static IStructureProcessorType<BlockMossifyProcessor> BLOCK_MOSSIFY;
    public static IStructureProcessorType<GradientReplaceProcessor> GRADIENT_SPOT_REPLACE;
    public static IStructureProcessorType<SpawnerRandomizerProcessor> SPAWNER_RANDOMIZER_PROCESSOR;
    // Adders
    public static IStructureProcessorType<CeilingAttachmentProcessor> CEILING_ATTACHMENT;
    public static IStructureProcessorType<LilyPadProcessor> LILY_PADS;
    public static IStructureProcessorType<MushroomProcessor> MUSHROOMS;
    public static IStructureProcessorType<SnowProcessor> SNOW;
    public static IStructureProcessorType<VineProcessor> VINES;
    // Decorators
    public static IStructureProcessorType<FlowerPotsProcessor> FLOWER_POTS;
    // Util
    public static IStructureProcessorType<WaterloggingFixProcessor> WATERLOGGING_FIX_PROCESSOR;
    public static IStructureProcessorType<WaterflowFixProcessor> WATERFLOW_FIX_PROCESSOR;


    public static void init(){
        // Replacers
        AIR_RETAINER = register("air_retainer", AirRetainerProcessor.CODEC);
        BLOCK_MOSSIFY = register("block_mossify", BlockMossifyProcessor.CODEC);
        GRADIENT_SPOT_REPLACE = register("gradient_replace", GradientReplaceProcessor.CODEC);
        SPAWNER_RANDOMIZER_PROCESSOR = register("spawner_randomizer", SpawnerRandomizerProcessor.CODEC);
        // Adders
        CEILING_ATTACHMENT = register("ceiling_attachment", CeilingAttachmentProcessor.CODEC);
        LILY_PADS = register("lily_pads", LilyPadProcessor.CODEC);
        MUSHROOMS = register("mushrooms", MushroomProcessor.CODEC);
        SNOW = register("snow", SnowProcessor.CODEC);
        VINES = register("vines", VineProcessor.CODEC);
        // Decorators
        FLOWER_POTS = register("flower_pots", FlowerPotsProcessor.CODEC);
        // Util
        WATERLOGGING_FIX_PROCESSOR = register("waterlogging_fix", WaterloggingFixProcessor.CODEC);
        WATERFLOW_FIX_PROCESSOR = register("waterflow_fix", WaterflowFixProcessor.CODEC);
    }

    static <P extends StructureProcessor> IStructureProcessorType<P> register(String name, Codec<P> codec) {
        return Registry.register(Registry.STRUCTURE_PROCESSOR, new ResourceLocation(MOD_ID, name), () -> {
            return codec;
        });
    }
}
