import pokemon.*; 
import battlemanager.*;
import frame.BattleGUI;
import frame.MenuGUI;
import moves.*;
public class Main {

	public static void main(String[] args) {
		
		MenuGUI n=new MenuGUI();
		//BattleGUI m1=new BattleGUI();
		Team team0=new Team(
			new Pokemon[]{
			new Charmander(30),
			new Charmander(8),
			new Bulbasaur(6),
			new Charmander(5),
			new Charmander(8),
			new Bulbasaur(6)});
		
		Team team1=new Team(
				new Pokemon[]{
				new Squirtle(30),
				new Charmander(8),
				new Bulbasaur(6),
				new Charmander(5),
				new Charmander(8),
				new Bulbasaur(6)});
		
		BattleManager bm= new BattleManager(team0,team1);
		
		bm.turnOption(0, new Choice(Choice.Option.MOVE,1));
		bm.turnOption(1, new Choice(Choice.Option.MOVE,1));
	
		bm.executeTurn();
		bm.battleStatus();
		}

	
	}
	
	

