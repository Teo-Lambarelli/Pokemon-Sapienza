package types;

/**
 * Enumerazione che rappresenta i tipi dei Pokémon.
 */
public enum Type {
	NORMAL(0),
	FIRE(1),
	WATER(2),
	GRASS(3),
	ELECTRIC(4),
	ICE(5),
	FIGHTING(6),
	POISON(7),
	GROUND(8),
	FLYING(9),
	PSYCHIC(10),
	BUG(11),
	ROCK(12),
	GHOST(13),
	DRAGON(14),
	DARK(15),
	STEEL(16),
	FAIRY(17);
	
	
	private final int value;

    /**
     * Costruttore privato per inizializzare il valore del tipo.
     * @param value Il valore intero associato al tipo.
     */
    Type(int value) {
        this.value=value;
    }

    /**
     * Restituisce il valore numerico associato al tipo.
     * @return Il valore numerico del tipo.
     */
    public int getValue() {
        return value;
    }
    

}
