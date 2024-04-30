package types;

public class Typechart {
	/*
	 * 0: Fire
	 * 1: Water
	 * 2: Grass
	 * 3: Electric
	 * 4: Ice
	 * 5: Poison
	 * 6: Ground
	 */
	
	static final double[][] typechart= {
// Defence:  Fi   Wa   Gra  El   Ic   Po   Gro      Attack:
			{0.5, 0.5, 2,   1,   2,   1,   0.5}, // Fire
			{2,   0.5, 0.5, 1,   0.5, 1,   2},   // Water
			{0.5, 2,   0.5, 1,   0.5, 0.5, 2},   // Grass
			{1,   2,   0.5, 0.5, 2,   1,   0},   // Electric
			{0.5, 0.5, 2,   1,   0.5, 1,   2},   // Ice
			{1,   2,   2,   1,   1,   0.5, 0.5}, // Poison
			{2,   0.5, 0.5, 2,   0.5, 2,   1}    // Ground
	};
	
}