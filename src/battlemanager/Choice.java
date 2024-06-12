package battlemanager;

/**
 * La classe Choice rappresenta l'opzione scelta da un combattente durante una battaglia Pokémon.
 */
public class Choice {
    /** L'opzione scelta dall'utente. */
    public Option option;
    /** L'indice dell'opzione scelta. */
    public int index;

    /**
     * Crea un nuovo oggetto Choice con l'opzione specificata e l'indice associato.
     *
     * @param option L'opzione scelta.
     * @param index  L'indice dell'opzione scelta.
     */
    public Choice(Option option, int index) {
        this.option = option;
        this.index = index;
    }

    /**
     * Verifica se due scelte hanno la stessa opzione.
     *
     * @param choice La scelta da confrontare.
     * @return True se le scelte hanno la stessa opzione, altrimenti False.
     */
    public boolean sameOption(Choice choice) {
        return this.option == choice.option;
    }

    /**
     * Enumerazione che rappresenta le possibili opzioni di scelta.
     */
    public enum Option {
        /** L'opzione per eseguire un movimento. */
        MOVE,
        /** L'opzione per cambiare Pokémon. */
        SWITCH,
        /** L'opzione per fuggire dalla battaglia. */
        FLEE;
    }
}