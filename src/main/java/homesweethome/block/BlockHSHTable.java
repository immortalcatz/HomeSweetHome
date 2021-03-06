package homesweethome.block;

import homesweethome.api.IHSHBlock;
import homesweethome.item.ItemHSHBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHSHTable extends Block implements IHSHBlock
{
    protected static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.9D, 0.9D);
    
    // implement IBOPBlock
    @Override
    public Class<? extends ItemBlock> getItemClass() { return ItemHSHBlock.class; }
    @Override
    public IProperty[] getPresetProperties() { return new IProperty[] {}; }
    @Override
    public IProperty[] getNonRenderingProperties() { return null; }
    @Override
    public String getStateName(IBlockState state) {return "";}

    
    public BlockHSHTable() {
        // use rock as default material
        this(Material.wood);
    }
    
    public BlockHSHTable(Material material)
    {
        super(material);
        // set some defaults
        this.setTickRandomly(true);
        this.setHardness(1.0F);
        this.setSoundType(SoundType.WOOD);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BOUNDING_BOX;
    }
    
    // not opaque
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    // not full cube
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    
}