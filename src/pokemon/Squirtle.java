package pokemon;
import java.util.HashMap;
import types.Type;
import moves.Move;

public class Squirtle extends Pokemon{
	public final static HashMap<Integer, Move> rewardlvl=new HashMap<>() {{
		put(101, Move.TACKLE);
        put(1, Move.TAIL_WHIP);
        put(7, Move.WATER_GUN);
        put(10, Move.WITHDRAW);
        put(16, Move.WATER_PULSE);
        put(19, Move.BITE);
        put(25, Move.RAPID_SPIN);
        put(28, Move.SAFEGUARD);
        put(34, Move.WATERFALL);
        put(37, Move.SKULL_BASH);
        put(43, Move.IRON_DEFENCE);
        put(46, Move.RAIN_DANCE);
        
	}};
	
	
	public final static HashMap<Integer,Pokemon> evolutionlvl=new HashMap<>(){{
		put(16, new Wartortle());
		put(36, new Blastoise());
		
	}};
	
	
	public Squirtle() {//                        hp    atk   def   satk  sdef  spd lvl xp
		super("Squirtle", Type.WATER, rewardlvl, 44.0, 48.0, 65.0, 50.0, 64.0, 43.0,1,0);
  
	}

}
