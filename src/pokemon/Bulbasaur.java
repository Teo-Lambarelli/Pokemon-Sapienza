package pokemon;
import java.util.HashMap;
import types.Type;
import moves.Move;

public class Bulbasaur extends Pokemon{
	private final static HashMap<Integer, Move> rewardlvl=new HashMap<>() {{
		put(101, Move.TACKLE);
        put(1, Move.GROWL);
        put(7, Move.LEECH_SEED);
        put(10, Move.VINE_WHIP);
        put(16, Move.POISON_POWDER);
        put(19, Move.SLEEP_POWDER);
        put(25, Move.TAKE_DOWN);
        put(28, Move.RAZOR_LEAF);
        put(34, Move.SWEET_SCENT);
        put(37, Move.GROWTH);
        put(43, Move.SYNTHESIS);
        put(46, Move.SOLAR_BEAM);
	}};
	
	public Bulbasaur() {						//  hp    atk   def   satk  sdef  spd lvl xp
		super("Bulbasaur", Type.GRASS, Type.POISON,rewardlvl, 45.0, 49.0, 49.0, 65.0, 65.0, 45.0,1,0);


	}

}
