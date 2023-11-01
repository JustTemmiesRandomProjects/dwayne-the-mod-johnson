package mom.beaver.dwayne.items;

import mom.beaver.dwayne.registry.RegisterSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class DwayneTheItemJohnson extends Item {

    public DwayneTheItemJohnson(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.temmies-mod.dwayne_the_item_johnson.tooltip"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        float pitch = (float)(Math.random() / 2 + 0.75);

        world.playSound(null, BlockPos.ofFloored(playerEntity.getPos()), RegisterSounds.VINE_BOOM_EVENT, SoundCategory.PLAYERS, 1.0F, pitch);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
