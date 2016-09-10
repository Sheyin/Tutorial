package com.sheyin.experiment.block;

import com.sheyin.experiment.TutorialMod;
import com.sheyin.experiment.item.ItemTutorialItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

// This will hold all the code common to any item in general - would move out stuff from TutorialMod
// You can't use "Item" as the name since it will cause problems, or else use full package name etc
// so "ModItems" works better

/**
 * Created by Sheyin on 9/8/2016.
 */

public class ModBlocks {

    public static Block tutorialBlock;

    public static void preInit() {

        // Block needs things in its constructor
        // the material specified here determines behavior when broken, sounds made, what tool to use, etc
        tutorialBlock = new BlockTutorialBlock(Material.ROCK, "tutorial_block");
        registerBlocks();        // this is added in here so we don't have to do it later/ourselves? just the preInit
    }

    // this becomes a helper function for registerBlock() by registering it both as an item and a block, but with one line
    public static void registerBlocks() {
        registerBlock(tutorialBlock, "tutorial_block");
    }

    public static void registerBlock(Block block, String name) {
        GameRegistry.register(block, new ResourceLocation(TutorialMod.modID, name));
        // this is necessary because it will also be held as an item in inventory
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(TutorialMod.modID, name));
    }


    // ambiguous names - this does all the renders
    // render stuff shouldn't be in the main file since it is client side only
    public static void registerRenders() {
        registerRender(tutorialBlock);
    }

    // ambiguous name - does something to make it easier - can use diff name?
    public static void registerRender(Block block) {
        // still needs an item (from the block) - this gets you the Item object from block
        Item item = Item.getItemFromBlock(block);

        // this connects the model with the item created/registered
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