package battlemanager; import pokemon.*;

public class StatsChange {
	protected double atk;
	protected double def;
	protected double satk;
	protected double sdef;
	protected double spd;
	protected double accuracy;
	protected double evasion;
	
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
		this.accuracy=0;
	}

}
