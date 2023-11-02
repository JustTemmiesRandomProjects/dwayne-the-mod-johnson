package mom.beaver.dwayne.effects;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.registry.RegisterSounds;
import mom.beaver.dwayne.util.IEntityDataSaver;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
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
            System.out.println(amplifier);
            NbtCompound nbt = ((IEntityDataSaver) entity).getPersistentData();

            int play_duration = nbt.getInt("playing-jovial-duration");
            int saved_amplifier = nbt.getInt("playing-jovial-amplifier");

            if (amplifier != saved_amplifier) {
                if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
                    MinecraftClient.getInstance().getSoundManager().stopSounds(RegisterSounds.JOVIAL_SONG_ID, SoundCategory.MASTER);
                    ((PlayerEntity) entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 0.1F, (float) amplifier / 5 + 1);
                }

                nbt.putInt("playing-jovial-duration", 2);
                nbt.putInt("playing-jovial-amplifier", amplifier);
            } else if (play_duration > 3580 || play_duration <= 0) {
                if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
                    ((PlayerEntity) entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 0.1F, (float) amplifier / 5 + 1);
                }

                nbt.putInt("playing-jovial-duration", 2);
                nbt.putInt("playing-jovial-amplifier", amplifier);
            } else {
                play_duration ++;
                nbt.putInt("playing-jovial-duration", play_duration);
            }
        }
    }
}
