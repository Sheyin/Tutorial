/**
 * Created by Sheyin on 9/8/2016.
 */

// may not be necessary - I think this is a template for what becomes TutorialMod

package com.sheyin.experiment;
//import com.sheyin.experiment.item.ModItems;
import com.sheyin.experiment.block.ModBlocks;
import com.sheyin.experiment.item.ModItems;
import com.sheyin.experiment.proxy.CommonProxy;
import com.sheyin.experiment.tab.CreativeTabTutorial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TutorialMod.modID, name = TutorialMod.name, version = TutorialMod.version, acceptedMinecraftVersions = "[1.10.2]")
public class TutorialMod {
    //modID should be specific, all lower case, no spaces
    public static final String modID = "tutorial-shey";
    public static final String name = "Shey's Tutorial Mod";
    public static final String version = "1.0.0";

    // telling forge that these are proxies
    @SidedProxy(clientSide = "com.sheyin.experiment.proxy.ClientProxy", serverSide = "com.sheyin.experiment.proxy.CommonProxy")
    public static CommonProxy proxy;

    //@Mod.Instance(modID)
    @Mod.Instance
    // gui's and entities generally need an instance of the mod
    public static TutorialMod instance;
    //public static Object proxy;

    public static CreativeTabTutorial tabTutorial;

    // These will be called on both server and client, so proxies are needed to prevent crashes
    // ignore intellij warnings about not being used - forge calls them in a different way
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // getNextID() autogenerates an ID number to prevent conflicts
        tabTutorial = new CreativeTabTutorial(CreativeTabs.getNextID(), "tab_tutorial");
        ModItems.preInit();
        ModBlocks.preInit();
        proxy.preInit(event);
        //ModItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }


}
