package me.daxanius.npe;

import me.daxanius.npe.config.NoPryingEyesConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoPryingEyes implements ModInitializer {
	public static final String MOD_ID = "npe";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void LogVerbose(String s) {
		if (!NoPryingEyesConfig.getInstance().verbose) {
			return;
		}

		LOGGER.info("ANPE: " + s);
	}

	@Override
	public void onInitialize() {
		NoPryingEyesConfig.load();
		LOGGER.info("ANPE: hi i probably introduced like 20 crashes and 89 bugs while making the weird changes to get this working on the latest version");
		LOGGER.info("ANPE: this is my first mod you cant judge me pls");
		LOGGER.info("ANPE: maybe the barrier to entry shouldn't be this low...");
		LOGGER.info("ANPE: thanks for trusting me with the ability to run code. -LiterallyButter");
	}
}