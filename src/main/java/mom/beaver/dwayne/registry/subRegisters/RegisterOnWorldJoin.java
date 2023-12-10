package mom.beaver.dwayne.registry.subRegisters;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.registry.RegisterSounds;
import mom.beaver.dwayne.registry.RegisterStatusEffects;
import mom.beaver.dwayne.util.IEntityDataSaver;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.UUID;

public class RegisterOnWorldJoin {
    public static void register() {
        ClientPlayConnectionEvents.JOIN.register((handler, packetSender, client) -> {
            DwayneTheModJohnson.LOGGER.info("Connecting from server...");
        });
    }
}
