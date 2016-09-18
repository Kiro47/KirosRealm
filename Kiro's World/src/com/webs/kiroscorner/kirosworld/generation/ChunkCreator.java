package com.webs.kiroscorner.kirosworld.generation;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.NoiseGenerator;
import org.bukkit.util.noise.SimplexNoiseGenerator;

public class ChunkCreator extends ChunkGenerator{

	private NoiseGenerator noise;
	
	private NoiseGenerator getGenerator(World world) {
		if (noise == null) {
			noise = new SimplexNoiseGenerator(world);
		}
		return noise;
	}
	
	private int getHeight(World world, double x, double y, int variance) {
		NoiseGenerator gen = getGenerator(world);
		double result = gen.noise(x, y);
		result *= variance;
		return NoiseGenerator.floor(result);
	}
	@SuppressWarnings("deprecation")
	public byte[] generator(World world, Random ran, int cx, int cz) {
		byte[] result = new byte[32768];
		
		for (int x = 0; x < 16; x++){
			for (int z = 0; z < 16; z++) {
				int height = getHeight(world, cx + x *0.0625, cz + z * 0.0625, 2) + 3 ;
				for (int y = 0; y < height; y++){
					result[(x * 16 + z) * 128 + y] = (byte) Material.BEDROCK.getId();
				}
			}

		}
		return result;
	}
	
	//https://github.com/Dinnerbone/BukkitFullOfMoon/blob/master/src/main/java/com/dinnerbone/bukkit/moon/MoonChunkGenerator.java
	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return Arrays.asList((BlockPopulator) new RealmPopulator(), new FlagPopulator());
	}
	
}
