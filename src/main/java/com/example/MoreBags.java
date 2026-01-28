package com.example;

import com.example.init.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBags implements ModInitializer {
	public static final String MOD_ID = "morebags";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		LOGGER.info(MOD_ID + " initialized successfully");
	}
}