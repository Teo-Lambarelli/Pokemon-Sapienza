package pokemon;

import java.util.Map;

import moves.Move;
import types.Type;

public class Venusaur extends Pokemon {
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
            Map.entry(37, Move.SYNTHESIS),
//            44 worry seed
//            51 power whimp
            Map.entry(58, Move.SOLAR_BEAM)
        );
	Venusaur(String name, Type type0, Type type1, Map<Integer, Move> rewardlvl, double baseHp, double baseAtk,
			double baseDef, double baseSatk, double baseSdef, double baseSpd, int lvl, int xp, Ability ability) {
		super(name, type0, type1, rewardlvl, baseHp, baseAtk, baseDef, baseSatk, baseSdef, baseSpd, lvl, xp, ability);
		// TODO Auto-generated constructor stub
	}

}
