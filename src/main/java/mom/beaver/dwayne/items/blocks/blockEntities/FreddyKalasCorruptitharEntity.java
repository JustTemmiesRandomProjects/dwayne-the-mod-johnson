package mom.beaver.dwayne.items.blocks.blockEntities;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.registry.RegisterItems;
import mom.beaver.dwayne.registry.RegisterStatusEffects;
import mom.beaver.dwayne.registry.subRegisters.RegisterOnServerTick;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class FreddyKalasCorruptitharEntity extends BlockEntity {
    private static final int SCAN_RADIUS = 64;  // The radius to scan for players.
    private static final int SCAN_INTERVAL = 200;  // Scan for players every x ticks

    public FreddyKalasCorruptitharEntity(BlockPos pos, BlockState state) {
        super(RegisterItems.FREDDY_KALAS_CORRUPTITHAR_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, FreddyKalasCorruptitharEntity be) {
        if (RegisterOnServerTick.jovial_corruptithar_counter >= SCAN_INTERVAL) {
            if (world != null && !world.isClient) {
                ServerWorld serverWorld = (ServerWorld) world;
                List<PlayerEntity> players = serverWorld.getEntitiesByClass(PlayerEntity.class, getScanBox(pos), player -> true);

                for (PlayerEntity player : players) {
                    player.addStatusEffect(new StatusEffectInstance(RegisterStatusEffects.JOVIAL, SCAN_INTERVAL * 2 + 5, 0));
                }

                RegisterOnServerTick.jovial_corruptithar_counter = 0;
            }
        }
    }

    public static Box getScanBox(BlockPos pos) {
        return new Box(
                pos.getX() - SCAN_RADIUS, pos.getY() - SCAN_RADIUS, pos.getZ() - SCAN_RADIUS,
                pos.getX() + SCAN_RADIUS, pos.getY() + SCAN_RADIUS, pos.getZ() + SCAN_RADIUS
        );
    }
}
