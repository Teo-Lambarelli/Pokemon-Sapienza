package pokemon;
import java.util.Map; 
import java.util.ArrayList;
import types.Type;
import moves.Move;

public class Blastoise extends Pokemon {
    public final static String FRONTSPRITE = "src/sprites/blastoise.png";
    public final static String BACKSPRITE = "src/sprites/backblastoise.png";
    public final static Map<Integer, Move> PECULIARMOVES = null;
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
            Map.entry(40, Move.IRON_DEFENSE), 
            Map.entry(33, Move.HYDRO_PUMP),
            Map.entry(36, Move.WAVE_CRASH)
    );

    Blastoise(int lvl) {
        super("Blastoise", Type.WATER, REWARD_LVL, 79, 83, 100, 85, 105, 78, lvl, 36, null, 0, Ability.TORRENT, PECULIARMOVES, FRONTSPRITE, BACKSPRITE);
    }
}