package mom.beaver.dwayne.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class RegisterSounds {
    public static final Identifier VINE_BOOM_ID = new Identifier("dwayne-the-mod-johnson:vine-boom");
    public static SoundEvent VINE_BOOM_EVENT = SoundEvent.of(VINE_BOOM_ID);

    public static final Identifier FREDDY_KALAS_QUOTE_ID = new Identifier("dwayne-the-mod-johnson:freddy-kalas");
    public static SoundEvent FREDDY_KALAS_QUOTE_EVENT = SoundEvent.of(FREDDY_KALAS_QUOTE_ID);

    public static final Identifier JOVIAL_SONG_ID = new Identifier("dwayne-the-mod-johnson:jovial-song");
    public static SoundEvent JOVIAL_SONG_EVENT = SoundEvent.of(JOVIAL_SONG_ID);
    public static void register() {
        Registry.register(Registries.SOUND_EVENT, VINE_BOOM_ID, VINE_BOOM_EVENT);
        Registry.register(Registries.SOUND_EVENT, JOVIAL_SONG_ID, JOVIAL_SONG_EVENT);
        Registry.register(Registries.SOUND_EVENT, FREDDY_KALAS_QUOTE_ID, FREDDY_KALAS_QUOTE_EVENT);
    }
}
