
package net.mcreator.mongoosemayhem.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.mongoosemayhem.MongooseMayhemModElements;

import java.util.List;

@MongooseMayhemModElements.ModElement.Tag
public class CookedCheesyPizzarollItem extends MongooseMayhemModElements.ModElement {
	@ObjectHolder("mongoose_mayhem:cooked_cheesy_pizzaroll")
	public static final Item block = null;
	public CookedCheesyPizzarollItem(MongooseMayhemModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.1f).setAlwaysEdible().build()));
			setRegistryName("cooked_cheesy_pizzaroll");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 15;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Table's favorite food"));
			list.add(new StringTextComponent("always gets him in the mood"));
		}
	}
}
