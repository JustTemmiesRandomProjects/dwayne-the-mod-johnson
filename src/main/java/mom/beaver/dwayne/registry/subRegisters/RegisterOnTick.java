package mom.beaver.dwayne.registry.subRegisters;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.registry.RegisterSounds;
import mom.beaver.dwayne.registry.RegisterStatusEffects;
import mom.beaver.dwayne.util.IEntityDataSaver;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.tick.WorldTickScheduler;
import net.minecraft.world.timer.Timer;

import java.util.Objects;
import java.util.UUID;

public class RegisterOnTick {
    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            UUID uuid = client.getSession().getUuidOrNull();
            if (uuid != null && client.world != null) {
                PlayerEntity player = Objects.requireNonNull(client.world.getPlayerByUuid(uuid));
                StatusEffectInstance effectInstance = player.getStatusEffect(RegisterStatusEffects.JOVIAL);

                if (effectInstance == null) {
                    NbtCompound nbt = ((IEntityDataSaver) player).getPersistentData();
                    nbt.putInt("playing-jovial-duration", -1);
                }

                if (player.age == 50) {
                    if (effectInstance != null) {
                        DwayneTheModJohnson.LOGGER.info("hey! why u not jovial >:(");
                        player.playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 1.3F, 1);
                        NbtCompound nbt = ((IEntityDataSaver) player).getPersistentData();
                        nbt.putInt("playing-jovial-duration", 1);
                    }
                }
            }
        });
    }
}
