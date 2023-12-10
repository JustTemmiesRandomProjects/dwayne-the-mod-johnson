package mom.beaver.dwayne.items.blocks;

import mom.beaver.dwayne.registry.RegisterSounds;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DwayneTheBlockJohnson extends Block {
    public static final BooleanProperty POWERED = RedstoneTorchBlock.LIT;

    public DwayneTheBlockJohnson (Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(POWERED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            float pitch = (float)(Math.random() / 2 + 0.75);
            world.playSound(null, pos, RegisterSounds.VINE_BOOM_EVENT, SoundCategory.BLOCKS, 0.5f, pitch);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(POWERED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }

        boolean bl = state.get(POWERED);
        int power = world.getReceivedRedstonePower(pos);
        if (bl != power >= 1) {
            if (!bl) {
                float pitch = ((float) power / 30) + 0.75f;
                world.playSound(null, pos, RegisterSounds.VINE_BOOM_EVENT, SoundCategory.BLOCKS, 0.5f, pitch);
            }
            world.setBlockState(pos, state.cycle(POWERED), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
}