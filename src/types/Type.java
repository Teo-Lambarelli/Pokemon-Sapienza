package types;

public enum Type {
	FIRE(0),
	WATER(1),
	GRASS(2),
	ELECTRIC(3),
	ICE(4),
	POISON(5),
	GROUND(6);
	
	private final int value;

    Type(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return name().charAt(0)+name().substring(1).toLowerCase();
    }
}
