package pokemon;

import java.util.Map;

import moves.Move;
import types.Type;



public class Charizard extends Pokemon{
    public final static Map<Integer, Move> REWARD_LVL = Map.ofEntries(
            Map.entry(1, Move.GROWL),
            Map.entry(2, Move.SCRATCH),
            Map.entry(4, Move.EMBER),
            Map.entry(8, Move.SMOKESCREEN),
            Map.entry(12, Move.DRAGON_BREATH),
            Map.entry(19, Move.FIRE_FANG),
            Map.entry(24, Move.SLASH),
            Map.entry(30, Move.FLAMETHROWER),
            Map.entry(36, Move.AIR_SLASH),
            Map.entry(37, Move.DRAGON_CLAW),
            Map.entry(38, Move.SCARY_FACE),
            Map.entry(32, Move.FIRE_SPIN),
            Map.entry(48, Move.INFERNO),
            Map.entry(54, Move.FLARE_BLITZ)
        );
    
    
	public Charizard(int lvl) {
		super("Charizard", Type.FIRE, Type.FLYING, REWARD_LVL, 78, 84, 78, 109, 85, 100, lvl, 0, Ability.BLAZE);

	}


	}


