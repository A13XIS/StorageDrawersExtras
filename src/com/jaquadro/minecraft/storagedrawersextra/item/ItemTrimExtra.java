package com.jaquadro.minecraft.storagedrawersextra.item;

import com.jaquadro.minecraft.chameleon.resources.IItemMeshMapper;
import com.jaquadro.minecraft.chameleon.resources.IItemVariantProvider;
import com.jaquadro.minecraft.storagedrawersextra.block.BlockTrimExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.EnumVariant;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class ItemTrimExtra extends ItemBlock
{
    public ItemTrimExtra (final Block block) {
        super(block);
        setMaxDamage(0);
    }

    @Override
    public int getMetadata (int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName (ItemStack stack) {
        return "tile.extra_trim";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack itemStack, EntityPlayer player, List<String> list, boolean par4) {
        Block block = Block.getBlockFromItem(itemStack.getItem());
        if (block instanceof BlockTrimExtra) {
            BlockTrimExtra trim = (BlockTrimExtra)block;
            EnumVariant varient = EnumVariant.byGroupMeta(trim.getGroup(), itemStack.getMetadata());
            list.add(I18n.format("storageDrawers.material", I18n.format("storageDrawers.material." + varient.getName())));
        }
    }
}
