package pokemon; import types.Type; import moves.Move;
//import java.util.Random;

public abstract class Pokemon {
//	private boolean shiny=false;
	private String name;
	private Type type;
	private Type type2=null;

	
	
	Pokemon(String name, Type type, Type type2){
		this.name=name;
		this.type=type;
		this.type2=type2;
//		Random rand = new Random();
//        int randomNumber = rand.nextInt(4096);
//        if (randomNumber==1) {
//        	this.shiny=true;
//        }
	}
	
	Pokemon(String name, Type type){
		this.name=name;
		this.type=type;
//		Random rand = new Random();
//        int randomNumber = rand.nextInt(4096);
//        if (randomNumber==1) {
//        	this.shiny=true;
//        }
	}
	
	public void attack(Move move, Pokemon pokemon) {
		//TODO
	}
	protected class stats{
		int hp;
		int atk;
		int def;
		int satk;
		int sdef;
		int spd;
		
		stats(int atk, int satk, int def, int sdef, int spd, int hp){
			this.atk=atk;
			this.satk=satk;
			this.def=def;
			this.sdef=sdef;
			this.spd=spd;
			this.hp=hp;
		}
	}
}
