package battlemanager; import pokemon.*;

public class StatsChange {
	protected double atk;
	protected double def;
	protected double satk;
	protected double sdef;
	protected double spd;
	protected double accuracy;
	protected double evasion;
	
	static final double MIN_STAT = -6;
	static final double MAX_STAT = 6;
	
	static final double PERCENT_STACK = 12.5;
	static final double PERCENT_MIN = -75;
	static final double PERCENT_MAX = 75;
	
	public StatsChange () {
		statsReset();
	}
	
	public void statsReset() {
		this.atk=0;
		this.def=0;
		this.sdef=0;
		this.satk=0;
		this.spd=0;
		this.accuracy=0;
		this.evasion=0;
	}
	
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

}
