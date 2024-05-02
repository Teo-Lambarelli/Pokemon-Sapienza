package moves; import types.Type;

public enum Move {
	TACKLE(Type.NORMAL, 40, 100, "None", 35, Category.PHYSICAL),
	HYPER_BEAM(Type.NORMAL, 150, 90, "User cannot move next turn.", 5, Category.SPECIAL),
	GROWL(Type.NORMAL, 0, 100, "Lowers opponent's Attack.", 40, Category.STATUS),
	SCRATCH(Type.NORMAL, 40, 100, "None", 35, Category.PHYSICAL),
	WHIP(Type.NORMAL, 50, 100, "None", 25, Category.SPECIAL),
	SMOKESCREEN(Type.NORMAL,0,100,"None",15,Category.STATUS),
	SLASH(Type.NORMAL,70,100,"None",20,Category.PHYSICAL),
	SCARY_FACE(Type.NORMAL,0,100,"None",25,Category.STATUS),
	LEER(Type.NORMAL,0,100,"Lowers opponent's Defense.",30,Category.STATUS),
	TAKE_DOWN(Type.NORMAL,90,85,"User receives recoil damage.",20,Category.PHYSICAL),
	GROWTH(Type.NORMAL,0,100,"Raises user's Attack and Special Attack.",20,Category.STATUS),
	SWEET_SCENT(Type.NORMAL,0,100,"Lowers opponent's Evasiveness.",20,Category.STATUS),
	TAIL_WHIP(Type.NORMAL,0,100,"Lowers opponent's Defense.",30,Category.STATUS),
	RAPID_SPIN(Type.NORMAL,50,100,"Raises user's Speed and removes entry hazards and trap move effects.",40,Category.PHYSICAL),
	SAFEGUARD(Type.NORMAL,0,100,"The user's party is protected from status conditions.",25,Category.STATUS),
	SKULL_BASH(Type.NORMAL,130,100,"Raises Defense on first turn, attacks on second.",10,Category.PHYSICAL),
	
    FLAMETHROWER(Type.FIRE, 90, 100, "May burn opponent.", 15, Category.SPECIAL),
    FIRE_BLAST(Type.FIRE, 110, 85, "May burn opponent.", 5, Category.SPECIAL),
    EMBER(Type.FIRE, 40, 100, "May burn opponent.", 25, Category.SPECIAL),
    FIRE_SPIN(Type.FIRE, 35, 85, "Traps opponent, damaging them for 2-5 turns.", 15, Category.SPECIAL),
    FIRE_PUNCH(Type.FIRE, 75, 100, "May burn opponent.", 15, Category.PHYSICAL),
    HEAT_WAVE(Type.FIRE,95,90,"None",15,Category.SPECIAL),
    FIRE_FANG(Type.FIRE,65,95,"None",20,Category.PHYSICAL),
    FLAME_BURST(Type.FIRE,70,100,"May also injure nearby Pokémon.",15,Category.SPECIAL),
    BLAZE_KICK(Type.FIRE, 85, 90, "High critical-hit ratio.", 10, Category.PHYSICAL),
    LAVA_PLUME(Type.FIRE, 80, 100, "May burn opponent.", 15, Category.SPECIAL),
    SACRED_FIRE(Type.FIRE, 100, 95, "May burn opponent.", 5, Category.PHYSICAL),

    SURF(Type.WATER, 90, 100, "Hits all adjacent Pokémon.", 15, Category.SPECIAL),
    HYDRO_PUMP(Type.WATER, 110, 80, "High critical-hit ratio.", 5, Category.SPECIAL),
    WATER_GUN(Type.WATER, 40, 100, "None", 25, Category.SPECIAL),
    WATERFALL(Type.WATER, 80, 100, "May cause flinching.", 15, Category.PHYSICAL),
    WITHDRAW(Type.WATER,0,100,"	Raises user's Defense.",40,Category.STATUS),
    WATER_PULSE(Type.WATER,60,100,"	May confuse opponent.",20,Category.SPECIAL),
    RAIN_DANCE(Type.WATER,0,100,"Makes it rain for 5 turns.",5,Category.STATUS),
    LIQUIDATION(Type.WATER, 85, 100, "May lower opponent's Defense.", 10, Category.PHYSICAL),
    SCALD(Type.WATER, 80, 100, "May burn opponent.", 15, Category.SPECIAL),
    AQUA_TAIL(Type.WATER, 90, 90, "None", 10, Category.PHYSICAL),
    WHIRLPOOL(Type.WATER, 35, 85, "Traps opponent, damaging them for 2-5 turns.", 15, Category.SPECIAL),

    VINE_WHIP(Type.GRASS, 45, 100, "None", 25, Category.PHYSICAL),
    SOLAR_BEAM(Type.GRASS, 120, 100, "Charges on first turn, attacks on second.", 10, Category.SPECIAL),
    RAZOR_LEAF(Type.GRASS, 55, 95, "High critical-hit ratio.", 25, Category.PHYSICAL),
    ENERGY_BALL(Type.GRASS, 90, 100, "May lower opponent's Special Defense.", 10, Category.SPECIAL),
    LEECH_SEED(Type.GRASS,0,90,"Drains HP from opponent each turn.",10,Category.STATUS),
    SLEEP_POWDER(Type.GRASS,0,75,"Puts opponent to sleep.",15,Category.STATUS),
    SYNTHESIS(Type.GRASS,0,100,"User recovers HP. Amount varies with the weather.",5,Category.STATUS),
    GIGA_DRAIN(Type.GRASS, 75, 100, "User recovers half the HP inflicted on opponent.", 10, Category.SPECIAL),
    PETAL_BLIZZARD(Type.GRASS, 110, 90, "None", 5, Category.PHYSICAL),
    BULLET_SEED(Type.GRASS, 25, 100, "Hits 2-5 times in one turn.", 30, Category.PHYSICAL),
    SEED_BOMB(Type.GRASS, 80, 100, "None", 15, Category.PHYSICAL),

    THUNDERBOLT(Type.ELECTRIC, 90, 100, "May paralyze opponent.", 15, Category.SPECIAL),
    THUNDER_WAVE(Type.ELECTRIC, 0, 90, "Paralyzes opponent.", 20, Category.STATUS),
    THUNDER_SHOCK(Type.ELECTRIC, 40, 100, "May paralyze opponent.", 30, Category.SPECIAL),
    THUNDER_STRIKE(Type.ELECTRIC, 95, 100, "High critical-hit ratio.", 10, Category.SPECIAL),
    THUNDER(Type.ELECTRIC, 110, 70, "May paralyze opponent.", 10, Category.SPECIAL),
    VOLT_SWITCH(Type.ELECTRIC, 70, 100, "User switches out after damaging the target.", 20, Category.SPECIAL),
    DISCHARGE(Type.ELECTRIC, 80, 100, "May paralyze opponent.", 15, Category.SPECIAL),
    THUNDER_PUNCH(Type.ELECTRIC, 75, 100, "May paralyze opponent.", 15, Category.PHYSICAL),
    ELECTRO_BALL(Type.ELECTRIC, -1, 100, "The faster the user is than the target, the greater the damage.", 10, Category.SPECIAL),
    ZAP_CANNON(Type.ELECTRIC, 120, 50, "Paralyzes opponent.", 5, Category.SPECIAL),
    SHOCK_WAVE(Type.ELECTRIC, 60, 100, "Ignores Accuracy and Evasiveness.", 20, Category.SPECIAL),
   
    ICE_BEAM(Type.ICE, 90, 100, "May freeze opponent.", 10, Category.SPECIAL),
    BLIZZARD(Type.ICE, 110, 70, "May freeze opponent.", 5, Category.SPECIAL),
    ICE_PUNCH(Type.ICE, 75, 100, "May freeze opponent.", 15, Category.PHYSICAL),
    ICE_AGE(Type.ICE, 95, 100, "High critical-hit ratio.", 10, Category.SPECIAL),
    AURORA_BEAM(Type.ICE, 65, 100, "May lower opponent's Attack.", 20, Category.SPECIAL),
    FROST_BREATH(Type.ICE, 60, 90, "Always results in a critical hit.", 10, Category.SPECIAL),
    FREEZE_DRY(Type.ICE, 70, 100, "Super effective against Water types. May freeze opponent.", 15, Category.SPECIAL),
    ICICLE_SPEAR(Type.ICE, 25, 100, "Hits 2-5 times in one turn.", 30, Category.PHYSICAL),
    AVALANCHE(Type.ICE, 60, 100, "Power doubles if user is damaged by the target.", 10, Category.PHYSICAL),
    ICE_SHARD(Type.ICE, 40, 100, "User attacks first.", 30, Category.PHYSICAL),
    HAIL(Type.ICE, 0, 100, "Non-Ice types are damaged for 5 turns.", 10, Category.STATUS),
    MIST(Type.ICE, 0, 100, "Protects user's stats from being changed by opponent.", 30, Category.STATUS),
  
    PSYCHIC(Type.PSYCHIC, 90, 100, "May lower opponent's Special Defense.", 10, Category.SPECIAL),
    PSYCHIC_RAY(Type.PSYCHIC, 95, 100, "High critical-hit ratio.", 10, Category.SPECIAL),
    PSYCHIC_WARD(Type.PSYCHIC, 110, 70, "May lower opponent's Special Defense.", 10, Category.SPECIAL),
    CONFUSION(Type.PSYCHIC, 50, 100, "May confuse opponent.", 25, Category.SPECIAL),
    PSYCHO_CUT(Type.PSYCHIC, 70, 100, "High critical-hit ratio.", 20, Category.PHYSICAL),
    FUTURE_SIGHT(Type.PSYCHIC, 120, 100, "Damage occurs 2 turns later.", 10, Category.SPECIAL),
    PSYBEAM(Type.PSYCHIC, 65, 100, "May confuse opponent.", 20, Category.SPECIAL),
    ZEN_HEADBUTT(Type.PSYCHIC, 80, 90, "May cause flinching.", 15, Category.PHYSICAL),
    PSYSHOCK(Type.PSYCHIC, 80, 100, "Deals damage based on the target's Defense, not Special Defense.", 10, Category.SPECIAL),
    EXTRASENSORY(Type.PSYCHIC, 80, 100, "May cause flinching.", 20, Category.SPECIAL),
    MIRACLE_EYE(Type.PSYCHIC, 0, 100, "Enables a Ghost-type target to be hit by Normal- and Fighting-type attacks.", 40, Category.STATUS),
    PSYCH_UP(Type.PSYCHIC, 0, 100, "Copies the target's stat changes.", 10, Category.STATUS),

    SHADOW_BALL(Type.GHOST, 80, 100, "May lower opponent's Special Defense.", 15, Category.SPECIAL),
    SHADOWFLAME(Type.GHOST, 85, 100, "High critical-hit ratio.", 10, Category.SPECIAL),
    LICK(Type.GHOST, 30, 100, "May paralyze opponent.", 30, Category.PHYSICAL),
    NIGHT_SHADE(Type.GHOST, 0, 100, "Inflicts damage equal to user's level.", 15, Category.SPECIAL),
    DREAM_EATER(Type.GHOST, 100, 100, "User recovers 50% of damage dealt.", 15, Category.SPECIAL),
    HEX(Type.GHOST, 65, 100, "Deals double damage if the target has a status condition.", 10, Category.SPECIAL),
    SHADOW_CLAW(Type.GHOST, 70, 100, "High critical-hit ratio.", 15, Category.PHYSICAL),
    CURSE(Type.GHOST, 0, 100, "User loses half its max HP. Ghosts lose half their max HP, too.", 10, Category.STATUS),
    NIGHTMARE(Type.GHOST, 0, 100, "Target loses 1/4 its max HP every turn as long as it's asleep.", 15, Category.STATUS),
    GRUDGE(Type.GHOST, 0, 100, "If the user faints, the Pokémon that landed the knockout hit also faints.", 5, Category.STATUS),
    SHADOW_PUNCH(Type.GHOST, 60, 100, "Ignores Accuracy and Evasiveness.", 20, Category.PHYSICAL),
    CAMORRA(Type.GHOST, 0, 100, "User loses half its max HP. Ghosts lose half their max HP, too.", 10, Category.STATUS),

    DRAGON_RAGE(Type.DRAGON, 40, 100, "Always inflicts 40 HP.", 10, Category.SPECIAL),
    TWISTER(Type.DRAGON, 40, 100, "May cause flinching.", 20, Category.SPECIAL),
    OUTRAGE(Type.DRAGON, 120, 100, "Confuses user after 2-3 turns.", 10, Category.PHYSICAL),
    DRAGON_BREATH(Type.DRAGON, 60, 100, "May paralyze opponent.", 20, Category.SPECIAL),
    DRAGON_CLAW(Type.DRAGON,80,100,"None",20,Category.PHYSICAL),
    DRAGON_DANCE(Type.DRAGON, 0, 100, "Raises user's Attack and Speed.", 20, Category.STATUS),
    DRAGON_PULSE(Type.DRAGON, 85, 100, "None", 10, Category.SPECIAL),
    DRAGON_TAIL(Type.DRAGON, 60, 90, "Forces opponent to switch to a random ally.", 10, Category.PHYSICAL),
    DRAGON_RUSH(Type.DRAGON, 100, 75, "May cause flinching.", 10, Category.PHYSICAL),
    DRAGONHAMMER(Type.DRAGON, 90, 100, "None", 15, Category.PHYSICAL),
    DRACO_METEOR(Type.DRAGON, 130, 90, "Lowers user's Special Attack.", 5, Category.SPECIAL),
    DRAGON_PEWPEW(Type.DRAGON, 85, 100, "None", 10, Category.SPECIAL),

    SLUDGE_BOMB(Type.POISON, 90, 100, "May poison opponent.", 10, Category.SPECIAL),
    SLUDGE(Type.POISON, 65, 100, "May poison opponent.", 20, Category.SPECIAL),
    SLUDGE_WAVE(Type.POISON, 95, 100, "May poison opponent.", 10, Category.SPECIAL),
    ACID(Type.POISON, 40, 100, "May lower opponent's Special Defense.", 30, Category.SPECIAL),
    POISON_JAB(Type.POISON, 80, 100, "May poison opponent.", 20, Category.PHYSICAL),
    POISON_POWDER(Type.POISON,0,75,"Poisons opponent.",35,Category.STATUS),
    TOXIC_SPIKES(Type.POISON, 0, -1, "Lays a trap of poison spikes.", 20, Category.STATUS),
    GUNK_SHOT(Type.POISON, 120, 80, "May poison opponent.", 5, Category.PHYSICAL),
    BELCH(Type.POISON, 120, 90, "Can be used only after the user has eaten a Berry.", 10, Category.SPECIAL),
    ACID_SPRAY(Type.POISON, 40, 100, "Lowers opponent's Special Defense.", 20, Category.SPECIAL),
    VENOSHOCK(Type.POISON, 65, 100, "Inflicts double damage if the target is poisoned.", 10, Category.SPECIAL),

    EARTHQUAKE(Type.GROUND, 100, 100, "Hits all adjacent Pokémon.", 10, Category.PHYSICAL),
    DIG(Type.GROUND, 80, 100, "Digs underground turn 1, strikes turn 2.", 10, Category.PHYSICAL),
    BONE_CLUB(Type.GROUND, 65, 85, "May cause flinching.", 20, Category.PHYSICAL),
    MUD_SLAP(Type.GROUND, 20, 100, "Lowers opponent's accuracy.", 10, Category.SPECIAL),
    EARTH_POWER(Type.GROUND, 90, 100, "May lower opponent's Special Defense.", 10, Category.SPECIAL),
    BULLDOZE(Type.GROUND, 60, 100, "Lowers opponent's Speed.", 20, Category.PHYSICAL),
    MAGNITUDE(Type.GROUND, -1, 100, "Magnitude varies between 4 and 10.", 30, Category.PHYSICAL),
    SAND_TOMB(Type.GROUND, 35, 85, "Traps opponent, damaging them for 4-5 turns.", 15, Category.PHYSICAL),
    DRILL_RUN(Type.GROUND, 80, 95, "High critical-hit ratio.", 10, Category.PHYSICAL),
    EARTHCRUMBLE(Type.GROUND, 100, 100, "Hits all adjacent Pokémon.", 10, Category.PHYSICAL),
    MUD_BOMB(Type.GROUND, 65, 85, "May lower opponent's accuracy.", 10, Category.SPECIAL),
	
	BITE(Type.GROUND,60,100,"May cause flinching.",25,Category.PHYSICAL),
    CRUNCH(Type.DARK, 80, 100, "May lower opponent's Defense.", 15, Category.PHYSICAL),
    DARK_PULSE(Type.DARK, 80, 100, "May cause flinching.", 15, Category.SPECIAL),
    NIGHT_SLASH(Type.DARK, 70, 100, "High critical-hit ratio.", 15, Category.PHYSICAL),
    FOUL_PLAY(Type.DARK, 95, 100, "Uses target's Attack stat.", 15, Category.PHYSICAL),
    SNARL(Type.DARK, 55, 95, "Lowers opponent's Special Attack.", 15, Category.SPECIAL),
    DARK_VOID(Type.DARK, 0, 80, "Puts opponent to sleep.", 10, Category.STATUS),
    NASTY_PLOT(Type.DARK, 0, 100, "Raises user's Special Attack.", 20, Category.STATUS),
    BEAT_UP(Type.DARK, 0, 100, "Each Pokémon in user's party attacks.", 10, Category.PHYSICAL),
    HONE_CLAWS(Type.DARK, 0, 100, "Raises user's Attack and Accuracy.", 15, Category.STATUS),
    KNOCK_OFF(Type.DARK, 65, 100, "None", 20, Category.PHYSICAL),
	
	IRON_DEFENCE(Type.STEEL,0,100,"Sharply raises user's Defense.",15,Category.STATUS),
    METAL_CLAW(Type.STEEL, 50, 95, "May raise user's Attack.", 35, Category.PHYSICAL),
    IRON_HEAD(Type.STEEL, 80, 100, "May cause flinching.", 15, Category.PHYSICAL),
    STEEL_WING(Type.STEEL, 70, 90, "May raise user's Defense.", 25, Category.PHYSICAL),
    FLASH_CANNON(Type.STEEL, 80, 100, "May lower opponent's Special Defense.", 10, Category.SPECIAL),
    HEAVY_SLAM(Type.STEEL, -1, 100, "The heavier the user, the stronger the attack.", 10, Category.PHYSICAL),
    METAL_BURST(Type.STEEL, -1, 100, "If hit by an attack, returns double the damage.", 10, Category.PHYSICAL),
    IRON_DEFENSE(Type.STEEL, 0, 100, "Sharply raises user's Defense.", 15, Category.STATUS),
    AUTOTOMIZE(Type.STEEL, 0, 100, "Raises user's Speed and lowers its weight.", 15, Category.STATUS),
    SHIFT_GEAR(Type.STEEL, 0, 100, "Raises user's Attack and sharply raises its Speed.", 10, Category.STATUS),
    KINGSSHIELD(Type.STEEL, 0, 100, "Protects user from damaging moves. Contact: lowers attacker's Attack stat.", 10, Category.STATUS);
	
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
    
    public Type getType() {
    	return type;
    }
    
    public int getDmg() {
    	return dmg;
    }
    
    public int getAcc() {
    	return acc;
    }
    
    public String getDescr() {
    	return descr;
    }
    
    public int getPp() {
    	return pp;
    }
    
    public Category getCat() {
    	return cat;
    }
    
    @Override
    public String toString() {
        return (name().charAt(0)+name().substring(1).toLowerCase()).replace("_", " ");
    }
    
    public Move toMove(String move) {
    	move=move.toUpperCase().replace(" ", "_");
    	for (Move m:Move.values()) {
    		if(m.toString().equals(move)) {
    			return m;
    		}
    	}
    	return null;
    }

}
