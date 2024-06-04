package pokemon;

import java.util.Map;

import moves.Move;
import types.Type;

public class Pikachu extends Pokemon {
	public final static String FRONTSPRITE="src/sprites/pikachu.png";
	public final static String BACKSPRITE="src/sprites/backpikachu.png";
	public final static Map<Integer, Move> PECULIARMOVES= null;
    public final static Map<Integer, Move> REWARD_LVL = Map.ofEntries(
            Map.entry(2, Move.THUNDER_SHOCK),
            Map.entry(1, Move.TAIL_WHIP),
            Map.entry(3, Move.GROWL),
            Map.entry(6, Move.NASTY_PLOT),
            Map.entry(9, Move.ELECTRO_BALL),
            Map.entry(12, Move.BITE),
            Map.entry(15, Move.THUNDER_WAVE),
            Map.entry(18, Move.IRON_TAIL),
            Map.entry(21, Move.ZAP_CANNON),
            Map.entry(24, Move.SHOCK_WAVE),
            Map.entry(27, Move.PSYSHOCK),
            Map.entry(30, Move.IRON_DEFENCE),
            Map.entry(33, Move.FLASH_CANNON),
            Map.entry(36, Move.WAVE_CRASH)
        );

	
	
	public Pikachu(int lvl) {//                  hp    atk   def   satk  sdef  spd lvl xp
		super("Pikachu", Type.WATER, REWARD_LVL, 44.0, 48.0, 65.0, 50.0, 64.0, 43.0,lvl,0,null,16, Ability.TORRENT,PECULIARMOVES, FRONTSPRITE,BACKSPRITE);
  
	}

}