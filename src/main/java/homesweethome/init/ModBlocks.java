package homesweethome.init;

import static homesweethome.api.HSHBlocks.chair;
import homesweethome.api.IHSHBlock;
import homesweethome.block.BlockHSHChair;
import homesweethome.core.HomeSweetHome;
import homesweethome.util.BlockStateUtils;
import homesweethome.util.inventory.CreativeTabHSH;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.google.common.collect.ImmutableSet;

public class ModBlocks
{
    
    public static void init()
    {
        chair = registerBlock( new BlockHSHChair(), "chair" );
    }
    
    
    public static void registerBlockVariant(Block block, String stateName, int stateMeta)
    {
        Item item = Item.getItemFromBlock(block);
        HomeSweetHome.proxy.registerItemVariantModel(item, stateName, stateMeta);
    }
    
    public static Block registerBlock(Block block, String blockName)
    {
        // by default, set the creative tab for all blocks added in TAN to CreativeTabTAN.instance
        return registerBlock(block, blockName, CreativeTabHSH.instance);
    }
    
    public static Block registerBlock(Block block, String blockName, CreativeTabs tab)
    {

        block.setUnlocalizedName(blockName);        
        block.setCreativeTab(tab);
        
        if (block instanceof IHSHBlock)
        {
            // if this block supports the IBOPBlock interface then we can determine the item block class, and sub-blocks automatically
            IHSHBlock bopBlock = (IHSHBlock)block;
            GameRegistry.registerBlock(block, bopBlock.getItemClass(), blockName);
            
            HomeSweetHome.proxy.registerNonRenderingProperties(block);
            
            // check for missing default states
            IBlockState defaultState = block.getDefaultState();
            if (defaultState == null)
            {
                defaultState = block.getBlockState().getBaseState();
                HomeSweetHome.logger.error("missing default state for " + block.getUnlocalizedName());
            }
            
            // get the preset blocks variants
            ImmutableSet<IBlockState> presets = BlockStateUtils.getBlockPresets(block);
            if (presets.isEmpty())
            {
                // block has no sub-blocks to register
                registerBlockVariant(block, blockName, 0);
            }
            else
            {
                // register all the sub-blocks
                for (IBlockState state : presets)
                {
                    String stateName = bopBlock.getStateName(state);
                    int stateMeta = block.getMetaFromState(state);
                    registerBlockVariant(block, stateName, stateMeta);
                }
            }
        }
        else
        {
            // for vanilla blocks, just register a single variant with meta=0 and assume ItemBlock for the item class
            GameRegistry.registerBlock(block, ItemBlock.class , blockName);
            registerBlockVariant(block, blockName, 0);
        }

        return block;
    }
    
}
