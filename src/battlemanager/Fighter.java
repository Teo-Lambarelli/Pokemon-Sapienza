package battlemanager; import pokemon.*;

public class Fighter {
	public Pokemon pokemon;
	public Team team;
	public Choice choice;
	public StatsChange statsChange;
	public Fighter opponent;
	
	public Fighter(Pokemon pokemon, Team team) {
		this.pokemon = pokemon;
		this.team = team;
		this.choice = null;
		this.statsChange = new StatsChange();
	}
}
