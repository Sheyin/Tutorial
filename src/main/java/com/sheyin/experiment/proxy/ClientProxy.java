package com.sheyin.experiment.proxy;

import com.sheyin.experiment.TutorialMod;
import com.sheyin.experiment.block.ModBlocks;
import com.sheyin.experiment.item.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Sheyin on 9/8/2016.
 */

public class ClientProxy extends CommonProxy    {

    // from wehavecookies' tutorial - hit ctrl-O and shift-select the methods to override as a shortcut


    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
    }

}
