package battlemanager; import java.util.ArrayList; import java.util.Arrays;

import pokemon.*;

public class Team {
	protected ArrayList<Pokemon> pokemon;
	private Pokemon[] pokemonArray;
	public static final int MAX = 6;
	protected String player_name;
	
	public Team(Pokemon[] pokemon,String player_name) {
		
		this.pokemonArray=pokemon;
		
		if (pokemon.length>6) {
			this.pokemon=new ArrayList<Pokemon>(Arrays.asList(Arrays.copyOfRange(pokemon, 0, MAX)));
		}
		else {
			this.pokemon=new ArrayList<Pokemon>(Arrays.asList(pokemon));
		}
		
		this.player_name=player_name;
		
	}
	
	public Pokemon[] getArrayTeam(){
		return pokemonArray;
	}
	
	
	public void printTeamInfo() {
		for (Pokemon elem:pokemon) {
			System.out.println(elem.getName());
		}
	}

}
