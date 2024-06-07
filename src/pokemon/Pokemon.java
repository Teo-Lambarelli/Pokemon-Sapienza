package pokemon; import types.Type; import moves.*;import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public abstract class Pokemon {
	public final String FRONTSPRITE;
	public final String BACKSPRITE;
	private Stats stats;
	private Move[] moves;
	private int[] pp;
	private String name;
	private Type type0;
	private Type type1=null;
	private final Map<Integer, Move> REWARD_LVL;
	private final Map<Integer, Move> PECULIARMOVES;
	private final String evolution;
	private final int evolutionlvl;
	private Ability ability;
	private StatusEffect STATUS_EFFECT;
	
	public final static int MAX_MOVES = 4;
	
	
	
	Pokemon(String name, Type type0, Type type1, Map<Integer, Move> REWARD_LVL, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp,Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.type1=type1;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL; 
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.PECULIARMOVES=PECULIARMOVES;
		generateMoves();
		this.evolution=null;
		this.evolutionlvl=101;
		
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
        }
        
	Pokemon(String name, Type type0, Map<Integer, Move> REWARD_LVL, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp,Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);	
		this.PECULIARMOVES=PECULIARMOVES;
		generateMoves();
		this.evolution=null;
		this.evolutionlvl=101;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
        }
	
	Pokemon(String name, Type type0, Type type1, Map<Integer, Move> REWARD_LVL, Move[] moves, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp,Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.type1=type1;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.moves=moves;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.evolution=null;
		this.evolutionlvl=101;
		this.PECULIARMOVES=PECULIARMOVES;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
        }
	
	Pokemon(String name, Type type0, Map<Integer, Move> REWARD_LVL,Move[] moves, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.moves=moves;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);	
		this.evolution=null;
		this.evolutionlvl=101;
		this.PECULIARMOVES=PECULIARMOVES;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
        }
	
	Pokemon(String name, Type type0, Type type1, Map<Integer, Move> REWARD_LVL, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp,String evolution, int evolutionlvl, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.type1=type1;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.PECULIARMOVES=PECULIARMOVES;
		generateMoves();
		this.evolution=evolution;
		this.evolutionlvl=evolutionlvl;
		
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
        }
        
	Pokemon(String name, Type type0, Map<Integer, Move> REWARD_LVL, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp, String evolution, int evolutionlvl, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.PECULIARMOVES=PECULIARMOVES;
		generateMoves();
		this.evolution=evolution;
		this.evolutionlvl=evolutionlvl;
		
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
        }
	
	Pokemon(String name, Type type0, Type type1, Map<Integer, Move> REWARD_LVL, Move[] moves, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp, String evolution, int evolutionlvl, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.type1=type1;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.moves=moves;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.evolution=evolution;
		this.evolutionlvl=evolutionlvl;
		this.PECULIARMOVES=PECULIARMOVES;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
        }
	
	Pokemon(String name, Type type0, HashMap<Integer, Move> REWARD_LVL,Move[] moves, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp, String evolution, int evolutionlvl, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.moves=moves;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);	
		this.evolution=evolution;
		this.evolutionlvl=evolutionlvl;
		this.PECULIARMOVES=PECULIARMOVES;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
        }
	
	
	public void generateMoves() {
		int counter=0;
		if (PECULIARMOVES!=null) {
			for (int i=0; i<PECULIARMOVES.size() && counter<4; i++) {
				moves[counter]=PECULIARMOVES.get(i);
				
				counter++;
			}
		}
		
		for(int i=this.stats.lvl; i>0 && counter<4; i--) {
			if(REWARD_LVL.containsKey(i)) {
				moves[counter]=REWARD_LVL.get(i);
				counter++;
			}
			
			
		}

	}
	
	public void resetPP() {
		pp = new int[MAX_MOVES];
		for (int i = 0; i < MAX_MOVES; i++)
			if (moves[i] != null)
				pp[i] = moves[i].getPp();
	}
	
	
	
	public Map<Integer, Move> getRewardLvl(){
		return REWARD_LVL;
	}
	
	public String getName() {
		return name;
	}
	
	public Type getType0() { 
    	return type0;
    }
	
	public Type getType1() {
    	return type1;
    }
	
	public StatusEffect getStatusEffect() {
		return STATUS_EFFECT;
	}
	
	public String getFrontSprite() {
		return FRONTSPRITE;
	}
	
	public String getBackSprite() {
		return BACKSPRITE;
	}
	
	public Stats getStats() {
    	return stats;
    }
	
	public Move[] getMoves() {
    	return moves;
    }
	
	public String getEvolution() {
		return evolution;
	}
	
	public int getEvolutionLvl() {
		return evolutionlvl;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setOneMove(Move move, int index) {
		this.moves[index]=move;
	}
	public void setAllMoves(Move[] moves) {
		this.moves=moves;
	}
	
	public void setType0(Type type0) {
		this.type0=type0;
	}
	
	public void setType1(Type type1) {
		this.type1=type1;
	}
	
	public void setStatusEffect(StatusEffect STATUS_EFFECT) {
		this.STATUS_EFFECT=STATUS_EFFECT;
	}
	
	public void damage(double dmg) {
		this.getStats().setHp(this.getStats().getHp()-dmg);
	}
	
	public void heal(double hl) {
		this.getStats().setHp(this.getStats().getHp()+hl);
	}
	
	public int getPP(int i) {
		return pp[i];
	}
	
	public void setPP(int pp, int i) {
		this.pp[i] = pp;
	}
	
	public class Stats{
		private double xp;
		private int lvl;
		private double baseHp;
		private double baseAtk;
		private double baseDef;
		private double baseSatk;
		private double baseSdef;
		private double baseSpd;
		
		private double maxHp;

		private double hp;
		private double atk;
		private double def;
		private double satk;
		private double sdef;
		private double spd;
		
//		Esperienza guadagnata =
//		- se il pokemon battuto è di livello inferiore = (Liv. Pokemon battuto) x 10
//		- se il pokemon battuto è di pari livello = [(Liv. Pokemon battuto x 10) + (Liv. Pokemon battuto)]
//		- se il pokemon battuto è di livello maggiore = (Liv. Pokemon battuto) x 10 + [(Differenza di livello) x 10]
//		
		private Stats(double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd, int lvl,double xp){
			this.xp=xp;
			this.lvl=lvl;
			this.baseAtk=baseAtk;
			this.baseSatk=baseSatk;
			this.baseDef=baseDef;
			this.baseSdef=baseSdef;
			this.baseSpd=baseSpd;
			this.baseHp=baseHp;
			updateStats();
			//yay!
			
		}
		
		private void updateStats() {
			hp=(baseHp*lvl/50)+10+lvl;
			atk=(baseAtk*lvl/50)+5;
			def=(baseDef*lvl/50)+5;
			satk=(baseSatk*lvl/50)+5;
			sdef=(baseSdef*lvl/50)+5;
			spd=(baseSpd*lvl/50)+5;
			maxHp=hp;
		}
		
		public double getXp() {
			return xp;
		}
		
		public int getLvl() {
			return lvl;
		}
		
		public double getBaseHp() {
			return baseHp;
		}
		
		public double getBaseAtk() {
			return baseAtk;
		}
		
		public double getBaseSatk() {
			return baseSatk;
		}
		
		public double getBaseDef() {
			return baseDef;
		}
		
		public double getBaseSdef() {
			return baseSdef;
		}
		
		public double getBaseSpd() {
			return baseSpd;
		}
		
		public double getHp() {
			return hp;
		}
		
		public double getAtk() {
			return atk;
		}
		
		public double getSatk() {
			return satk;
		}
		
		public double getDef() {
			return def;
		}
		
		public double getSdef() {
			return sdef;
		}
		
		public double getSpd() {
			return spd;
		}		
		
		public double getMaxHp() {
			return maxHp;
		}
		
		public void setMaxHp(double maxHp) {
			this.maxHp=maxHp;
		}

		
		
		public void setHp(double hp) {
			this.hp=hp;
		}
		
		public void setAtk(double atk) {
			this.atk=atk;
		}
		
		public void setSatk(double satk) {
			this.satk=satk;
		}
		
		public void setDef(double def) {
			this.def=def;
		}
		
		public void setSdef(double sdef) {
			this.sdef=sdef;
		}
		
		public void setSpd(double spd) {
			this.spd=spd;
		}		
		
		public void setXp(double xp) {
			this.xp=xp;
		}
		
		public void giveXp(double xp) {
			this.xp+=xp;
			
		}

		
	}
}
