package pokemon;

import java.util.ArrayList;
import java.util.Map;

import moves.Move;
import types.Type;

public class Charmeleon extends Pokemon{
	public final static String FRONTSPRITE="src/sprites/charmeleon.png";
	public final static String BACKSPRITE="src/sprites/backcharmeleon.png";
	public final static Map<Integer, Move> PECULIARMOVES= null;
    public final static Map<Integer, Move> REWARD_LVL = Map.ofEntries(
            Map.entry(1, Move.GROWL),
            Map.entry(2, Move.SCRATCH),
            Map.entry(4, Move.EMBER),
            Map.entry(8, Move.SMOKESCREEN),
            Map.entry(12, Move.DRAGON_BREATH),
            Map.entry(19, Move.FIRE_FANG),
            Map.entry(24, Move.SLASH),
            Map.entry(30, Move.FLAMETHROWER),
            Map.entry(37, Move.SCARY_FACE),
            Map.entry(32, Move.FIRE_SPIN),
            Map.entry(48, Move.INFERNO),
            Map.entry(54, Move.FLARE_BLITZ)
        );

	public Charmeleon(int lvl) {
		super("Charmeleon", Type.FIRE, REWARD_LVL, 58, 64, 58, 80, 65, 80, lvl, 0, "Charizard",36, Ability.BLAZE,PECULIARMOVES, FRONTSPRITE,BACKSPRITE);
	}

	
	}

