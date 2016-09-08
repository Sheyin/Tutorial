/**
 * Created by Sheyin on 9/8/2016.
 */

package com.sheyin.experiment.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.sheyin.experiment.TutorialMod;


public class ItemBase extends Item {
    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        //from other guide - comment out since no creative tab exists yet
        //setCreativeTab(TutorialMod.creativeTab);
    }

    //@Override
    //public void registerItemModel(Item item) {
    //    // guide uses TutorialMod.proxy.registerItemRenderer
    //    TutorialMod.proxy.registerItemRenderer(this, 0, name);
    //}

    public void registerItemModel() {
        TutorialMod.proxy.registerItemRenderer(this, 0, name);

    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
