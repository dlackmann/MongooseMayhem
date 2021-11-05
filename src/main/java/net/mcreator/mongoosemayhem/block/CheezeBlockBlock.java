
package net.mcreator.mongoosemayhem.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@MongooseMayhemModElements.ModElement.Tag
public class CheezeBlockBlock extends MongooseMayhemModElements.ModElement {

	@ObjectHolder("mongoose_mayhem:cheeze_block")
	public static final Block block = null;

	public CheezeBlockBlock(MongooseMayhemModElements instance) {
		super(instance, 51);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.SPONGE).sound(SoundType.HONEY).hardnessAndResistance(1f, 4f).setLightLevel(s -> 0)
					.jumpFactor(2.5f));

			setRegistryName("cheeze_block");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
