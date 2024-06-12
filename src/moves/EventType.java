package moves;

/**
 * Enumerazione che rappresenta i diversi tipi di eventi possibili in un combattimento Pokémon.
 */
public enum EventType {
    RAINY,       // Pioggia: modificatore per mosse e abilità
    SUNNY,       // Sole: modificatore per mosse e abilità
    TRAPPED,     // Intrappolato: impedisce la fuga dal combattimento
    CONFUSED,    // Confuso: possibilità di colpire se stessi durante un attacco
    SEEDING,     // Semina: infligge danni residui ad un Pokémon avversario
    FIRE_SPIN;   // Turbine di Fuoco: infligge danni multipli in più turni
}