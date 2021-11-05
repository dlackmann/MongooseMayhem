
package net.mcreator.mongoosemayhem.item;

@MongooseMayhemModElements.ModElement.Tag
public class TESTItem extends MongooseMayhemModElements.ModElement {

	@ObjectHolder("mongoose_mayhem:test")
	public static final Item block = null;

	public TESTItem(MongooseMayhemModElements instance) {
		super(instance, 47);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("test");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
