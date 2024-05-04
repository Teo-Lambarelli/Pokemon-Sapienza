package pokemon;
import java.util.Map;

import types.Type;
import moves.Move;

public class Charmander extends Pokemon{
    public final static Map<Integer, Move> REWARD_LVL = Map.ofEntries(
            Map.entry(1, Move.GROWL),
            Map.entry(2, Move.SCRATCH),
            Map.entry(4, Move.EMBER),
            Map.entry(8, Move.SMOKESCREEN),
            Map.entry(12, Move.DRAGON_BREATH),
            Map.entry(17, Move.FIRE_FANG),
            Map.entry(19, Move.DRAGON_RAGE),
            Map.entry(20, Move.SLASH),
            Map.entry(24, Move.FLAMETHROWER),
            Map.entry(28, Move.SCARY_FACE),
            Map.entry(32, Move.FIRE_SPIN),
            Map.entry(36, Move.INFERNO),
            Map.entry(40, Move.FLARE_BLITZ)
        );
    
    


	public Charmander(int lvl) {//  	 				    hp    atk   def   satk  sdef spd lvl xp
		super("Charmander", Type.FIRE, REWARD_LVL,  39.0, 52.0, 43.0, 60.0, 50.0, 65.0,lvl,0,"Charmeleon", 16, Ability.BLAZE); 
		
		
	}

}
