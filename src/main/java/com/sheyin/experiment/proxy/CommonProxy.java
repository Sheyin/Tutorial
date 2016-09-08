package com.sheyin.experiment.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Sheyin on 9/8/2016.
 */


public class CommonProxy {

    // some of this taken from wehavecookies's tutorial
    // the preinitialization event as a parameter can be helpful but not required
    public void preInit(FMLPreInitializationEvent event) {
        //event.getModConfigurationDirectory();       // one of the more useful ones
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    // from shadow's tutorial
    public void registerItemRenderer(Item item, int meta, String id) {
        // need at least an empty stub here if client-only code
    }

}