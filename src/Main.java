import pokemon.*;

import javax.swing.JFrame;

import battlemanager.*;
import frame.*;
import moves.*;
public class Main {

	public static void main(String[] args) {
//		new BackGroundFrame();
//		MenuGUI n=new MenuGUI();
//		new Atkmn(new Charmander(3),new Pikachu(3),1,true);
		//BattleGUI m1=new BattleGUI();
		//PokemonButtonBox x=new PokemonButtonBox();
		
	
		

		Team team0=new Team(
			new Pokemon[]{
					
			new Charizard(30),
			new Charmander(8),
			new Bulbasaur(6),
			new Charmander(5),
			new Charmander(8),
			new Bulbasaur(6)},"obamna");
		
		SafeManager.safeFile(team0);
//		
//		Team team1=new Team(
//				new Pokemon[]{
//				new Squirtle(30),
//				new Charmander(8),
//				new Bulbasaur(6),
//				new Charmander(5),
//				new Charmander(8),
//				new Bulbasaur(6)},"obamnius");
//		
//		BattleManager bm= new BattleManager(team0,team1);
//		
//		bm.turnOption(0, new Choice(Choice.Option.MOVE,1));
//		bm.turnOption(1, new Choice(Choice.Option.MOVE,1));
//	
//		bm.executeTurn();
//		bm.battleStatus();
		}

	
	}
	
	

