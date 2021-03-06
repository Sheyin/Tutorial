package com.sheyin.experiment.item;

import com.sheyin.experiment.TutorialMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

// This will hold all the code common to any item in general - would move out stuff from TutorialMod
// You can't use "Item" as the name since it will cause problems, or else use full package name etc
// so "ModItems" works better

/**
 * Created by Sheyin on 9/8/2016.
 */

public class ModItems{

    public static Item tutorialItem;

    public static void preInit() {
        // if want to include on a vanilla tab - in the parenthesis after .setCreativeTab,
        // hit tab, else specify

        // this is going to be where you specify the properties of the new item
        // enumhelper.addtoolmaterial - for adding a new material, otherwise can simply use ItemTutorialItem(ToolMaterial.IRON), etc
        tutorialItem = new ItemTutorialItem(EnumHelper.addToolMaterial("TUTORIAL", 3, 20, 8.0F, 10.2F, 30), "tutorial_item");


        // if creating own material, setting durability to -1 makes it unbreakable, but can no longer be enchanted.
        // the max uses MUST be over 0 in order to be enchantable, unless you override block breaking methods etc.
        // damageVsEntity - keep in mind all swords have a base 4 dmg, the value is what is added on to it.

        //tutorialItem = new Item().setUnlocalizedName("tutorial_item").setCreativeTab(TutorialMod.tabTutorial);
        // just specifying new Item() doesn't do much other than specify a name and a tab

        registerItems();        // this is added in here so we don't have to do it later/ourselves? just the preInit
    }

    public static void registerItems() {
        GameRegistry.register(tutorialItem, new ResourceLocation(TutorialMod.modID, "tutorial_item"));

    }

    // ambiguous names - this does all the renders
    // render stuff shouldn't be in the main file since it is client side only
    public static void registerRenders() {
        registerRender(tutorialItem);
    }

    // ambiguous name - does something to make it easier - can use diff name?
    public static void registerRender(Item item) {
        // when you get unlocalized name, it returns something like item.tutorial_item, but the last part (5) truncates it to just everything after the period
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(TutorialMod.modID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}


/*
public class ModItems {

    public static ItemBase ingotCopper;

    public static void init() {
        // calls to register items will be here
        ingotCopper = register(new ItemBase("ingotCopper").setCreativeTab(CreativeTabs.MATERIALS));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }

        return item;
    }
}
*/