package net.jimbot6000.blockentityextendedrendering;

import net.fabricmc.api.ClientModInitializer;
import net.jimbot6000.blockentityextendedrendering.gui.BEERConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockEntityExtendedRendering implements ClientModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final BEERConfig CONFIG = new BEERConfig();

	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		CONFIG.load();
	}
}
