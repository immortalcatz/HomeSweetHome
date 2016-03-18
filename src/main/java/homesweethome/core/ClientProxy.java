/*******************************************************************************
 * Copyright 2016, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package homesweethome.core;

import homesweethome.api.IHSHBlock;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;


public class ClientProxy extends CommonProxy
{
	
    @Override
    public void registerItemVariantModel(Item item, String name, int metadata) 
    {
        if (item != null) 
        { 
            ModelBakery.registerItemVariants(item, new ResourceLocation("homesweethome:" + name));
            ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(HomeSweetHome.MOD_ID + ":" + name, "inventory"));
        }
    }
    
    @Override
    public void registerNonRenderingProperties(Block block) 
    {
        if (block instanceof IHSHBlock)
        {
            IHSHBlock hshBlock = (IHSHBlock)block;
            IProperty[] nonRenderingProperties = hshBlock.getNonRenderingProperties();

            if (nonRenderingProperties != null)
            {
                // use a custom state mapper which will ignore the properties specified in the block as being non-rendering
                IStateMapper custom_mapper = (new StateMap.Builder()).ignore(nonRenderingProperties).build();
                ModelLoader.setCustomStateMapper(block, custom_mapper);
            }
        }
    }
}
