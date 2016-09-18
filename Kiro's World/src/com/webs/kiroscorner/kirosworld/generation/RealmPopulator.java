package com.webs.kiroscorner.kirosworld.generation;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;

public class RealmPopulator extends BlockPopulator {

	private static final int NETHERRACK = 60;
	private static final int BEDROCK = 40;
	private static final int LIQUID_POOL = 35;
	private static final int LAVA_POOL = 15;
	private static final int POISON_POOL = 0;
	private static final int WATER_POOL = 60;
	private static final int SMALL_CHANCE = 0;
	private static final int MEDIUM_CHANCE = 30;
	private static final int LARGE_CHANCE = 70;
	private static final int COLOSSAL_CHANCE = 95;
	private static final int MINUMUM_SIZE = 2;
	private static final int SIZE_SMALL = 4;
	private static final int SIZE_MEDIUM = 8;
	private static final int SIZE_LARGE = 12;
	private static final int SIZE_COLOSSAL = 25;
	
	public void populate(World world, Random random, Chunk source) {
		if (random.nextInt(100) <= LIQUID_POOL) {
			
		}
	}
	
	public void liquidGen(World world, Random random, Chunk source) {

		int centerX = (source.getX() << 4) + random.nextInt(30); 
		int centerZ = (source.getX() << 4) + random.nextInt(30); 
		int centerY = (world.getHighestBlockYAt(centerX, centerZ));
		BlockVector center = new BlockVector(centerX, centerY, centerZ);
		Biome b = new Location(world, centerX, centerY, centerZ).getBlock().getBiome();
		if (b.equals(Biome.OCEAN) || b.equals(Biome.DEEP_OCEAN)) {
			 centerX = (source.getX() << 4) + random.nextInt(30); 
			 centerZ = (source.getX() << 4) + random.nextInt(30); 
			 centerY = (world.getHighestBlockYAt(centerX, centerZ));
		}
		int radius = 0;
		int ranRadius = random.nextInt(100);
		
		// Select Size of area.
		if (ranRadius >= SMALL_CHANCE) {
			radius = random.nextInt(SIZE_SMALL - MINUMUM_SIZE + 1) +  MINUMUM_SIZE;
		}
		else if (ranRadius >= MEDIUM_CHANCE) {
			radius = random.nextInt(SIZE_MEDIUM - MINUMUM_SIZE +1) +  MINUMUM_SIZE;
		}
		else if (ranRadius >= LARGE_CHANCE) {
			radius = random.nextInt(SIZE_LARGE - MINUMUM_SIZE +1) +  MINUMUM_SIZE;
		}
		else if (ranRadius >= COLOSSAL_CHANCE) {
			radius = random.nextInt(SIZE_COLOSSAL - MINUMUM_SIZE +1) +  MINUMUM_SIZE;
		}
		else {
			radius = 0;
		}
		
		// Select type of Fluid
		Material materialType = null;
		int ranType = random.nextInt(100);
		boolean isPoisionus =  false;
		if (ranType >= WATER_POOL) {
			materialType = Material.WATER;
			
		}
		else if (ranType >= LAVA_POOL) {
			materialType = Material.LAVA;
		}
		else if (ranType >= POISON_POOL){
			materialType = Material.WATER;
			isPoisionus =true;
		}
		else {
			return;
		}
		
		// Place down and replace blocks.
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++){
				for (int z = -radius; z <= radius; z++){
					Vector pos = center.clone().add(new Vector(x, y, z));
					
					if (center.distance(pos) <= radius + 0.5) {
						world.getBlockAt(pos.toLocation(world)).setType(materialType);
						if (isPoisionus) {
							// insert data into map
							
						}
					}
				}
			}
		}
	
	}
}
