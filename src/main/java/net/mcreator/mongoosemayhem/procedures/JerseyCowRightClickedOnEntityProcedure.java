package net.mcreator.mongoosemayhem.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
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
import net.mcreator.mongoosemayhem.MongooseMayhemMod;

import java.util.Map;
import java.util.HashMap;

public class JerseyCowRightClickedOnEntityProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
			Entity entity = event.getTarget();
			PlayerEntity sourceentity = event.getPlayer();
			if (event.getHand() != sourceentity.getActiveHand()) {
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
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MongooseMayhemMod.LOGGER.warn("Failed to load dependency entity for procedure JerseyCowRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MongooseMayhemMod.LOGGER.warn("Failed to load dependency sourceentity for procedure JerseyCowRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MongooseMayhemMod.LOGGER.warn("Failed to load dependency x for procedure JerseyCowRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MongooseMayhemMod.LOGGER.warn("Failed to load dependency y for procedure JerseyCowRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MongooseMayhemMod.LOGGER.warn("Failed to load dependency z for procedure JerseyCowRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MongooseMayhemMod.LOGGER.warn("Failed to load dependency world for procedure JerseyCowRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == Items.BUCKET)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
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
			}.checkGamemode(sourceentity)))) {
				if (sourceentity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.BUCKET);
					_setstack.setCount(
							(int) (((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
									.getCount()) - 1));
					((LivingEntity) sourceentity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (sourceentity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) sourceentity).inventory.markDirty();
				}
			}
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Blocks.AIR.asItem())) {
				if (sourceentity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(MelkBucketItem.block);
					_setstack.setCount((int) 1);
					((LivingEntity) sourceentity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (sourceentity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) sourceentity).inventory.markDirty();
				}
			} else {
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(MelkBucketItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.milk")),
						SoundCategory.BLOCKS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.milk")),
						SoundCategory.BLOCKS, (float) 1, (float) 1, false);
			}
		}
	}
}
