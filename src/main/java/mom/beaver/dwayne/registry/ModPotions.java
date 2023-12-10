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

    public static final Potion JOVIAL_POTION =
            Registry.register(Registries.POTION, new Identifier(DwayneTheModJohnson.MOD_ID, "jovial_potion"),
                    new Potion(new StatusEffectInstance(RegisterStatusEffects.JOVIAL, 3575, 0)));

    public static final Potion JOVIAL_POTION_2 =
            Registry.register(Registries.POTION, new Identifier(DwayneTheModJohnson.MOD_ID, "jovial_potion_1"),
                    new Potion(new StatusEffectInstance(RegisterStatusEffects.JOVIAL, 3575, 1)));

    public static final Potion JOVIAL_POTION_3 =
            Registry.register(Registries.POTION, new Identifier(DwayneTheModJohnson.MOD_ID, "jovial_potion_2"),
                    new Potion(new StatusEffectInstance(RegisterStatusEffects.JOVIAL, 3575, 2)));

    public static final Potion JOVIAL_POTION_4 =
            Registry.register(Registries.POTION, new Identifier(DwayneTheModJohnson.MOD_ID, "jovial_potion_-1"),
                    new Potion(new StatusEffectInstance(RegisterStatusEffects.JOVIAL, 3575, 254)));

    public static final Potion JOVIAL_POTION_5 =
            Registry.register(Registries.POTION, new Identifier(DwayneTheModJohnson.MOD_ID, "jovial_potion_-2"),
                    new Potion(new StatusEffectInstance(RegisterStatusEffects.JOVIAL, 3575, 255)));


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
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, RegisterItems.FREDDY_KALAS_ITEM, ModPotions.JOVIAL_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.JOVIAL_POTION, Items.GLOWSTONE_DUST, ModPotions.JOVIAL_POTION_2);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.JOVIAL_POTION_2, Items.GLOWSTONE, ModPotions.JOVIAL_POTION_3);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.JOVIAL_POTION, Items.REDSTONE, ModPotions.JOVIAL_POTION_4);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.JOVIAL_POTION_4, Items.REDSTONE_BLOCK, ModPotions.JOVIAL_POTION_5);

        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, RegisterItems.block_items.get("dwayne_the_block_johnson"), ModPotions.DWAYNE_THE_POTION_JOHNSON);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.DWAYNE_THE_POTION_JOHNSON, Items.GLOWSTONE_DUST, ModPotions.DWAYNE_THE_POTION_JOHNSON_STRONG);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.DWAYNE_THE_POTION_JOHNSON, Items.REDSTONE, ModPotions.DWAYNE_THE_POTION_JOHNSON_LONG);
    }
}
