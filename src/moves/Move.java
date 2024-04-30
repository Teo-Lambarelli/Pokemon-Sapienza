package moves; import types.Type;

public enum Move {
	ACID(Type.POISON,40,100,"May lower opponent's Special Defense.",30,Category.SPECIAL),
	TOXIC(Type.POISON,0,90,"Badly poisons opponent.",10,Category.STATUS),
	POISON_FANG(Type.POISON,50,100,"May badly poison opponent.",15,Category.PHYSICAL);
	
	
	private final Type type;
	private final int dmg;
	private final int acc;
	private final String descr;
	private final int pp;
	private final Category cat;

    Move(Type type, int dmg, int acc, String descr, int pp, Category cat) {
        this.type=type;
        this.dmg=dmg;
        this.acc=acc;
        this.descr=descr;
        this.pp=pp;
        this.cat=cat;
    }
    
    public Type toType() {
    	return type;
    }
    
    @Override
    public String toString() {
        return name().charAt(0)+name().substring(1).toLowerCase();
    }

}
