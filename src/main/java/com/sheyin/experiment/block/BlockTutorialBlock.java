package com.sheyin.experiment.block;

import com.sheyin.experiment.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by Sheyin on 9/10/2016.
 */
public class BlockTutorialBlock extends Block {

    public BlockTutorialBlock(Material materialIn, String name) {
        // initializing this as a material
        super(materialIn);

        // adding the name of the item
        this.setUnlocalizedName(name);

        // specify which tab it should show up on
        this.setCreativeTab(TutorialMod.tabTutorial);

        // hardness = how easy it is to mine the block, harder = longer to break the block
        // things like bedrock also include setBlockUnbreakable() - so it cannot be mined

        this.setHardness(50F);   // can look at blocks class for comparable values - net-minecraft-init-Blocks

        // resistance = how strong it is against explosions
        this.setResistance(1000F);

        // setting what sound it makes
        this.setSoundType(SoundType.SLIME);

        // This can make it emit light when placed (ex. glowstone)
        this.setLightLevel(1F);
    }
}
