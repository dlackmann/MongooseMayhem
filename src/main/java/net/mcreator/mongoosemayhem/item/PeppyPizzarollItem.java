
package net.mcreator.mongoosemayhem.item;

@MongooseMayhemModElements.ModElement.Tag
public class PeppyPizzarollItem extends MongooseMayhemModElements.ModElement {

	@ObjectHolder("mongoose_mayhem:peppy_pizzaroll")
	public static final Item block = null;

	public PeppyPizzarollItem(MongooseMayhemModElements instance) {
		super(instance, 48);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("peppy_pizzaroll");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Time to pop this baby into a furnace"));
		}

	}

}
