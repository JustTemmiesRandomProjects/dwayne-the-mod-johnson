package mom.beaver.dwayne.registry;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.effects.JovialStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterStatusEffects {
    public static final StatusEffect JOVIAL = new JovialStatusEffect();

    public static void register() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(DwayneTheModJohnson.MOD_ID, "jovial"), JOVIAL);
    }
}
