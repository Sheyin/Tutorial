package com.sheyin.experiment.item;

import com.sheyin.experiment.TutorialMod;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.List;


// originally this was extending an Item, changed in ep. 3 @ 38:15
// can extend other items instead - note that a "shovel" is actually a "spade"
public class ItemTutorialItem extends ItemSword {
    // nothing is really required in here, but can change code in TutorialMod to call this instead and specify the item in
    // this acts as a helper function to tidy up code / abstract ion

    // **changed when turning this into a sword along with super(material) added
    //public ItemTutorialItem(String name) {

    public ItemTutorialItem(ToolMaterial material, String name) {
        super(material);    // this defines how much damage, durability the tool has

        setUnlocalizedName(name);
        setCreativeTab(TutorialMod.tabTutorial);
        setMaxStackSize(4); // can set how large the stack is
    }

    // can hit ctrl + O and see list of methods you can override here - ex. onItemRightClick
    // can also ctrl + click the "Item" class to see all the methods and descriptions
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        // this is a check to see if it is a client calling this or server
        // if you don't, both client + server call it and repeat the output
        // this should only affect the server right now
        if (!worldIn.isRemote) {
            // can rename playerIn to just player out of convenience here - these are local variables
            playerIn.addChatComponentMessage(new TextComponentString("Right clicked item!"));   // could also do system.out to console or FML blogging, which no one uses?
        }
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        // added an extra condition to allow stacking diamond blocks
        // whenever we right click a grass block with the tutorial item, it will change it into a diamond block
        if ((worldIn.getBlockState(pos).getBlock() == Blocks.GRASS) || (worldIn.getBlockState(pos).getBlock() == Blocks.DIAMOND_BLOCK)) {
            // if you leave it as just (pos) below - replaces block with diamond
            worldIn.setBlockState(pos.up(), Blocks.DIAMOND_BLOCK.getDefaultState());
            return EnumActionResult.SUCCESS;        // item successfully used
            // if carrying something in both main and offhand that have right click abilities, then using
            // EnumActionResult.PASS does the main hand effect followed by the offhand effect.
            // SUCCESS = main hand only, not offhand at all, FAIL = probably doesn't do anything
        }

        // if it is used on plain dirt, spawn a chicken?! run on server only
        if(!worldIn.isRemote) {
            if ((worldIn.getBlockState(pos).getBlock() == Blocks.DIRT) || (worldIn.getBlockState(pos).getBlock() == Blocks.OBSIDIAN)) {
                EntityChicken chicken = new EntityChicken(worldIn);
                chicken.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                // on player's head instead
                //chicken.setPosition(playerIn.posX, playerIn.posY + 1, playerIn.posZ);
                worldIn.spawnEntityInWorld(chicken);
                playerIn.addChatComponentMessage(new TextComponentString("No grass? Here, have a chicken."));
                return EnumActionResult.SUCCESS;        // item successfully used
            }
        }

        // itemStack = the stack the player is holding of this item
        // player = you
        // position in the world, main/offhand, direction player is facing, coordinates of the place it was used on
        // can specify ex. this action only when clicking on the top of the block (would need to check the coordinates)
        return EnumActionResult.PASS;               // if the first condition is false (not a grass block) - use offhand instead
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        // normally this returns a damaged item, but if we want it unbreakable + enchantable - just return true instead of using super
        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        // normally this returns a damaged item, but if we want it unbreakable + enchantable - just return true instead of using super
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        // this adds information to the tooltip - ex. description of the item, etc. goes here
        // boolean advanced - if press F3 + H? can show durability of the tools etc
        // list - the lines on the tooltip (lines will wrap on the tooltip automatically though)
        // first item on list is the name of the item- don't clear this unless you want to erase the name on tooltip
        tooltip.add("Mystery item of awesome power");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        // rarity is just the special colored text - ex. yellow, blue, purple etc.
        // don't use this method if you don't want to change the color of the text
        return EnumRarity.EPIC;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        // determines whether the item has an enchant (effect) etc.
        // if want the item rarity to be based on something in the item (ex. a tool based on its nbt data)

        // example just used return true below and erased the rest

        if (stack.getItemDamage() > 50) {
            // if item still has durability, it has this effect, if not it has some other effect - ex. stonebound tools
            return true;
        }

        else {
            return false;
        }
    }
}