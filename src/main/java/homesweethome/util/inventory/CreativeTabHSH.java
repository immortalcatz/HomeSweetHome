package homesweethome.util.inventory;

import homesweethome.api.HSHBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabHSH extends CreativeTabs
{
    public static final CreativeTabs instance = new CreativeTabHSH(CreativeTabs.getNextID(), "tabHomeSweetHome");

    private CreativeTabHSH(int index, String label)
    {
        super(index, label);
    }

    @Override
    public Item getTabIconItem()
    {
        return new ItemStack(HSHBlocks.cushioned_chair).getItem();
    }
}
