package mom.beaver.dwayne;

import mom.beaver.dwayne.registry.*;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DwayneTheModJohnson implements ModInitializer {
	public static String MOD_ID = "dwayne-the-mod-johnson";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static int TICKS_PLAYED = 0;
	public static int SAVED_AMPLIFIER = 100;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		RegisterSounds.register();
		RegisterItems.register();
		RegisterStatusEffects.register();
		ModPotions.registerPotions();
		ModPotions.registerPotionRecipes();
	}
}

