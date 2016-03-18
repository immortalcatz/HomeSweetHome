package homesweethome.block;

import homesweethome.api.IHSHBlock;
import homesweethome.item.ItemHSHBlock;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHSHChair extends Block implements IHSHBlock
{

    // implement IBOPBlock
    @Override
    public Class<? extends ItemBlock> getItemClass() { return ItemHSHBlock.class; }
    @Override
    public int getItemRenderColor(IBlockState state, int tintIndex) { return this.getRenderColor(state); }
    @Override
    public IProperty[] getPresetProperties() { return new IProperty[] {}; }
    @Override
    public IProperty[] getNonRenderingProperties() { return null; }
    @Override
    public String getStateName(IBlockState state) {return "";}

    
    public BlockHSHChair() {
        // use rock as default material
        this(Material.wood);
    }
    
    public BlockHSHChair(Material material)
    {
        super(material);
        // set some defaults
        this.setTickRandomly(true);
        this.setHardness(1.0F);
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.6F, 0.9F);
        this.setStepSound(Block.soundTypeWood);
    }
    
    // not opaque
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    // not full cube
    @Override
    public boolean isFullCube()
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
}