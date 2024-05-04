package battlemanager; import pokemon.*; import java.util.Random; import moves.*; import types.*;

public class BattleManager {
	protected Pokemon fighter0;
	protected Pokemon fighter1;
	protected Team team0;
	protected Team team1;
	protected Choice choice0;
	protected Choice choice1;
	private int turnCounter;
	private StatsChange statsChange0=new StatsChange();
	private StatsChange statsChange1=new StatsChange();
	public final static double STAB_VALUE=1.3;
	
	public BattleManager(Team team0, Team team1) {
		this.fighter0=team0.pokemon.get(0);
		this.fighter1=team1.pokemon.get(0);
		this.team0=team0;
		this.team1=team1;
		startFight();
	}
	
	public void startFight() {
		/*TODO:
		 * 		
		 * animazione send in,
		 * start turn effect,
		 * ask for action
		 * 
		 */
	}
	
	public void startTurnEffects() {
		
	}
	
	public void turnOption0(Choice choice) {
		this.choice0=choice;
	
	}
	
	public void turnOption1(Choice choice) {
		this.choice1=choice;
	
	}
	
	
	public double getCurrentSpd(Pokemon fighter) {
		if(fighter==fighter0) {
			return fighter.getStats().getSpd() + fighter.getStats().getSpd()*statsChange0.spd/100;
		}
		return fighter.getStats().getSpd() + fighter.getStats().getSpd()*statsChange1.spd/100;
	}
	
	public double getCurrentAtk(Pokemon fighter) {
		if(fighter==fighter0) {
			return fighter.getStats().getAtk() + fighter.getStats().getAtk()*statsChange0.atk/100;
		}
		return fighter.getStats().getAtk() + fighter.getStats().getAtk()*statsChange1.atk/100;
	}
	
	public double getCurrentDef(Pokemon fighter) {
		if(fighter==fighter0) {
			return fighter.getStats().getDef() + fighter.getStats().getDef()*statsChange0.def/100;
		}
		return fighter.getStats().getDef() + fighter.getStats().getDef()*statsChange1.def/100;
	}
	
	public double getCurrentSatk(Pokemon fighter) {
		if(fighter==fighter0) {
			return fighter.getStats().getSatk() + fighter.getStats().getSatk()*statsChange0.satk/100;
		}
		return fighter.getStats().getSatk() + fighter.getStats().getSatk()*statsChange1.satk/100;
	}
	
	public double getCurrentSdef(Pokemon fighter) {
		if(fighter==fighter0) {
			return fighter.getStats().getSdef() + fighter.getStats().getSdef()*statsChange0.sdef/100;
		}
		return fighter.getStats().getSdef() + fighter.getStats().getSdef()*statsChange1.sdef/100;
	}
	
	
	//spd+ spd*0-300/100
	public boolean speedRoll() {
		double cs0=getCurrentSpd(fighter0);
		double cs1=getCurrentSpd(fighter1);
		
		if(cs0>cs1) {
			return false;
		}
		else if(cs0<cs1) {
			return true;
		}
		else {
			return new Random().nextBoolean();
		}
	}
	
	
	public boolean priorityCalculator(Move m0, Move m1) {
		if (m0.getPriority()== m1.getPriority()) {
			return speedRoll();
		}
		else {
			if(m0.getPriority()>m1.getPriority()) {
				return false;
			}
			else {
				return true;
			}
		}
	}
	
	
	public void battleStatus() {
		System.out.println(fighter0);
		System.out.println(fighter1);
	}
	
	public void executeAttack(Pokemon user, Pokemon target, Move move, StatsChange statsChangeUser, StatsChange statsChangeTarget) {
		double percent=move.getAcc()+statsChangeUser.accuracy-statsChangeTarget.evasion;
		Random number=new Random();
		int randomNum = number.nextInt(101);
		/*
		 * 
		 * TODO fare i danni, yay!
		 * 
		 * 
		 */
//		if(randomNum<percent) {
//			//colpisce
//			if(move.getCat()== Category.PHYSICAL) {
//				//fai danni
//				double damage=(getCurrentAtk(user)*move.getDmg()/100);
//				if (user.getType0()==move.getType() || user.getType1()==move.getType()) {
//					damage*=STAB_VALUE;
//				}
//				damage*=Typechart.typechart[move.getType().getValue()][target.getType0().getValue()];
//				if (target.getType1()!=null) {
//					damage*=Typechart.typechart[move.getType().getValue()][target.getType1().getValue()];
//				}
//				damage-=getCurrentDef(target);
//				target.damage(damage);
//				System.out.println(user.getName()+" ha attaccato "+target.getName()+" con "+ move.toString()+" facendo "+damage+"hp!");
//			}
//			else if(move.getCat()== Category.SPECIAL) {
//				//fai danni
//				double damage=(getCurrentSatk(user)*move.getDmg()/100);
//				if (user.getType0()==move.getType() || user.getType1()==move.getType()) {
//					damage*=STAB_VALUE;
//				}
//				damage*=Typechart.typechart[move.getType().getValue()][target.getType0().getValue()];
//				if (target.getType1()!=null) {
//					damage*=Typechart.typechart[move.getType().getValue()][target.getType1().getValue()];
//				}
//				damage-=getCurrentSdef(target);
//				target.damage(damage);
//				System.out.println(user.getName()+" ha attaccato "+target.getName()+" con "+ move.toString()+" facendo "+damage+"hp!");
//			}
//			else if(move.getCat()== Category.STATUS) {
//				//fai robe 
//			}
//		}
//		else {
			//missa
//			System.out.println("Hai missato!");
//		}
//		
	}
	
	public void executeTurn() {

		/*
		 * se menano
		 * priority:  DEVO PRANZARE TORNO TRA POCO
		 * 1)switch
		 * 
		 */
		
		//SWITCH
		if (choice1.option==Choice.Option.SWITCH && choice0.option==Choice.Option.SWITCH) {
			if(!speedRoll()) {
				//switch di fighter0
				fighter0=team0.pokemon.get(choice0.index);
				//switch di fighter1
				fighter1=team1.pokemon.get(choice1.index);
			}
			else {
				//switch di fighter1
				fighter1=team1.pokemon.get(choice1.index);
				//switch di fighter0
				fighter0=team0.pokemon.get(choice0.index);
			}	
		}
		
		else if(choice0.option==Choice.Option.SWITCH){
			//switch di fighter0
			fighter0=team0.pokemon.get(choice0.index);
			
		}
		
		else if(choice1.option==Choice.Option.SWITCH){
			//switch di fighter1
			fighter1=team1.pokemon.get(choice1.index);
			
		}
		
		if (choice1.option==Choice.Option.MOVE && choice0.option==Choice.Option.MOVE) {
			Move move0=fighter0.getMoves()[choice0.index];
			Move move1=fighter1.getMoves()[choice1.index];
			if(!priorityCalculator(move0, move1)) {
				
				//attacca fighter0
				executeAttack(fighter0, fighter1, move0, statsChange0, statsChange1);
				executeAttack(fighter1, fighter0, move1, statsChange1, statsChange0);
				
			}
			else {
				//attacca fighter1
				executeAttack(fighter1, fighter0, move1, statsChange1, statsChange0);
				executeAttack(fighter0, fighter1, move0, statsChange0, statsChange1);
				
			}
		}
		
		
	}
}
