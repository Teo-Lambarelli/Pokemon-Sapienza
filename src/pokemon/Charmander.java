package pokemon;
import java.util.HashMap;
import types.Type;
import moves.Move;

public class Charmander extends Pokemon{
	public final static HashMap<Integer, Move> rewardlvl=new HashMap<>() {{
    	put(101, Move.SCRATCH);    
        put(1, Move.GROWL);
        put(7, Move.EMBER);
        put(10, Move.LEER);
        put(16, Move.SMOKESCREEN);
        put(19, Move.DRAGON_RAGE);
        put(25, Move.SCARY_FACE);
        put(28, Move.FIRE_FANG);
        put(34, Move.FLAME_BURST);
        put(37, Move.SLASH);
        put(43, Move.FLAMETHROWER);
        put(46, Move.FIRE_SPIN);
  
    }};
    
    
    public final static HashMap<Integer,Pokemon> evolutionlvl=new HashMap<>(){{
		put(16, new Charmeleon());
		put(36, new Charizard());
		
	}};

	public Charmander() {//  	 				   hp    atk   def   satk  sdef  spd lvl xp
		super("Charmander", Type.FIRE, rewardlvl,  39.0, 52.0, 43.0, 60.0, 50.0, 65.0,1,0); 
		
		
	}

}
