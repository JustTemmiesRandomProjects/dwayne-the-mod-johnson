package mom.beaver.dwayne.registry.subRegisters;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.registry.RegisterSounds;
import mom.beaver.dwayne.registry.RegisterStatusEffects;
import mom.beaver.dwayne.util.IEntityDataSaver;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;

import java.util.Objects;
import java.util.UUID;


public class RegisterOnClientTick {

    public static void register() {
        ClientTickEvents.START_CLIENT_TICK.register((client) -> {
            UUID uuid = client.getSession().getUuidOrNull();
            if (uuid != null && client.world != null) {
                PlayerEntity player = client.world.getPlayerByUuid(uuid);
                if ( player == null ) {
                    return;
                }

                StatusEffectInstance effectInstance = player.getStatusEffect(RegisterStatusEffects.JOVIAL);

                if (effectInstance == null) {
                    MinecraftClient.getInstance().getSoundManager().stopSounds(RegisterSounds.JOVIAL_SONG_ID, SoundCategory.MASTER);
                    DwayneTheModJohnson.TICKS_PLAYED = -1;
                }
            }
        });
    }
}
