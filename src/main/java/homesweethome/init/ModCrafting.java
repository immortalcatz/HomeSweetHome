package homesweethome.init;

import homesweethome.api.HSHBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModCrafting
{
    public static void init()
    {
        addOreRegistration();
        addCraftingRecipies();
        addSmeltingRecipes();
        //removeCraftingRecipes();
    }
    
    private static void addCraftingRecipies()
    {
    	// Register crafting recipes
    	
    	// Chairs
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HSHBlocks.chair, 2), new Object [] {"W  ", "WWW", "W W", 'W', "plankWood"}));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HSHBlocks.cushioned_chair, 2), new Object [] {"WCC", "WWW", "W W", 'W', "plankWood", 'C', Blocks.wool}));
    
    	// Tables
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HSHBlocks.end_table, 2), new Object [] {"WWW", "W W", "W W", 'W', "plankWood"}));
    }
    
    public static void addSmeltingRecipes()
    {
    	// Register smelting recipes
    }
    
    private static void addOreRegistration()
    {
    	//Registration in Ore Dictionary
    }
    
    /*private static void removeCraftingRecipes()
    {
    	List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
    	
    	Iterator<IRecipe> remover = recipes.iterator();
    	
    	while (remover.hasNext())
    	{
    		ItemStack itemstack = remover.next().getRecipeOutput();
    		if (itemstack != null && Block.getBlockFromItem(itemstack.getItem()) == Blocks.torch)
    		{
    			remover.remove();
    		}
    	}
    }*/
}
