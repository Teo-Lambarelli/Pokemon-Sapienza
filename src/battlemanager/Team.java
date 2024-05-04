package battlemanager; import java.util.ArrayList; import java.util.Arrays;

import pokemon.*;

public class Team {
	protected ArrayList<Pokemon> pokemon;
	public static final int MAX = 6;
	protected String player_name;
	
	public Team(Pokemon[] pokemon) {
		;
		
		if (pokemon.length>6) {
			this.pokemon=new ArrayList<Pokemon>(Arrays.asList(Arrays.copyOfRange(pokemon, 0, MAX)));
		}
		else {
			this.pokemon=new ArrayList<Pokemon>(Arrays.asList(pokemon));
		}
		
		
	}
	
	
	public void printTeamInfo() {
		for (Pokemon elem:pokemon) {
			System.out.println(elem.getName());
		}
	}

}
