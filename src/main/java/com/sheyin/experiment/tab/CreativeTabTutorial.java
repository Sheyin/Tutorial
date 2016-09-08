package com.sheyin.experiment.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Sheyin on 9/8/2016.
 */
public class CreativeTabTutorial extends CreativeTabs {
    // add a constructor - alt+insert

    // set id and name
    public CreativeTabTutorial(int index, String label) {
        super(index, label);
    }

    // ctrl+O, ctrl+I for override shortcut
    @Override
    // this method returns which icon to display for the tab
    public Item getTabIconItem() {
        return Items.CHICKEN;       // this is just a vanilla item / placeholder
    }
}
