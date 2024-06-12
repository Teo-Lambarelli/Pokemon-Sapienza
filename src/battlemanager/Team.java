package battlemanager; import java.util.ArrayList; import java.util.Arrays;

import pokemon.*;

/**
 * La classe Team rappresenta una squadra di Pokémon posseduta da un giocatore.
 */
public class Team {
    /** Lista dei Pokémon nella squadra. */
    protected ArrayList<Pokemon> pokemon;
    /** Numero massimo di Pokémon consentiti nella squadra. */
    public static final int MAX = 6;
    /** Nome del giocatore possidente della squadra. */
    protected String player_name;
    public int vittorie=0;
    public int sconfitte=0;
    public int partiteGiocate=0;
    public int turni=0;

    /**
     * Costruttore della classe Team.
     *
     * @param pokemon     Un array di Pokémon per inizializzare la squadra.
     * @param player_name Il nome del giocatore possidente della squadra.
     */
	public Team(Pokemon[] pokemon,String player_name) {
	
		
		if (pokemon.length>MAX) {
			this.pokemon=new ArrayList<Pokemon>(Arrays.asList(Arrays.copyOfRange(pokemon, 0, MAX)));
		}
		else {
			this.pokemon=new ArrayList<Pokemon>(Arrays.asList(pokemon));
		}
		
		this.player_name=player_name;
		
	}
	
	/**
     * Restituisce un array contenente tutti i Pokémon nella squadra.
     *
     * @return Un array di Pokémon.
     */
	public Pokemon[] getArrayTeam(){
		Pokemon[] array=new Pokemon[pokemon.size()];
		return pokemon.toArray(array);
	}
	
	/**
     * Restituisce il nome del giocatore possidente della squadra.
     *
     * @return Il nome del giocatore.
     */
	public String getName() {
		return player_name;
	}
	
	/**
     * Stampa le informazioni dei Pokémon presenti nella squadra.
     */
	public void printTeamInfo() {
		for (Pokemon elem:pokemon) {
			System.out.println(elem.getName());
		}
	}
	
	/**
     * Imposta un Pokémon nella squadra alla posizione specificata.
     *
     * @param poke  Il Pokémon da impostare.
     * @param index La posizione in cui impostare il Pokémon.
     */
	public void setPkmn(Pokemon poke, int index) {
		
		Pokemon[] pkmn=new Pokemon[pokemon.size()];
		pkmn=getArrayTeam();
		pkmn[index]=poke;
		this.pokemon=new ArrayList<Pokemon>(Arrays.asList(pkmn));
		
		
	}

}
