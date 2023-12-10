package mom.beaver.dwayne.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class RegisterSounds {
    public static final Identifier VINE_BOOM_ID = new Identifier("dwayne-the-mod-johnson:vine-boom");
    public static SoundEvent VINE_BOOM_EVENT = SoundEvent.of(VINE_BOOM_ID);

    public static void register() {
        Registry.register(Registries.SOUND_EVENT, VINE_BOOM_ID, VINE_BOOM_EVENT);
    }
}
