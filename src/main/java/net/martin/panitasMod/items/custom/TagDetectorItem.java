package net.martin.panitasMod.items.custom;
import net.martin.panitasMod.panitasMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;
import java.util.stream.Collectors;

public class TagDetectorItem extends Item
{

    public TagDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState blockState = level.getBlockState(pos);
        Player player = context.getPlayer();

        String tags = blockState.getTags()
                .map(tag -> tag.toString()) // Convertir cada tag a una cadena
                .collect(Collectors.joining(", "));

        if (!level.isClientSide && player != null)
        {
            MutableComponent blockTag = Component.literal(tags);
            player.sendSystemMessage(blockTag);
        }

        return InteractionResult.SUCCESS;
    }
}
