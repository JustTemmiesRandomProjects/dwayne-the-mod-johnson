package mom.beaver.dwayne.items.blocks;

import mom.beaver.dwayne.registry.RegisterSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DwayneTheBlockJohnson extends Block {
    public DwayneTheBlockJohnson (Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            float pitch = (float)(Math.random() / 2 + 0.75);
            world.playSound(null, pos, RegisterSounds.VINE_BOOM_EVENT, SoundCategory.BLOCKS, 1.2f, pitch);
        }

        return ActionResult.SUCCESS;
    }
}
