package pokemon;
import java.util.Map;
import java.util.ArrayList;

import types.Type;
import moves.Move;

public class Bulbasaur extends Pokemon{
	public final static Map<Integer, Move> PECULIARMOVES= null;
    public final static Map<Integer, Move> REWARD_LVL = Map.ofEntries(
            Map.entry(2, Move.TACKLE),
            Map.entry(1, Move.GROWL),
            Map.entry(3, Move.VINE_WHIP),
            Map.entry(6, Move.GROWTH),
            Map.entry(9, Move.LEECH_SEED),
            Map.entry(12, Move.RAZOR_LEAF),
            Map.entry(15, Move.POISON_POWDER),
            Map.entry(16, Move.SLEEP_POWDER),
            Map.entry(21, Move.TAKE_DOWN),
            Map.entry(24, Move.SWEET_SCENT),
            Map.entry(27, Move.SYNTHESIS),
            Map.entry(36, Move.SOLAR_BEAM)
        );
	
	
	
	
	public Bulbasaur(int lvl) {//					           hp   atk   def   satk  sdef  spd lvl xp
		super("Bulbasaur", Type.GRASS, Type.POISON,REWARD_LVL, 45.0, 49.0, 49.0, 65.0, 65.0, 45.0,lvl,0,"Ivysaur",16, Ability.OVERGROW,PECULIARMOVES);


	}

}
