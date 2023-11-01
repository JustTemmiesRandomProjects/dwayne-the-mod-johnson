package mom.beaver.dwayne.effects;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.registry.RegisterSounds;
import mom.beaver.dwayne.registry.RegisterStatusEffects;
import mom.beaver.dwayne.sounds.JovialSoundInstance;
import mom.beaver.dwayne.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;

import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import static mom.beaver.dwayne.DwayneTheModJohnson.JOVIAL_SOUND_INSTANCE;

public class JovialStatusEffect extends StatusEffect {
    public JovialStatusEffect() {
        super(
                StatusEffectCategory.BENEFICIAL,
                0xf8bb44
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {

//            MinecraftClient.getInstance().getSoundManager().isPlaying()
//            MinecraftClient.getInstance().getSoundManager().;
            System.out.println(JOVIAL_SOUND_INSTANCE.isDone());

            NbtCompound nbt = ((IEntityDataSaver) entity).getPersistentData();
            boolean playing = nbt.getBoolean("playing-jovial");
            if (!playing) {
                JOVIAL_SOUND_INSTANCE.canPlay();
                ((PlayerEntity) entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 1.0F, 1);
                nbt.putBoolean("playing-jovial", true);
            }
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof PlayerEntity) {
            NbtCompound nbt = ((IEntityDataSaver) entity).getPersistentData();
            boolean playing = nbt.getBoolean("playing-jovial");
            nbt.putBoolean("playing-jovial", false);

            MinecraftClient.getInstance().getSoundManager().stopSounds(RegisterSounds.JOVIAL_SONG_ID, SoundCategory.MASTER);
        }
    }

//    @Override
//    public void applyInstantEffect(LivingEntity entity, int amplifier) {
//        if (entity instanceof PlayerEntity) {
//            ((PlayerEntity) entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 1.0F, 1);
//        }
//    }
}
