import pokemon.*; 
import battlemanager.*;
import moves.*;
public class Main {

	public static void main(String[] args) {
//		Charmander charmander=new Charmander(36);
//		
//		System.out.println(charmander.getMoves()[0]);
//		System.out.println(charmander.getMoves()[1]);
//		System.out.println(charmander.getMoves()[2]);
//		System.out.println(charmander.getMoves()[3]);
//		
//		System.out.println(charmander.REWARD_LVL);
//		System.out.println(charmander.getStats());
//		System.out.println(Move.AIR_SLASH);
//		
		
		Team team0=new Team(
			new Pokemon[]{
			new Charmander(5),
			new Charmander(8),
			new Bulbasaur(6),
			new Charmander(5),
			new Charmander(8),
			new Bulbasaur(6)});
		
		Team team1=new Team(
				new Pokemon[]{
				new Squirtle(5),
				new Charmander(8),
				new Bulbasaur(6),
				new Charmander(5),
				new Charmander(8),
				new Bulbasaur(6)});
		
		BattleManager bm= new BattleManager(team0,team1);
		
		bm.turnOption0(new Choice(Choice.Option.MOVE,0));
		bm.turnOption1(new Choice(Choice.Option.MOVE,1));
		
		
		
//		System.out.println(c1.sameOption(c2));

	
		bm.executeTurn();
		bm.battleStatus();
		}

	
	}
	
	

