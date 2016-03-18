/*******************************************************************************
 * Copyright 2016, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package homesweethome.core;

import homesweethome.init.ModBlocks;
import homesweethome.init.ModCrafting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = HomeSweetHome.MOD_ID, name = HomeSweetHome.MOD_NAME)
public class HomeSweetHome
{
    public static final String MOD_NAME = "homesweethome";
    public static final String MOD_ID = "homesweethome";
    
    @Instance(MOD_ID)
    public static HomeSweetHome instance;
    
    @SidedProxy(clientSide = "homesweethome.core.ClientProxy", serverSide = "homesweethome.core.CommonProxy")
    public static CommonProxy proxy;
    
    public static Logger logger = LogManager.getLogger(MOD_ID);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {	
    	ModBlocks.init();
    	
    	ModCrafting.init();
    }
}
