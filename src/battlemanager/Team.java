package battlemanager; import java.util.ArrayList; import java.util.Arrays;

import pokemon.*;

public class Team {
	protected ArrayList<Pokemon> pokemon;
	public static final int MAX = 6;
	protected String player_name;
	
	public Team(Pokemon[] pokemon,String player_name) {
	
		
		if (pokemon.length>6) {
			this.pokemon=new ArrayList<Pokemon>(Arrays.asList(Arrays.copyOfRange(pokemon, 0, MAX)));
		}
		else {
			this.pokemon=new ArrayList<Pokemon>(Arrays.asList(pokemon));
		}
		
		this.player_name=player_name;
		
	}
	
	public Pokemon[] getArrayTeam(){
		Pokemon[] array=new Pokemon[pokemon.size()];
		return pokemon.toArray(array);
	}
	
	public String getName() {
		return player_name;
	}
	
	public void printTeamInfo() {
		for (Pokemon elem:pokemon) {
			System.out.println(elem.getName());
		}
	}
	
	public void setPkmn(Pokemon poke, int index) {
		
		Pokemon[] pkmn=new Pokemon[pokemon.size()];
		pkmn=getArrayTeam();
		pkmn[index]=poke;
		this.pokemon=new ArrayList<Pokemon>(Arrays.asList(pkmn));
		
		
	}

}
