package mom.beaver.dwayne.registry;

import mom.beaver.dwayne.DwayneTheModJohnson;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion DWAYNE_THE_POTION_JOHNSON =
            Registry.register(Registries.POTION, new Identifier(DwayneTheModJohnson.MOD_ID, "dwayne_the_potion_johnson"),
                    new Potion(new StatusEffectInstance(StatusEffects.HASTE, 3600, 0)));

    public static final Potion DWAYNE_THE_POTION_JOHNSON_LONG =
            Registry.register(Registries.POTION, new Identifier(DwayneTheModJohnson.MOD_ID, "dwayne_the_potion_johnson_long"),
                    new Potion(new StatusEffectInstance(StatusEffects.HASTE, 9600, 0)));

    public static final Potion DWAYNE_THE_POTION_JOHNSON_STRONG =
            Registry.register(Registries.POTION, new Identifier(DwayneTheModJohnson.MOD_ID, "dwayne_the_potion_johnson_strong"),
                    new Potion(new StatusEffectInstance(StatusEffects.HASTE, 3600, 1)));


    public static void registerPotions() {

    }

    public static void registerPotionRecipes() {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, RegisterItems.block_items.get("dwayne_the_block_johnson"), ModPotions.DWAYNE_THE_POTION_JOHNSON);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.DWAYNE_THE_POTION_JOHNSON, Items.GLOWSTONE_DUST, ModPotions.DWAYNE_THE_POTION_JOHNSON_STRONG);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.DWAYNE_THE_POTION_JOHNSON, Items.REDSTONE, ModPotions.DWAYNE_THE_POTION_JOHNSON_LONG);
    }
}
