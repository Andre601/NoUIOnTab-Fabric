package ch.andre601.nouiontab;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoUIOnTab implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("No UI on Tab");

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Mod...");
	}
}