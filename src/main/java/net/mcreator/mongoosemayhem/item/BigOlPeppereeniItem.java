
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
public class BigOlPeppereeniItem extends MongooseMayhemModElements.ModElement {
	@ObjectHolder("mongoose_mayhem:big_ol_peppereeni")
	public static final Item block = null;
	public BigOlPeppereeniItem(MongooseMayhemModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.5f).setAlwaysEdible().meat().build()));
			setRegistryName("big_ol_peppereeni");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Nice glizzy my guy"));
		}
	}
}
