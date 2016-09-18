package com.webs.kiroscorner.kirosworld.generation;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;

public class InitialGeneration {

	public void generate() {
		Bukkit.getServer().createWorld(creator());
	}
	
	public WorldCreator creator() {
		WorldCreator creator = new WorldCreator("KirosRealm");
		creator.environment(World.Environment.NORMAL);
		creator.generateStructures(true);
		creator.generator(generator());
		return creator;
	}
	public ChunkGenerator generator(){
		ChunkGenerator generator = new ChunkCreator();
		return generator;
	}
}
