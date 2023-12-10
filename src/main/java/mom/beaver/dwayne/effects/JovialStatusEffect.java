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
            if (amplifier != DwayneTheModJohnson.SAVED_AMPLIFIER) {
                if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
                    MinecraftClient.getInstance().getSoundManager().stopSounds(RegisterSounds.JOVIAL_SONG_ID, SoundCategory.MASTER);
                    playJovial((PlayerEntity) entity, amplifier);
                }
                DwayneTheModJohnson.TICKS_PLAYED = 2;
                DwayneTheModJohnson.SAVED_AMPLIFIER = amplifier;

            } else if (DwayneTheModJohnson.TICKS_PLAYED > 3580 || DwayneTheModJohnson.TICKS_PLAYED <= 0) {
                if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
                    MinecraftClient.getInstance().getSoundManager().stopSounds(RegisterSounds.JOVIAL_SONG_ID, SoundCategory.MASTER);
                    playJovial((PlayerEntity) entity, amplifier);
                }
                DwayneTheModJohnson.TICKS_PLAYED = 2;
                DwayneTheModJohnson.SAVED_AMPLIFIER = amplifier;
            } else {
                DwayneTheModJohnson.TICKS_PLAYED ++;
                System.out.println("increasing tick count!");
            }
        }
    }

    private static void playJovial(PlayerEntity entity, int amplifier) {
        if ( amplifier == -128) {
            ((PlayerEntity) entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 0.38F, 0.75f);
        } else if ( amplifier == -127 ) {
            ((PlayerEntity) entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 0.34F, 0.88f);
        } else {
            ((PlayerEntity) entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 0.3F, (float) (amplifier  * 0.2f) + 1);
        }
    }
}
