package pokemon; import types.Type; import moves.Move;

import java.util.HashMap;
import java.util.Random;

public abstract class Pokemon {
	private Stats stats;
	private Move[] moves;
	private String name;
	private Type type0;
	private Type type1=null;
	private HashMap<Integer, Move> rewardlvl;
//	private LevelUpReward[] rewards;

	
	
	Pokemon(String name, Type type0, Type type1, HashMap<Integer, Move> rewardlvl, double hp, double atk, double def, double satk, double sdef, double spd,int lvl,int xp){
		this.name=name;
		this.type0=type0;
		this.type1=type1;
		this.moves=new Move[4];
		this.stats=new Stats(hp,atk,def,satk,sdef,spd,lvl,xp);


        }
        
	
	
	Pokemon(String name, Type type0, HashMap<Integer, Move> rewardlvl, double hp, double atk, double def, double satk, double sdef, double spd,int lvl,int xp){
		this.name=name;
		this.type0=type0;
		this.moves=new Move[4];
		this.rewardlvl=rewardlvl;
		this.moves[0]=rewardlvl.get(101);
		this.moves[1]=rewardlvl.get(1);
		this.stats=new Stats(hp,atk,def,satk,sdef,spd,lvl,xp);
		

        }
        
	public HashMap<Integer, Move> getRewardLvl(){
		return rewardlvl;
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
	
	public Stats stats() {
    	return stats;
    }
	
	public Move[] getMoves() {
    	return moves;
    }
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setOneMove(Move move, int index) {
		moves[index]=move;
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
	
	public class Stats{
		private int xp;
		private int lvl;
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
		private Stats(double hp, double atk, double def, double satk, double sdef, double spd, int lvl,int xp){
			this.xp=xp;
			this.lvl=lvl;
			this.atk=atk;
			this.satk=satk;
			this.def=def;
			this.sdef=sdef;
			this.spd=spd;
			this.hp=hp;
		}
		
		public int getXp() {
			return xp;
		}
		
		public int getlvl() {
			return lvl;
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
		
		public void setHp(double hp) {
			this.hp=hp;
		}
		
		public void setAtk(double atk) {
			this.atk=atk;
		}
		
		public void setDef(double def) {
			this.def=def;
		}
		
		public void setSatk(double satk) {
			this.satk=satk;
		}
		
		public void setSdef(double sdef) {
			this.sdef=sdef;
		}
		
		public void setSpd(double spd) {
			this.spd=spd;
		}
		
	}
}
