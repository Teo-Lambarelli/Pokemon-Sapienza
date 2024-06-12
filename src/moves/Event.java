package moves;

/**
 * Classe che rappresenta un evento in un combattimento Pokémon, come un effetto di status o una condizione temporanea.
 */
public class Event {
	private int turns_remaining;
	public EventType type;
	
	/**
     * Costruttore per un nuovo evento.
     * 
     * @param type Il tipo di evento
     * @param turns Il numero di turni per cui l'evento deve durare
     */
	public Event(EventType type, int turns) {
		turns_remaining = turns;
		this.type = type;
	}
	
	 /**
     * Ottiene il numero di turni rimanenti per l'evento.
     * 
     * @return Il numero di turni rimanenti
     */
	public int getTurns() {
		return turns_remaining;
	}
	
	/**
     * Imposta il numero di turni rimanenti per l'evento.
     * 
     * @param turns Il numero di turni da impostare
     */
	public void setTurns(int turns) {
		turns_remaining = turns;
	}
	
    /**
     * Riduce di uno il numero di turni rimanenti per l'evento.
     * 
     * @return Il numero di turni rimanenti dopo la riduzione
     */
	public int pass() {
		return --turns_remaining;
	}
	
	  /**
     * Verifica se l'evento è dello stesso tipo di un altro evento.
     * 
     * @param type Il tipo di evento da confrontare
     * @return True se i tipi di evento corrispondono, altrimenti false
     */
	public boolean is(EventType type) {
		return (this.type == type);
	}
}
