
package net.mcreator.mongoosemayhem.item;

@MongooseMayhemModElements.ModElement.Tag
public class CookedPeppereeniPizzarollItem extends MongooseMayhemModElements.ModElement {

	@ObjectHolder("mongoose_mayhem:cooked_peppereeni_pizzaroll")
	public static final Item block = null;

	public CookedPeppereeniPizzarollItem(MongooseMayhemModElements instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.1f).setAlwaysEdible()

							.build()));
			setRegistryName("cooked_peppereeni_pizzaroll");
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
