
package net.mcreator.mongoosemayhem.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.mongoosemayhem.MongooseMayhemModElements;

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
	}
}
