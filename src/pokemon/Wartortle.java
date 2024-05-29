package pokemon;
import java.util.ArrayList;
import java.util.Map;

import moves.Move;
import types.Type;

public class Wartortle extends Pokemon {
	public final static Map<Integer, Move> PECULIARMOVES= null;
    public final static Map<Integer, Move> REWARD_LVL = Map.ofEntries(
            Map.entry(2, Move.TACKLE),
            Map.entry(1, Move.TAIL_WHIP),
            Map.entry(3, Move.WATER_GUN),
            Map.entry(6, Move.WITHDRAW),
            Map.entry(9, Move.RAPID_SPIN),
            Map.entry(12, Move.BITE),
            Map.entry(15, Move.WATER_PULSE),
            Map.entry(20, Move.SAFEGUARD),
            Map.entry(25, Move.RAIN_DANCE),
            Map.entry(30, Move.AQUA_TAIL),
            Map.entry(35, Move.SKULL_BASH),
            Map.entry(40, Move.IRON_DEFENCE),
            Map.entry(33, Move.HYDRO_PUMP),
            Map.entry(36, Move.WAVE_CRASH)
        );

	Wartortle(int lvl) {
		super("Wartortle", Type.WATER, REWARD_LVL, 59, 63, 80, 65,80, 58, lvl, 36, "Blastoise",36, Ability.TORRENT,PECULIARMOVES);
	}

	
}
