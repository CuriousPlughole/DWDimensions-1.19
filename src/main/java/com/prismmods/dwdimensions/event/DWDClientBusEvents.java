package com.prismmods.dwdimensions.event;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.hud.RadiationHudOverlay;
import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.client.models.blockentity.tardis.TardisSmithCapaldiModel;
import com.prismmods.dwdimensions.client.models.blockentity.tardis.TardisTennantEcclestonModel;
import com.prismmods.dwdimensions.client.models.blockentity.tardis.TardisWhittakerModel;
import com.prismmods.dwdimensions.client.models.entity.GiantSkaroEelModel;
import com.prismmods.dwdimensions.client.models.entity.HandmineLeftModel;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import com.prismmods.dwdimensions.client.models.entity.dalek.BigDalekModel;
import com.prismmods.dwdimensions.client.models.entity.dalek.MediumDalekModel;
import com.prismmods.dwdimensions.client.models.entity.dalek.SmallDalekModel;
import com.prismmods.dwdimensions.client.models.entity.projectile.DalekLaserModel;
import com.prismmods.dwdimensions.client.renders.blockentities.TardisRenderer;
import com.prismmods.dwdimensions.client.renders.entity.DalekRenderer;
import com.prismmods.dwdimensions.client.renders.entity.FallingTardisRenderer;
import com.prismmods.dwdimensions.client.renders.entity.GiantSkaroEelRender;
import com.prismmods.dwdimensions.client.renders.entity.HandmineRender;
import com.prismmods.dwdimensions.client.renders.entity.projectile.DalekLaserRenderer;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.blockentities.DWDBlockEntities;
import com.prismmods.dwdimensions.common.blockentities.sign.DWDWoodTypes;
import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import com.prismmods.dwdimensions.common.entity.custom.GiantSkaroEelEntity;
import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekSpawnType;
import com.prismmods.dwdimensions.common.fluid.DWDFluids;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.common.item.custom.DalekSpawnerItem;
import com.prismmods.dwdimensions.common.item.custom.sonic.SonicPredicateGetter;
import com.prismmods.dwdimensions.common.item.custom.sonic.SonicScrewdriverItem;
import com.prismmods.dwdimensions.common.particle.DWDParticles;
import com.prismmods.dwdimensions.common.particle.custom.RadioactiveParticle;
import com.prismmods.dwdimensions.util.KeyboardHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = DWDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DWDClientBusEvents {


    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(DWDBlockEntities.TARDIS.get(), TardisRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DWDModelLayers.RIGHT_HANDMINE, HandmineRightModel::createBodyLayer);
        event.registerLayerDefinition(DWDModelLayers.LEFT_HANDMINE, HandmineLeftModel::createBodyLayer);
        event.registerLayerDefinition(DWDModelLayers.TARDIS_WHITTAKER, TardisWhittakerModel::createBodyLayer);
        event.registerLayerDefinition(DWDModelLayers.TARDIS_SMITH_CAPALDI, TardisSmithCapaldiModel::createBodyLayer);
        event.registerLayerDefinition(DWDModelLayers.TARDIS_TENNANT_ECCLESTON, TardisTennantEcclestonModel::createBodyLayer);
        event.registerLayerDefinition(DWDModelLayers.GIANT_SKARO_EEL, GiantSkaroEelModel::createBodyLayer);
        event.registerLayerDefinition(DWDModelLayers.BIG_DALEK, BigDalekModel::createBodyLayer);
        event.registerLayerDefinition(DWDModelLayers.MEDIUM_DALEK, MediumDalekModel::createBodyLayer);
        event.registerLayerDefinition(DWDModelLayers.SMALL_DALEK, SmallDalekModel::createBodyLayer);
        event.registerLayerDefinition(DWDModelLayers.DALEK_LASER, DalekLaserModel::createBodyLayer);
    }

    //FIXME: Need to remove the .setRenderLayer. Instead add "render_type": "cutout" etc. to the json block model. -> Datagen
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {

        EntityRenderers.register(DWDEntityTypes.HANDMINE.get(), HandmineRender::new);
        EntityRenderers.register(DWDEntityTypes.FALLING_TARDIS.get(), FallingTardisRenderer::new);
        EntityRenderers.register(DWDEntityTypes.GIANT_SKARO_EEL.get(), GiantSkaroEelRender::new);
        EntityRenderers.register(DWDEntityTypes.DALEK.get(), DalekRenderer::new);
        EntityRenderers.register(DWDEntityTypes.DALEK_LASER.get(), DalekLaserRenderer::new);

        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_JUNGLE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_JUNGLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_SHRUB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_SHRUB_SMALL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_DEAD_SHRUB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_DEAD_SHRUB_SMALL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_TALL_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_PETRIFIED_SHRUB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_PETRIFIED_FUNGUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.POTTED_SKARO_PETRIFIED_FUNGUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.VARGA_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_GRASS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_PLANK_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_PLANK_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_JUNGLE_PLANK_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_JUNGLE_PLANK_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.MERCURY_VAPOUR.get(), RenderType.translucent());

        WoodType.register(DWDWoodTypes.PETRIFIED);
        WoodType.register(DWDWoodTypes.PETRIFIED_JUNGLE);
        BlockEntityRenderers.register(DWDBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);

        Stream.of(DWDFluids.RADIOACTIVE_WATER_FLUID, DWDFluids.RADIOACTIVE_WATER_FLOWING).map(RegistryObject::get)
                .forEach(fluid -> ItemBlockRenderTypes.setRenderLayer(fluid, RenderType.translucent()));


        /**
         * ITEM PREDICATES
         */
        ItemProperties.register(DWDItems.DALEK_SPAWN_EGG.get(), new ResourceLocation(DWDimensions.MOD_ID, "dalek_type"), (itemStack, clientLevel, livingEntity, unknownInt) -> {
            if(itemStack == null || itemStack.isEmpty()) {
                return 0;
            }

            DalekSpawnType type = DalekSpawnerItem.getDalekType(itemStack);
            return type.ordinal();

        });
        ItemProperties.register(DWDItems.SONIC_SCREWDRIVER.get(), new ResourceLocation(DWDimensions.MOD_ID, "screwdriver_model"), (itemStack, clientLevel, livingEntity, unknownInt) -> {
            if(itemStack == null || itemStack.isEmpty()) {
                return 0;
            }
            return SonicPredicateGetter.getModelPredicate(SonicScrewdriverItem.getScrewdriverModel(itemStack));
        });
        ItemProperties.register(DWDItems.SONIC_SCREWDRIVER.get(), new ResourceLocation(DWDimensions.MOD_ID, "screwdriver_setting"), (itemStack, clientLevel, livingEntity, unknownInt) -> {
            if(itemStack == null || itemStack.isEmpty()) {
                return 0;
            }
            return SonicPredicateGetter.getSettingPredicate(SonicScrewdriverItem.getMode(itemStack));
        });
    }

    @SubscribeEvent
    public static void registerKeyBinds(RegisterKeyMappingsEvent event) {
        event.register(KeyboardHelper.tardisDoor);
    }

    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("radiation", RadiationHudOverlay.HUD_RADIATION);
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(DWDParticles.RADIOACTIVE_PARTICLES.get(), RadioactiveParticle.Provider::new);
    }

}
