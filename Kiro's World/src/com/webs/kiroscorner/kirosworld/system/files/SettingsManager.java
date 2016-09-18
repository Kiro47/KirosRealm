package com.webs.kiroscorner.kirosworld.system.files;

import org.bukkit.configuration.file.FileConfiguration;

import com.webs.kiroscorner.kirosworld.KirosWorldMain;

public class SettingsManager {

	private static final SettingsManager
		configuration = new SettingsManager("config"),
		poisonWater = new SettingsManager("poisonWater")
		;
		
	public static SettingsManager getConfig() {
		return configuration;
	}
	
	public static SettingsManager getPoisonWater() {
		return poisonWater;
	}
	
	private File file;
	private FileConfiguration config;
	
	private SettingsManagaer(String fileName) {
		if (KirosWorldMain.getPlugin().)
	}
}
