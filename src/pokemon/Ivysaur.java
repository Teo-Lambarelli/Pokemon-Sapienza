package pokemon;
import java.util.Map; 
import java.util.ArrayList;
import types.Type;
import moves.Move;

public class Ivysaur extends Pokemon {
    public final static String FRONTSPRITE = "src/sprites/ivysaur.png";
    public final static String BACKSPRITE = "src/sprites/backivysaur.png";
    public final static Map<Integer, Move> PECULIARMOVES = null;
    public final static Map<Integer, Move> REWARD_LVL = Map.ofEntries(
            Map.entry(1, Move.TACKLE),
            Map.entry(1, Move.GROWTH),
            Map.entry(1, Move.LEER),
            Map.entry(1, Move.VINE_WHIP),
            Map.entry(7, Move.GROWTH),
            Map.entry(10, Move.LEECH_SEED),
            Map.entry(13, Move.VINE_WHIP),
            Map.entry(20, Move.POISON_POWDER),
            Map.entry(23, Move.RAZOR_LEAF),
            Map.entry(28, Move.SLEEP_POWDER),
            Map.entry(31, Move.SWEET_SCENT),
            Map.entry(36, Move.GROWTH),
            Map.entry(39, Move.SYNTHESIS),
            Map.entry(44, Move.SOLAR_BEAM)
    );

    Ivysaur(int lvl) {
        super("Ivysaur", Type.GRASS, REWARD_LVL, 60, 62, 63, 80, 80, 60, lvl, 32, "Venusaur", 32, Ability.OVERGROW, PECULIARMOVES, FRONTSPRITE, BACKSPRITE);
    }
}