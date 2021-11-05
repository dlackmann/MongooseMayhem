
package net.mcreator.mongoosemayhem.item;

@MongooseMayhemModElements.ModElement.Tag
public class BigOlSmokedPeppereeniItem extends MongooseMayhemModElements.ModElement {

	@ObjectHolder("mongoose_mayhem:big_ol_smoked_peppereeni")
	public static final Item block = null;

	public BigOlSmokedPeppereeniItem(MongooseMayhemModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(1f)

							.build()));
			setRegistryName("big_ol_smoked_peppereeni");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
