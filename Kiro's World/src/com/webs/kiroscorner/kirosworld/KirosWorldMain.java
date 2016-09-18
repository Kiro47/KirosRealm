package com.webs.kiroscorner.kirosworld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class KirosWorldMain extends JavaPlugin{

	public void onEnble() {
		
	}
	public void onDisable(){
		
	}
	public static Plugin getPlugin() {
		return Bukkit.getServer().getPluginManager().getPlugin("KirosRelam");
	}
}
