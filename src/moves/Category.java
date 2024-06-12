package moves;

/**
 * Enumerazione che rappresenta le categorie dei movimenti dei Pokémon.
 * Le categorie sono SPECIAL, PHYSICAL e STATUS.
 */
public enum Category {
    /**
     * Movimenti speciali che causano danni basati sulla statistica Special Attack.
     */
    SPECIAL,
    
    /**
     * Movimenti fisici che causano danni basati sulla statistica Attack.
     */
    PHYSICAL,
    
    /**
     * Movimenti che non infliggono danni diretti, ma alterano le condizioni di gioco.
     */
    STATUS;
}