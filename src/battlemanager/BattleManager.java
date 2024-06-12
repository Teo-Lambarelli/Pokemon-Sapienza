package battlemanager; import pokemon.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.Timer;

import frame.Atkmn;
import frame.BattleGUI;
import moves.*; import types.*;

public class BattleManager {
	private  Fighter[] fighter;
	private int counter=0;
	private int turnCounter;
	private int c=0;
	public final static double STAB_VALUE=1.3;
	public final static int ON_FIELD = 2;
	public final static int PLAYER1_FIGHTER_SLOT = 0;
	public final static int PLAYER2_FIGHTER_SLOT = 1;
	public final static int SWITCH_PRIORITY = 6;
	public final static int CRITICAL_DAMAGE = 2;
	public final static int RANDOM_DAMAGE_SCALE = 100;
	public final static int RANDOM_DAMAGE_RANGE = 25;
	private Team team0;
	private Team team1;
	
	public BattleManager(Team team0, Team team1) {
		fighter = new Fighter[ON_FIELD];
		fighter[PLAYER1_FIGHTER_SLOT] = new Fighter(team0.pokemon.get(0), team0);
		fighter[PLAYER2_FIGHTER_SLOT] = new Fighter(team1.pokemon.get(0), team1);
		fighter[PLAYER1_FIGHTER_SLOT].opponent = fighter[PLAYER2_FIGHTER_SLOT];
		fighter[PLAYER2_FIGHTER_SLOT].opponent = fighter[PLAYER1_FIGHTER_SLOT];
		this.team0=team0;
		this.team1=team1;
		startFight();
//		for(Fighter Fighter:fighter) {
//			System.out.println(Fighter.pokemon.getName());
//		}
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
	
	public void setTeam0(Team team0) {
		this.team0=team0;
	}
	public void setTeam1(Team team1) {
		this.team0=team1;
	}
	
	public void startTurnEffects() {
		
	}
	
	public Fighter[] getFighter() {
		return fighter;
	}
	
	public void setFighter(Pokemon pkmn, Team team,int index) {
		fighter[index]=new Fighter(pkmn, team);
	}
	
	public void turnOption(int index, Choice choice) {
		fighter[index].choice = choice;
	}
	
	
	public double getCurrentSpd(Fighter fighter) {
		double stat=fighter.pokemon.getStats().getSpd();
		if(fighter.statsChange.spd>=0) {	
			stat+=stat*fighter.statsChange.spd/2;
			return stat;
		}							
		else {
			double s0=stat*2;
			double s1=2-fighter.statsChange.spd;
			double s2=s0/s1;
			return s2;
		}
	}
	
	public double getCurrentAtk(Fighter fighter) {
		double stat=fighter.pokemon.getStats().getAtk();
		if(fighter.statsChange.atk>=0) {	
			stat+=stat*fighter.statsChange.atk/2;
			return stat;
		}							
		else {
			double s0=stat*2;
			double s1=2-fighter.statsChange.atk;
			double s2=s0/s1;
			return s2;
		}
	}
	
	public double getCurrentDef(Fighter fighter) {
		double stat=fighter.pokemon.getStats().getDef();
		if(fighter.statsChange.def>=0) {	
			stat+=stat*fighter.statsChange.def/2;
			return stat;
		}							
		else {
			double s0=stat*2;
			double s1=2-fighter.statsChange.def;
			double s2=s0/s1;
			return s2;
		}
	}
	
	public double getCurrentSatk(Fighter fighter) {
		double stat=fighter.pokemon.getStats().getSatk();
		if(fighter.statsChange.satk>=0) {	
			stat+=stat*fighter.statsChange.satk/2;
			return stat;
		}							
		else {
			double s0=stat*2;
			double s1=2-fighter.statsChange.satk;
			double s2=s0/s1;
			return s2;
		}
	}
	
	public double getCurrentSdef(Fighter fighter) {
		double stat=fighter.pokemon.getStats().getSdef();
		if(fighter.statsChange.sdef>=0) {	
			stat+=stat*fighter.statsChange.sdef/2;
			return stat;
		}							
		else {
			double s0=stat*2;
			double s1=2-fighter.statsChange.sdef;
			double s2=s0/s1;
			return s2;
		}
	}
	
	
	public Team getTeam0() {
		return team0;
	}
	
	public Team getTeam1() {
		return team1;
	}
	
	public void battleStatus() {
		System.out.println("-------------------------------------------------------------------------");
		for (Fighter f:fighter) {
			
			System.out.println("name: "+f.pokemon.getName());
			System.out.println("maxHp "+f.pokemon.getStats().getMaxHp());
			System.out.println("currentHp: "+f.pokemon.getStats().getHp());
			System.out.println("atk: "+f.pokemon.getStats().getAtk());
			System.out.println("def: "+f.pokemon.getStats().getDef());
			System.out.println("satk: "+f.pokemon.getStats().getSatk());
			System.out.println("sdef: "+f.pokemon.getStats().getSdef());
			System.out.println("spd: "+f.pokemon.getStats().getSpd());
			for(Move m:f.pokemon.getMoves()) {
				System.out.print(m+" ");
			}
			System.out.println("\n");
		}
		
		
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
			
//			System.out.println(f0.choice.option);
			
			if (f0.choice.option == Choice.Option.MOVE) {
				Move m0 = f0.pokemon.getMoves()[f0.choice.index];
				
				
				
				p0 = m0.getPriority();
				
				
			}
			int p1 = 6;
			if (f1.choice.option == Choice.Option.MOVE) {
				Move m1 = f1.pokemon.getMoves()[f1.choice.index];
				p1 = m1.getPriority();
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
		
		// Remove 1 PP
		fighter.pokemon.setPP(fighter.pokemon.getPP(fighter.choice.index)-1, fighter.choice.index);
		
		// Accuracy calculation
		double percent = move.getAcc() + fighter.statsChange.accuracy - fighter.opponent.statsChange.evasion;
		if (percent >= rng.nextInt(101)) {
			// We got an hit!
			if (move.getCat() == Category.STATUS) {
				// TODO: STATUS MOVES
				System.out.println("-------------------------------------------------------------------------");
				System.out.println(fighter.pokemon.getName() + " usa " + move.toString() + " su di " + fighter.opponent.pokemon.getName());
				System.out.println("Descrizione mossa: " + move.getDescr());
				switch(move) {
					case Move.GROWL:
						System.out.println("Diminuisce la difesa di " + fighter.opponent.pokemon.getName() + " fino a: " + fighter.opponent.statsChange.def);
						if (fighter.opponent.statsChange.bonusDef(-1))
							System.out.println("La statistica era già troppo bassa per essere modificata");
						break;
					case Move.SMOKESCREEN:
						System.out.println("Diminuisce l'accuratezza di " + fighter.opponent.pokemon.getName() + " fino a: " + fighter.opponent.statsChange.accuracy);
						if (fighter.opponent.statsChange.bonusAccuracy(-1))
							System.out.println("La statistica era già troppo bassa per essere modificata");
						break;
					case Move.SCARY_FACE:
						System.out.println("Diminuisce la velocità di " + fighter.opponent.pokemon.getName() + " fino a: " + fighter.opponent.statsChange.def);
						if (fighter.opponent.statsChange.bonusDef(-2))
							System.out.println("La statistica era già troppo bassa per essere modificata");
						break;
					default:
						System.out.println("ERRORE: La mossa non è STATUS, ma è" + move.getCat().toString());
						break;
				}
				System.out.println("-------------------------------------------------------------------------");
				
			}
			else {
				
				boolean critical = rng.nextInt(fighter.statsChange.getCritChance()) == 0;
				//Exception critical
				if (Arrays.asList(
						Move.AIR_CUTTER,
						Move.DRILL_RUN,
						Move.NIGHT_SLASH,
						Move.PSYCHO_CUT,
						Move.RAZOR_LEAF,
						Move.SHADOW_CLAW,
						Move.SKY_ATTACK,
						Move.SLASH
					).contains(move)) {
					fighter.statsChange.bonusCritical(1);
					critical = rng.nextInt(fighter.statsChange.getCritChance()) == 0;
					fighter.statsChange.bonusCritical(-1);
				}
				
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
				
				//Exception damage
				if (move == Move.DRAGON_RAGE) {
					totalDamage = 40 * ((typeDamage != 0) ? 1 : 0);
				}
				
				// Deal damage
				fighter.opponent.pokemon.damage(totalDamage);
				System.out.println("-------------------------------------------------------------------------");
				System.out.println(fighter.pokemon.getName() + " ha colpito il suo bersaglio " + fighter.opponent.pokemon.getName() + " usando " + move.toString());
				System.out.println("Danno totale: " + (String.format("%.2f",totalDamage)));
				System.out.println("Danno base: " + baseDamage);
				System.out.println("Danno critico: " + criticalDamage);
				System.out.println("Danno casuale: " + randomDamage);
				System.out.println("Danno STAB: " + stabDamage);
				System.out.println("Danno tipo: " + typeDamage);
				
				// Apply effects
				switch (move) {
					case Move.EMBER:
					case Move.FIRE_FANG:
					case Move.FLAMETHROWER:
						if (rng.nextInt(10) == 0)
							if (fighter.opponent.pokemon.getStatusEffect() == StatusEffect.DEFAULT) {
								fighter.opponent.pokemon.setStatusEffect(StatusEffect.BURN);
								System.out.println("Effetto: L'avversario è stato bruiato");
							}
							else
								System.out.println("Effetto: L'avversario ha già uno effetto di stato e non può essere bruciato");
						else
							System.out.println("Effetto: L'effetto non si è attivvato");
						break;
					case Move.DRAGON_BREATH:
						if (rng.nextInt(30) == 0)
							if (fighter.opponent.pokemon.getStatusEffect() == StatusEffect.DEFAULT) {
								fighter.opponent.pokemon.setStatusEffect(StatusEffect.PARALYZED);
								System.out.println("Effetto: L'avversario è stato paralizzato");
							}
							else
								System.out.println("Effetto: L'avversario ha già uno effetto di stato e non può essere bruciato");
						else
							System.out.println("Effetto: L'effetto non si è attivvato");
						break;
					default:
						System.out.println("Effetto: La mossa non ha effetti particolari");
						break;
				}
				System.out.println("-------------------------------------------------------------------------");
			}
		}
		else {
			// Move misses
			System.out.println(fighter.pokemon.getName() + " ha mancato il suo bersaglio " + fighter.opponent.pokemon.getName() + " usando " + move.toString() + ". (" + percent + "%)ACCURATEZZA");
		}
	}
	
	public void executeAction(Fighter fighter) {
		if (fighter.choice.option == Choice.Option.MOVE) {
			boolean cbg=false;
			if (counter==1) {cbg=true;}
			int mauro=1;
			if(fighter==this.fighter[0]) {mauro=0;}
			new Atkmn(this.fighter[0],this.fighter[1],mauro,false, this, cbg);
			if (counter==1) {cbg=true;counter=0;}
			else {counter++;}
//			executeAttack(fighter);
			
			
			
			
		}
		
		else if (fighter.choice.option == Choice.Option.SWITCH) {
			// Switch out pokemon!
			// TODO: ANIMATION
//			if (!fighter.has(EventType.FIRE_SPIN)) {
//				fighter.pokemon = fighter.team.pokemon.get(fighter.choice.index);
//				fighter.statsChange.statsReset();
//			}
//			else {
				System.out.println("-------------------------------------------------------------------------");
				System.out.println(fighter.pokemon.getName() + " non è stato in grado di scambiare perché sotto l'effetto di FIRE_SPIN");
				System.out.println("-------------------------------------------------------------------------");
//			}
			
			BattleGUI.bGUI.dispose();
			int mauro=1;
			if(fighter==this.fighter[0]) {mauro=0;}

			Pokemon[] appoggio=new Pokemon[1];
			appoggio[0]=fighter.pokemon;
			fighter.pokemon = fighter.team.pokemon.get(fighter.choice.index);
			fighter.team.setPkmn(appoggio[0],fighter.choice.index);
			fighter.team.setPkmn(fighter.pokemon, 0);
			this.setFighter(fighter.pokemon,fighter.team , mauro);
			if (counter==1) {new BattleGUI(this,0);counter=0;}
			counter++;
			fighter.statsChange.statsReset();
		}
	}
	
	public void executeFighterEvent(Fighter fighter) {
		if (fighter.has(EventType.FIRE_SPIN)) {
			Fighter opponent = fighter.opponent;
			Move move = Move.FIRE_SPIN;
			Random rng = new Random();
			
			double levelDamage = (opponent.pokemon.getStats().getLvl() * 2 / 5) + 2;
			
			double moveDamage = move.getDmg();
			
			double atk = 1, def = 1;
			
			if (move.getCat() == Category.PHYSICAL) {
				atk = getCurrentAtk(opponent);
				def = getCurrentDef(fighter);
			}
			else if (move.getCat() == Category.SPECIAL) {
				atk = getCurrentSatk(opponent);
				def = getCurrentSdef(fighter);
			}
			
			double statDamage = atk / def;
			
			double baseDamage = (levelDamage * moveDamage * statDamage / 50) + 2;
			
			// weatherDamage
			
			double randomDamage = (rng.nextDouble(RANDOM_DAMAGE_RANGE + 1) + RANDOM_DAMAGE_SCALE - RANDOM_DAMAGE_RANGE) / 100;
			
			double stabDamage = 1;
			if (move.getType() == opponent.pokemon.getType0() || move.getType() == opponent.pokemon.getType1())
				stabDamage = 1.5;
			
			double typeDamage = Typechart.typechart[move.getType().getValue()][fighter.pokemon.getType0().getValue()];
			if (fighter.pokemon.getType1() != null)
				typeDamage *= Typechart.typechart[move.getType().getValue()][fighter.pokemon.getType1().getValue()];
			
			// burnDamage
			
			// TOTAL DAMAGE
			double totalDamage = baseDamage * randomDamage * stabDamage * typeDamage;
			
			// Deal damage
			fighter.pokemon.damage(totalDamage);
			
			System.out.println("-------------------------------------------------------------------------");
			System.out.println(fighter.pokemon.getName() + " prende i danni di " + move.toString());
			System.out.println("Danno totale: " + totalDamage);
			System.out.println("Danno base: " + baseDamage);
			System.out.println("Danno casuale: " + randomDamage);
			System.out.println("Danno STAB: " + stabDamage);
			System.out.println("Danno tipo: " + typeDamage);
			System.out.println("-------------------------------------------------------------------------");
		}
	}
	
	public void executeTurn() {
		BattleGUI.bGUI.dispose();
		Fighter[] turnOrder = getTurnOrder();
		
		for (Fighter f : turnOrder)
			System.out.println(f.pokemon);
		
		
		
		if(turnOrder[0].choice.option==Choice.Option.MOVE && turnOrder[1].choice.option==Choice.Option.MOVE) {
			
			
				boolean scambio=true;
				if(turnOrder[0]==fighter[0]) {scambio=false;}
			
				
				int mauro=0;
				if(fighter[0].pokemon==turnOrder[1].pokemon) {mauro=1;}
				new Atkmn(fighter[0],fighter[1],mauro,true, this, false);
		}
		
		else {
			for (Fighter f : turnOrder)
				executeAction(f);
			
			//EXECUTE EVENT
//			for (Fighter f : turnOrder) {
//				executeFighterEvent(f);
//				f.turnPass();
//			}
		}
	}
	

	public void checkXp(Fighter fighter, int i) {
		int oppLvl=fighter.opponent.pokemon.getStats().getLvl();
		int urLvl=fighter.pokemon.getStats().getLvl();
		if(oppLvl<urLvl) {
			fighter.pokemon.getStats().giveXp(oppLvl*10);
			}
		else if(oppLvl==urLvl) {
			fighter.pokemon.getStats().giveXp((oppLvl*10)+oppLvl);
			}
		else if(oppLvl>urLvl) {
			fighter.pokemon.getStats().giveXp((oppLvl*10)+((oppLvl-urLvl)*10));
			}
		fighter.pokemon.getStats().updateStats();
		if (fighter.pokemon.getStats().getXp()>=urLvl*10) {
			double diff=fighter.pokemon.getStats().getMaxHp()-fighter.pokemon.getStats().getHp();
			fighter.pokemon.getStats().setXp(fighter.pokemon.getStats().getXp()-urLvl*10);
			fighter.pokemon.getStats().giveLvl(1);
			fighter.pokemon.getStats().setHp(fighter.pokemon.getStats().getMaxHp()-diff);
			}
		
		if(fighter.pokemon.getEvolutionLvl()<101 && fighter.pokemon.getEvolutionLvl()==fighter.pokemon.getStats().getLvl()) {
			Move[] pokemove=fighter.pokemon.getMoves();
			double xp = fighter.pokemon.getStats().getXp();
			fighter.pokemon=Pokemon.createPokemon(fighter.pokemon.getEvolution(), fighter.pokemon.getStats().getLvl()); //TODO la func da str a pkmn
			fighter.pokemon.getStats().setXp(xp);
			fighter.pokemon.setAllMoves(pokemove);
		}
		int m=0;
		if(i==0) {m=1;}
		this.setFighter(fighter.pokemon, fighter.team, i);
		this.fighter[m].opponent=fighter;
	}
	

}

