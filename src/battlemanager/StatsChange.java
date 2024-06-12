package battlemanager; import pokemon.*;

/**
 * La classe StatsChange gestisce le modifiche statistiche di un Pokémon durante una battaglia.
 */
public class StatsChange {
    /** Modifica dell'attacco. */
    protected double atk;
    /** Modifica della difesa. */
    protected double def;
    /** Modifica dell'attacco speciale. */
    protected double satk;
    /** Modifica della difesa speciale. */
    protected double sdef;
    /** Modifica della velocità. */
    protected double spd;
    /** Modifica dell'accuratezza. */
    protected double accuracy;
    /** Modifica dell'evasione. */
    protected double evasion;
    /** Modifica del tasso di criticità. */
    protected int critical;

    /** Valore minimo che può assumere una statistica. */
    static final double MIN_STAT = -6;
    /** Valore massimo che può assumere una statistica. */
    static final double MAX_STAT = 6;

    /** Percentuale di incremento o decremento delle statistiche. */
    static final double PERCENT_STACK = 12.5;
    /** Percentuale minima che può assumere una statistica. */
    static final double PERCENT_MIN = -75;
    /** Percentuale massima che può assumere una statistica. */
    static final double PERCENT_MAX = 75;

    /** Tasso di probabilità di critico per ogni livello di criticità. */
    static final int[] CRITICAL_CHANCE = {24, 8, 2};
    /** Massimo livello di criticità. */
    static final int CRITICAL_MAX = 3;
	
	public StatsChange () {
		statsReset();
	}
	
    /**
     * Costruttore della classe StatsChange.
     * Inizializza tutte le modifiche statistiche a zero.
     */
	public void statsReset() {
		this.atk=0;
		this.def=0;
		this.sdef=0;
		this.satk=0;
		this.spd=0;
		this.accuracy=0;
		this.evasion=0;
		this.critical = 0;
	}
	
	/**
     * Applica una modifica all'attacco del Pokémon.
     *
     * @param bonus L'incremento o il decremento da applicare.
     * @return True se il valore massimo o minimo è stato raggiunto, altrimenti False.
     */
	public boolean bonusAtk(int bonus) {
		atk += bonus;
		if (atk > MAX_STAT) {
			atk = MAX_STAT;
			return true;
		}
		else if (atk < MIN_STAT) {
			atk = MIN_STAT;
			return true;
		}
		return false;
	}
	
	/**
     * Applica una modifica alla difesa del Pokémon.
     *
     * @param bonus L'incremento o il decremento da applicare.
     * @return True se il valore massimo o minimo è stato raggiunto, altrimenti False.
     */
	public boolean bonusDef(int bonus) {
		def += bonus;
		if (def > MAX_STAT) {
			def = MAX_STAT;
			return true;
		}
		else if (def < MIN_STAT) {
			def = MIN_STAT;
			return true;
		}
		return false;
	}
	
	/**
     * Applica una modifica all'attacco speciale del Pokémon.
     *
     * @param bonus L'incremento o il decremento da applicare.
     * @return True se il valore massimo o minimo è stato raggiunto, altrimenti False.
     */
	public boolean bonusSatk(int bonus) {
		satk += bonus;
		if (satk > MAX_STAT) {
			satk = MAX_STAT;
			return true;
		}
		else if (satk < MIN_STAT) {
			satk = MIN_STAT;
			return true;
		}
		return false;
	}
	
	/**
     * Applica una modifica alla difesa speciale del Pokémon.
     *
     * @param bonus L'incremento o il decremento da applicare.
     * @return True se il valore massimo o minimo è stato raggiunto, altrimenti False.
     */
	public boolean bonusSdef(int bonus) {
		sdef += bonus;
		if (sdef > MAX_STAT) {
			sdef = MAX_STAT;
			return true;
		}
		else if (sdef < MIN_STAT) {
			sdef = MIN_STAT;
			return true;
		}
		return false;
	}
	
	/**
     * Applica una modifica alla velocità del Pokémon.
     *
     * @param bonus L'incremento o il decremento da applicare.
     * @return True se il valore massimo o minimo è stato raggiunto, altrimenti False.
     */
	public boolean bonusSpd(int bonus) {
		spd += bonus;
		if (spd > MAX_STAT) {
			spd = MAX_STAT;
			return true;
		}
		else if (spd < MIN_STAT) {
			spd = MIN_STAT;
			return true;
		}
		return false;
	}
	
	/**
     * Applica una modifica alla precisione del Pokémon.
     *
     * @param bonus L'incremento o il decremento da applicare.
     * @return True se il valore massimo o minimo è stato raggiunto, altrimenti False.
     */
	public boolean bonusAccuracy(int bonus) {
		accuracy += bonus * PERCENT_STACK;
		if (accuracy > PERCENT_MAX) {
			accuracy = PERCENT_MAX;
			return true;
		}
		else if (accuracy < PERCENT_MIN) {
			accuracy = PERCENT_MIN;
			return true;
		}
		return false;
	}
	
	/**
     * Applica una modifica all'elusione del Pokémon.
     *
     * @param bonus L'incremento o il decremento da applicare.
     * @return True se il valore massimo o minimo è stato raggiunto, altrimenti False.
     */
	public boolean bonusEvasion(int bonus) {
		evasion += bonus * PERCENT_STACK;
		if (evasion > PERCENT_MAX) {
			evasion = PERCENT_MAX;
			return true;
		}
		else if (evasion < PERCENT_MIN) {
			evasion = PERCENT_MIN;
			return true;
		}
		return false;
	}
	
	/**
     * Applica una modifica al critico del Pokémon.
     *
     * @param bonus L'incremento o il decremento da applicare.
     * @return True se il valore massimo o minimo è stato raggiunto, altrimenti False.
     */
	public boolean bonusCritical(int bonus) {
		critical += bonus;
		if (critical > CRITICAL_MAX) {
			critical = CRITICAL_MAX;
			return true;
		}
		return false;
	}
	
	/**
     * Restituisce la probabilità di critico in base al livello di criticità corrente.
     *
     * @return La probabilità di critico.
     */
	public int getCritChance() {
		if (critical >= CRITICAL_CHANCE.length)
			return 1;
		if (critical < 0)
			return CRITICAL_CHANCE[0];
		return CRITICAL_CHANCE[critical];
	}

}
