package homesweethome.util.inventory;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

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
        return Items.bed;
    }
}
