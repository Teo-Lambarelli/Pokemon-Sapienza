package moves;

/**
 * Questa enumerazione rappresenta gli effetti di stato che possono essere inflitti ai Pokémon durante una battaglia.
 * DEFAULT: Stato predefinito, indica l'assenza di un effetto di stato.
 * BURN: Indica che il Pokémon è bruciato e subirà danni ad ogni turno.
 * POISON: Indica che il Pokémon è avvelenato e subirà danni ad ogni turno.
 * BADLY_POISON: Indica che il Pokémon è gravemente avvelenato e subirà danni ad ogni turno in modo crescente.
 * FROZEN: Indica che il Pokémon è congelato e non può attaccare.
 * PARALYZED: Indica che il Pokémon è paralizzato e ha possibilità di non attaccare ogni turno.
 * ASLEEP: Indica che il Pokémon è addormentato e non può attaccare.
 */
public enum StatusEffect {
    DEFAULT,
    BURN,
    POISON,
    BADLY_POISON,
    FROZEN,
    PARALYZED,
    ASLEEP;
}