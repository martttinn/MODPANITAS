package net.martin.panitasMod.items.custom;

import net.martin.panitasMod.items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BluntItem extends Item {

    private boolean isLit;

    public BluntItem(Properties properties, boolean isLit)
    {
        super(properties);
        this.isLit = isLit;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand)
    {
        ItemStack itemstack = player.getItemInHand(hand);

        if (player.getOffhandItem().getItem() == Items.FLINT_AND_STEEL && !isLit) {
            // Cambiar la textura y hacer el ítem consumible
            player.addItem(new ItemStack(ModItems.LIT_BLUNT.get()));
            itemstack.shrink(1);
            return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
        }

        if (isLit)
        {
            player.startUsingItem(hand);

            return InteractionResultHolder.consume(itemstack);
        }

        return InteractionResultHolder.fail(itemstack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        pTooltipComponents.add(Component.translatable("tooltip.panitas.blunt"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
