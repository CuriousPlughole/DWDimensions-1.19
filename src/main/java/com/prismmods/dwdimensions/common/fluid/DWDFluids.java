package com.prismmods.dwdimensions.common.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Vector3f;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class DWDFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, DWDimensions.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DWDimensions.MOD_ID);

    public static ForgeFlowingFluid.Properties fluidProperties() {
        return new ForgeFlowingFluid.Properties(RADIOACTIVE_WATER_TYPE, RADIOACTIVE_WATER_FLUID, RADIOACTIVE_WATER_FLOWING)
                .block(RADIOACTIVE_WATER_BLOCK).bucket(RADIOACTIVE_WATER_BUCKET);
    }

    public static final RegistryObject<FluidType> RADIOACTIVE_WATER_TYPE = FLUID_TYPES.register("radioactive_water_fluid",
            () -> new FluidType(FluidType.Properties.create().supportsBoating(true).canHydrate(true).canConvertToSource(true).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new IClientFluidTypeExtensions() {
                        public static final ResourceLocation STILL = new ResourceLocation("block/water_still"),
                                FLOW = new ResourceLocation("block/water_flow");
                                //OVERLAY = new ResourceLocation("block/obsidian"),
                                //VIEW_OVERLAY = new ResourceLocation("textures/block/obsidian.png");

                        @Override
                        public ResourceLocation getStillTexture()
                        {
                            return STILL;
                        }

                        @Override
                        public ResourceLocation getFlowingTexture()
                        {
                            return FLOW;
                        }

                        /*
                        @Override
                        public ResourceLocation getOverlayTexture()
                        {
                            return OVERLAY;
                        }

                        @Override
                        public ResourceLocation getRenderOverlayTexture(Minecraft mc)
                        {
                            return VIEW_OVERLAY;
                        }*/

                        @Override
                        public int getTintColor()
                        {
                            return 0xAF5CED92;
                        }

                        @Override
                        public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor)
                        {
                            int color = this.getTintColor();
                            return new Vector3f((color >> 16 & 0xFF) / 255F, (color >> 8 & 0xFF) / 255F, (color & 0xFF) / 255F);
                        }

                        @Override
                        public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape)
                        {
                            nearDistance = -8F;
                            farDistance = 24F;

                            if (farDistance > renderDistance)
                            {
                                farDistance = renderDistance;
                                shape = FogShape.CYLINDER;
                            }

                            RenderSystem.setShaderFogStart(nearDistance);
                            RenderSystem.setShaderFogEnd(farDistance);
                            RenderSystem.setShaderFogShape(shape);
                        }
                    });
                }
            });

    public static final RegistryObject<FlowingFluid> RADIOACTIVE_WATER_FLUID
            = FLUIDS.register("radioactive_water_fluid", () -> new ForgeFlowingFluid.Source(fluidProperties()));
    public static final RegistryObject<FlowingFluid> RADIOACTIVE_WATER_FLOWING
            = FLUIDS.register("radioactive_water_flowing", () -> new ForgeFlowingFluid.Flowing(fluidProperties()));
    public static final RegistryObject<LiquidBlock> RADIOACTIVE_WATER_BLOCK = DWDBlocks.BLOCKS.register("radioactive_water",
            () -> new LiquidBlock(RADIOACTIVE_WATER_FLUID, BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noLootTable()));
    public static final RegistryObject<Item> RADIOACTIVE_WATER_BUCKET = DWDItems.ITEMS.register("radioactive_water_bucket", () ->
            new BucketItem(RADIOACTIVE_WATER_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));






    /*
    public static final RegistryObject<FlowingFluid> RADIOACTIVE_WATER_FLUID
            = FLUIDS.register("radioactive_water_fluid", () -> new ForgeFlowingFluid.Source(DWDFluids.RADIOACTIVE_WATER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> RADIOACTIVE_WATER_FLOWING
            = FLUIDS.register("radioactive_water_flowing", () -> new ForgeFlowingFluid.Flowing(DWDFluids.RADIOACTIVE_WATER_PROPERTIES));

    public static final ForgeFlowingFluid.Properties RADIOACTIVE_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> RADIOACTIVE_WATER_FLUID, () -> RADIOACTIVE_WATER_FLOWING.get(), FluidType.Properties.create());

    public static final RegistryObject<LiquidBlock> RADIOACTIVE_WATER_BLOCK = DWDBlocks.BLOCKS.register("radioactive_water",
            () -> new LiquidBlock(() -> DWDFluids.RADIOACTIVE_WATER_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noLootTable()));*/



    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }
}
