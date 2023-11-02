package mom.beaver.dwayne.registry.subRegisters;

import mom.beaver.dwayne.registry.RegisterSounds;
import mom.beaver.dwayne.registry.RegisterStatusEffects;
import mom.beaver.dwayne.util.IEntityDataSaver;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;

import java.util.Objects;
import java.util.UUID;


public class RegisterOnServerTick {

    public static int jovial_corruptithar_counter = 0;

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register((server) -> {
            if (server != null) {
                // do NBT data stuff if people aren't affected by jovial anymore
                for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                    StatusEffectInstance effectInstance = player.getStatusEffect(RegisterStatusEffects.JOVIAL);

                    if (effectInstance == null) {
                        NbtCompound nbt = ((IEntityDataSaver) player).getPersistentData();
                        nbt.putInt("playing-jovial-duration", -1);
                    }
                }

                // increase the global corruptithar counter
                jovial_corruptithar_counter ++;
            }
        });
    }
}
