package mom.beaver.dwayne.registry.subRegisters;

import mom.beaver.dwayne.registry.RegisterSounds;
import mom.beaver.dwayne.registry.RegisterStatusEffects;
import mom.beaver.dwayne.util.IEntityDataSaver;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;

import java.util.Objects;
import java.util.UUID;


public class RegisterOnClientTick {

    public static void register() {
        ClientTickEvents.START_CLIENT_TICK.register((client) -> {
            UUID uuid = client.getSession().getUuidOrNull();
            if (uuid != null && client.world != null) {
                PlayerEntity player = Objects.requireNonNull(client.world.getPlayerByUuid(uuid));
                StatusEffectInstance effectInstance = player.getStatusEffect(RegisterStatusEffects.JOVIAL);

                NbtCompound nbt = ((IEntityDataSaver) player).getPersistentData();
                int play_duration = nbt.getInt("playing-jovial-duration");

                if (effectInstance == null) {
//                    NbtCompound nbt = ((IEntityDataSaver) player).getPersistentData();
                    nbt.putInt("playing-jovial-duration", -1);
                    MinecraftClient.getInstance().getSoundManager().stopSounds(RegisterSounds.JOVIAL_SONG_ID, SoundCategory.MASTER);
                }

//                if (player.age == 50) {
//                    if (effectInstance != null) {
//                        DwayneTheModJohnson.LOGGER.info("hey! why u not jovial >:(");
//                        player.playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 1.3F, 1);
////                        NbtCompound nbt = ((IEntityDataSaver) player).getPersistentData();
//                        nbt.putInt("playing-jovial-duration", 1);
//                    }
//                }
            }
        });
    }
}
