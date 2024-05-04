package battlemanager;

public class Choice {
	public Option option;
	public int index;
	
	public Choice(Option option, int index) {
		this.option=option;
		this.index=index;	
	}
	 
	
	public boolean sameOption(Choice choice) {
		if(this.option==choice.option) {
			return true;
		}
		return false;
	}
	
	

	public enum Option{
		MOVE,
		SWITCH,
		FLEE;
	}

}
