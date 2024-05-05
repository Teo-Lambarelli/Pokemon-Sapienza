package battlemanager; import pokemon.*; import java.util.Random; import moves.*; import types.*;

public class BattleManager {
	private Fighter[] fighter;
	private int turnCounter;
	public final static double STAB_VALUE=1.3;
	public final static int ON_FIELD = 2;
	public final static int PLAYER1_FIGHTER_SLOT = 0;
	public final static int PLAYER2_FIGHTER_SLOT = 1;
	public final static int SWITCH_PRIORITY = 6;
	public final static int CRITICAL_CHANCE = 24;
	public final static int CRITICAL_DAMAGE = 2;
	public final static int RANDOM_DAMAGE_SCALE = 100;
	public final static int RANDOM_DAMAGE_RANGE = 25;
	
	public BattleManager(Team team0, Team team1) {
		fighter = new Fighter[ON_FIELD];
		fighter[PLAYER1_FIGHTER_SLOT] = new Fighter(team0.pokemon.get(0), team0);
		fighter[PLAYER2_FIGHTER_SLOT] = new Fighter(team1.pokemon.get(0), team1);
		fighter[PLAYER1_FIGHTER_SLOT].opponent = fighter[PLAYER2_FIGHTER_SLOT];
		fighter[PLAYER2_FIGHTER_SLOT].opponent = fighter[PLAYER1_FIGHTER_SLOT];
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
	
	public void turnOption(int index, Choice choice) {
		fighter[index].choice = choice;
	}
	
	
	public double getCurrentSpd(Fighter fighter) {
		return fighter.pokemon.getStats().getSpd() + fighter.pokemon.getStats().getSpd()*fighter.statsChange.spd/100;
	}
	
	public double getCurrentAtk(Fighter fighter) {
		return fighter.pokemon.getStats().getAtk() + fighter.pokemon.getStats().getAtk()*fighter.statsChange.atk/100;
	}
	
	public double getCurrentDef(Fighter fighter) {
		return fighter.pokemon.getStats().getDef() + fighter.pokemon.getStats().getDef()*fighter.statsChange.def/100;
	}
	
	public double getCurrentSatk(Fighter fighter) {
		return fighter.pokemon.getStats().getSatk() + fighter.pokemon.getStats().getSatk()*fighter.statsChange.satk/100;
	}
	
	public double getCurrentSdef(Fighter fighter) {
		return fighter.pokemon.getStats().getSdef() + fighter.pokemon.getStats().getSdef()*fighter.statsChange.sdef/100;
	}
	
	
	
	public void battleStatus() {
		System.out.println("-------------------------------------------------------------------------");
		
		
		
		System.out.println("-------------------------------------------------------------------------");
	}
	
	public boolean isFaster(Fighter f0, Fighter f1) {
		if (f0.choice.option == f1.choice.option) {
			if (f0.choice.option == Choice.Option.MOVE) {
				Move m0 = f0.pokemon.getMoves()[f0.choice.index];
				Move m1 = f1.pokemon.getMoves()[f1.choice.index];
				
				int p0 = m0.getPriority();
				int p1 = m1.getPriority();
				
				if (p0 > p1)
					return true;
				else if (p1 > p0)
					return false;
				else {
					double s0 = getCurrentSpd(f0);
					double s1 = getCurrentSpd(f1);
					
					if (s0 > s1)
						return true;
					else if (s1 > s0)
						return false;
					else
						return new Random().nextBoolean();
				}
			}
			else if (f0.choice.option == Choice.Option.SWITCH) {
				double s0 = getCurrentSpd(f0);
				double s1 = getCurrentSpd(f1);
				
				if (s0 > s1)
					return true;
				else if (s1 > s0)
					return false;
				else
					return new Random().nextBoolean();
			}
			double s0 = getCurrentSpd(f0);
			double s1 = getCurrentSpd(f1);
			
			if (s0 > s1)
				return true;
			else if (s1 > s0)
				return false;
			else
				return new Random().nextBoolean();
		}
		else {
			int p0 = 6;
			if (f0.choice.option == Choice.Option.MOVE) {
				Move m0 = f0.pokemon.getMoves()[f0.choice.index];
				p0 = m0.getPriority();
			}
			int p1 = 6;
			if (f1.choice.option == Choice.Option.MOVE) {
				Move m1 = f1.pokemon.getMoves()[f1.choice.index];
				p0 = m1.getPriority();
			}
			
			if (p0 > p1)
				return true;
			else if (p1 > p0)
				return false;
			else {
				double s0 = getCurrentSpd(f0);
				double s1 = getCurrentSpd(f1);
				
				if (s0 > s1)
					return true;
				else if (s1 > s0)
					return false;
				else
					return new Random().nextBoolean();
			}
		}
	}
	
	public Fighter[] getTurnOrder() {
		Fighter[] turnOrder = fighter.clone();
		
		boolean correct;
		do {
			correct = true;
			for (int i = 0; i < turnOrder.length-1; i++) {
				if (!isFaster(turnOrder[i], turnOrder[i+1])) {
					Fighter temp = turnOrder[i];
					turnOrder[i] = turnOrder[i+1];
					turnOrder[i+1] = temp;
					correct = false;
				}
			}
		} while (!correct); 
		
		return turnOrder;
	}
	
	public void executeAttack(Fighter fighter) {
		// Data
		Move move = fighter.pokemon.getMoves()[fighter.choice.index];
		Random rng = new Random();
		
		// Accuracy calculation
		double percent = move.getAcc() + fighter.statsChange.accuracy - fighter.opponent.statsChange.evasion;
		if (percent >= rng.nextInt(101)) {
			// We got an hit!
			if (move.getCat() == Category.STATUS) {
				// TODO: STATUS MOVES
				
				
			}
			else {
				
				boolean critical = rng.nextInt(CRITICAL_CHANCE) == 0;
				
				double levelDamage = (fighter.pokemon.getStats().getLvl() * 2 / 5) + 2;
				
				double moveDamage = move.getDmg();
				
				double atk = 1, def = 1;
				if (critical) {
					if (move.getCat() == Category.PHYSICAL) {
						if (fighter.statsChange.atk <= 0)
							atk = fighter.pokemon.getStats().getAtk();
						else
							atk = getCurrentAtk(fighter);
						if (fighter.opponent.statsChange.def >= 0)
							def = fighter.opponent.pokemon.getStats().getDef();
						else
							def = getCurrentDef(fighter.opponent);
					}
					else if (move.getCat() == Category.SPECIAL) {
						if (fighter.statsChange.satk <= 0)
							atk = fighter.pokemon.getStats().getSatk();
						else
							atk = getCurrentSatk(fighter);
						if (fighter.opponent.statsChange.sdef >= 0)
							def = fighter.opponent.pokemon.getStats().getSdef();
						else
							def = getCurrentSdef(fighter.opponent);
					}
				}
				else {
					if (move.getCat() == Category.PHYSICAL) {
						atk = getCurrentAtk(fighter);
						def = getCurrentDef(fighter.opponent);
					}
					else if (move.getCat() == Category.SPECIAL) {
						atk = getCurrentSatk(fighter);
						def = getCurrentSdef(fighter.opponent);
					}
				}
				double statDamage = atk / def;
				
				double baseDamage = (levelDamage * moveDamage * statDamage / 50) + 2;
				
				// weatherDamage
				
				double criticalDamage = 1;
				if (critical)
					criticalDamage *= CRITICAL_DAMAGE;
				
				double randomDamage = (rng.nextDouble(RANDOM_DAMAGE_RANGE + 1) + RANDOM_DAMAGE_SCALE - RANDOM_DAMAGE_RANGE) / 100;
				
				double stabDamage = 1;
				if (move.getType() == fighter.pokemon.getType0() || move.getType() == fighter.pokemon.getType1())
					stabDamage = 1.5;
				
				double typeDamage = Typechart.typechart[move.getType().getValue()][fighter.opponent.pokemon.getType0().getValue()];
				if (fighter.opponent.pokemon.getType1() != null)
					typeDamage *= Typechart.typechart[move.getType().getValue()][fighter.opponent.pokemon.getType1().getValue()];
				
				// burnDamage
				
				// TOTAL DAMAGE
				double totalDamage = baseDamage * criticalDamage * randomDamage * stabDamage * typeDamage;
				
				// Deal damage
				fighter.opponent.pokemon.damage(totalDamage);
				System.out.println("-------------------------------------------------------------------------");
				System.out.println(fighter.pokemon.getName() + " ha colpito il suo bersaglio " + fighter.opponent.pokemon.getName() + " usando " + move.toString());
				System.out.println("Danno totale: " + totalDamage);
				System.out.println("Danno base: " + baseDamage);
				System.out.println("Danno critico: " + criticalDamage);
				System.out.println("Danno casuale: " + randomDamage);
				System.out.println("Danno STAB: " + stabDamage);
				System.out.println("Danno tipo: " + typeDamage);
				System.out.println("-------------------------------------------------------------------------");
				
				// Apply effects
			}
		}
		else {
			// Move misses
			System.out.println(fighter.pokemon.getName() + " ha mancato il suo bersaglio " + fighter.opponent.pokemon.getName() + " usando " + move.toString() + ". (" + percent + "%)ACCURATEZZA");
		}
	}
	
	public void executeAction(Fighter fighter) {
		if (fighter.choice.option == Choice.Option.MOVE) {
			// Attack the enemy!
			// TODO: ANIMATION
			executeAttack(fighter);
		}
		else if (fighter.choice.option == Choice.Option.SWITCH) {
			// Switch out pokemon!
			// TODO: ANIMATION
			fighter.pokemon = fighter.team.pokemon.get(fighter.choice.index);
			fighter.statsChange.statsReset();
		}
		else if (fighter.choice.option == Choice.Option.FLEE) {
			// ESCAPE! RUUUN!
			// TODO: END FIGHT
		}
	}
	
	public void executeTurn() {
		Fighter[] turnOrder = getTurnOrder();

		for (Fighter f : turnOrder)
			System.out.println(f.pokemon);
		
		for (Fighter f : turnOrder)
			executeAction(f);
	}
}
