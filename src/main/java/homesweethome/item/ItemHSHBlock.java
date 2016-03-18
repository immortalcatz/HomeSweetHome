package homesweethome.item;

import homesweethome.api.IHSHBlock;
import homesweethome.util.BlockStateUtils;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.ImmutableSet;

public class ItemHSHBlock extends ItemBlock
{
    
    public IHSHBlock hshBlock;
    
    public ItemHSHBlock(Block block)
    {
        super(block);
        if (block instanceof IHSHBlock)
        {
            this.hshBlock = (IHSHBlock)block;
        }
        else
        {
            throw new IllegalArgumentException("ItemHSHBlock must be created with a block implementing IHSHBlock");
        }
        this.setHasSubtypes(true);
    }
    
    // define the items which will appear in the creative tab (called by ItemBlock class)
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems)
    {        
        ImmutableSet<IBlockState> presets = BlockStateUtils.getBlockPresets(this.block);
        if (presets.isEmpty())
        {
            subItems.add(new ItemStack(this.block, 1, 0));
        }
        else
        {
            for (IBlockState state : presets)
            {
                subItems.add(new ItemStack(this.block, 1, this.block.getMetaFromState(state)));
            }
        }
    }

    @Override
    public int getMetadata(int metadata)
    {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        ImmutableSet<IBlockState> presets = BlockStateUtils.getBlockPresets(this.block);
        if (presets.isEmpty())
        {
            return super.getUnlocalizedName();
        }
        else
        {
            int meta = stack.getMetadata();
            IBlockState oldState = block.getStateFromMeta(meta);
            IBlockState newState = BlockStateUtils.getPresetState(oldState);

            return super.getUnlocalizedName() + "." + hshBlock.getStateName(newState);
        }
    }
}
