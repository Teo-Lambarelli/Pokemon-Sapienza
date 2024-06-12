package battlemanager; import pokemon.*; import moves.*; import java.util.ArrayList;

/**
 * La classe Fighter rappresenta un combattente in una battaglia Pokémon.
 */
public class Fighter {
    /** Il Pokémon del combattente. */
    public Pokemon pokemon;
    /** Il team a cui il combattente appartiene. */
    public Team team;
    /** La scelta attuale del combattente. */
    public Choice choice;
    /** Le modifiche statistiche del combattente. */
    public StatsChange statsChange;
    /** Il combattente avversario. */
    public Fighter opponent;

    /** La lista degli eventi attivi sul combattente. */
    public ArrayList<Event> event;

    /**
     * Crea un nuovo combattente con il Pokémon e il team specificati.
     *
     * @param pokemon Il Pokémon del combattente.
     * @param team    Il team a cui il combattente appartiene.
     */
    public Fighter(Pokemon pokemon, Team team) {
        this.pokemon = pokemon;
        this.team = team;
        this.choice = null;
        this.statsChange = new StatsChange();
    }

    /**
     * Verifica se il combattente ha un evento del tipo specificato.
     *
     * @param type Il tipo di evento da cercare.
     * @return True se il combattente ha un evento del tipo specificato, altrimenti False.
     */
    public boolean has(EventType type) {
        for (Event e : event)
            if (e.is(type))
                return true;
        return false;
    }

    /**
     * Passa il turno del combattente, rimuovendo gli eventi scaduti.
     */
    public void turnPass() {
        for (int i = event.size() - 1; i >= 0; i--) {
            if (event.get(i).pass() <= 0) {
                event.remove(i);
            }
        }
    }
}