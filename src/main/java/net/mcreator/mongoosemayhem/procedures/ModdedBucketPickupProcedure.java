package net.mcreator.mongoosemayhem.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;

import net.mcreator.mongoosemayhem.item.MelkBucketItem;
import net.mcreator.mongoosemayhem.item.BucketOSauceItem;
import net.mcreator.mongoosemayhem.block.PizzaSauceBlock;
import net.mcreator.mongoosemayhem.block.MelkBlock;
import net.mcreator.mongoosemayhem.MongooseMayhemMod;

import java.util.Map;
import java.util.HashMap;

public class ModdedBucketPickupProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MongooseMayhemMod.LOGGER.warn("Failed to load dependency entity for procedure ModdedBucketPickup!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MongooseMayhemMod.LOGGER.warn("Failed to load dependency world for procedure ModdedBucketPickup!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double localRaytaceDistance = 0;
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.BUCKET)) {
			localRaytaceDistance = (double) 0.5;
			for (int index0 = 0; index0 < (int) (5); index0++) {
				if (((((world
						.getFluidState(new BlockPos(
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
												entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
												entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
												entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
						.getBlockState()).getFluidState().isSource()) == (true))
						&& ((world
								.getFluidState(new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
														entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
														entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
														entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.getBlockState()).getBlock() == PizzaSauceBlock.block))) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					world.setBlockState(
							new BlockPos(
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())),
							Blocks.AIR.getDefaultState(), 3);
					if ((!(world.isRemote()))) {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null,
									new BlockPos(
											(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
															entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
											(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
															entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
											(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
															entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					}
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(Items.BUCKET);
							_setstack.setCount(
									(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
											.getCount()) - 1));
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
						if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == Blocks.AIR.asItem())) {
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = new ItemStack(BucketOSauceItem.block);
								_setstack.setCount((int) 1);
								((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
							}
						} else {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(BucketOSauceItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
					}
					break;
				}
				if (((((world
						.getFluidState(new BlockPos(
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
												entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
												entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
												entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
						.getBlockState()).getFluidState().isSource()) == (true))
						&& ((world
								.getFluidState(new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
														entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
														entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
														entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.getBlockState()).getBlock() == MelkBlock.block))) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					world.setBlockState(
							new BlockPos(
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())),
							Blocks.AIR.getDefaultState(), 3);
					if ((!(world.isRemote()))) {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null,
									new BlockPos(
											(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
															entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
											(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
															entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
											(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
															entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytaceDistance,
													entity.getLook(1f).y * localRaytaceDistance, entity.getLook(1f).z * localRaytaceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
					}
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(Items.BUCKET);
							_setstack.setCount(
									(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
											.getCount()) - 1));
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
						if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == Blocks.AIR.asItem())) {
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = new ItemStack(MelkBucketItem.block);
								_setstack.setCount((int) 1);
								((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
							}
						} else {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(MelkBucketItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
					}
				}
				localRaytaceDistance = (double) (localRaytaceDistance + 1);
			}
		}
	}
}
