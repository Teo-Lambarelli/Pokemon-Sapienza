package pokemon;
import java.util.Map;

import types.Type;
import moves.Move;

public class Squirtle extends Pokemon{
    public final static Map<Integer, Move> REWARD_LVL = Map.ofEntries(
            Map.entry(2, Move.TACKLE),
            Map.entry(1, Move.TAIL_WHIP),
            Map.entry(3, Move.WATER_GUN),
            Map.entry(6, Move.WITHDRAW),
            Map.entry(9, Move.RAPID_SPIN),
            Map.entry(12, Move.BITE),
            Map.entry(15, Move.WATER_PULSE),
            Map.entry(18, Move.SAFEGUARD),
            Map.entry(21, Move.RAIN_DANCE),
            Map.entry(24, Move.AQUA_TAIL),
            Map.entry(27, Move.SKULL_BASH),
            Map.entry(30, Move.IRON_DEFENCE),
            Map.entry(33, Move.HYDRO_PUMP),
            Map.entry(36, Move.WAVE_CRASH)
        );

	
	
	public Squirtle(int lvl) {//                  hp    atk   def   satk  sdef  spd lvl xp
		super("Squirtle", Type.WATER, REWARD_LVL, 44.0, 48.0, 65.0, 50.0, 64.0, 43.0,lvl,0,"Wartortle",16, Ability.TORRENT);
  
	}

}
