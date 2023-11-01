package mom.beaver.dwayne.sounds;

import mom.beaver.dwayne.registry.RegisterSounds;
import mom.beaver.dwayne.registry.RegisterStatusEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.random.Random;

import java.util.Objects;
import java.util.UUID;

@Environment(value=EnvType.CLIENT)
public class JovialSoundInstance extends MovingSoundInstance {
//    private static final float field_42931 = 1.0f;
//    private static final float field_42932 = 1.0f;
    public JovialSoundInstance(SoundEvent soundEvent, SoundCategory soundCategory) {
        super(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, SoundInstance.createRandom());
        this.attenuationType = SoundInstance.AttenuationType.LINEAR;
        this.repeat = false;
        this.repeatDelay = 0;
    }

    @Override
    public boolean canPlay() {
//        return !this.sniffer.isSilent();
        return true;
    }

    @Override
    public void tick() {
//        UUID uuid = MinecraftClient.getInstance().getSession().getUuidOrNull();
//        if (uuid != null && MinecraftClient.getInstance().world != null) {
//            PlayerEntity player = Objects.requireNonNull(MinecraftClient.getInstance().world.getPlayerByUuid(uuid));
//            StatusEffectInstance effectInstance = player.getStatusEffect(RegisterStatusEffects.JOVIAL);
//
//            if (effectInstance == null || effectInstance.getDuration() <= 1) {
//                MinecraftClient.getInstance().getSoundManager().stopSounds(RegisterSounds.JOVIAL_SONG_ID, SoundCategory.MASTER);
//            }
//        if (this.sniffer.isRemoved() || this.sniffer.getTarget() != null || !this.sniffer.isDiggingOrSearching()) {
//            this.setDone();
//            return;
//        }
//        this.x = (float)this.sniffer.getX();
//        this.y = (float)this.sniffer.getY();
//        this.z = (float)this.sniffer.getZ();
        this.volume = 1.0f;
        this.pitch = 1.0f;
    }
}

