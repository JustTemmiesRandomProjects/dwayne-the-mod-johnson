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

public class FreddyKalasItem extends Item {

    public FreddyKalasItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        world.playSound(null, BlockPos.ofFloored(playerEntity.getPos()), RegisterSounds.FREDDY_KALAS_QUOTE_EVENT, SoundCategory.PLAYERS, 1.0F, 1);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
