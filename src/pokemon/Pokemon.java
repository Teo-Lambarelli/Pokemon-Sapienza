package pokemon; import types.Type; import moves.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

/**
 * La classe astratta Pokemon rappresenta un Pokemon nel gioco.
 * Ogni istanza di Pokemon ha attributi come nome, statistiche, mosse, tipo, sprite e altri.
 */
public abstract class Pokemon {
    /** Nome dello sprite frontale del Pokemon. */
    public final String FRONTSPRITE;

    /** Nome dello sprite posteriore del Pokemon. */
    public final String BACKSPRITE;

    /** Statistiche del Pokemon. */
    private Stats stats;

    /** Mosse del Pokemon. */
    private Move[] moves;

    /** Punti di potenza delle mosse del Pokemon. */
    private int[] pp;

    /** Nome del Pokemon. */
    private String name;

    /** Primo tipo del Pokemon. */
    private Type type0;

    /** Secondo tipo del Pokemon. */
    private Type type1 = null;

    /** Mappa delle mosse ottenibili al raggiungimento di determinati livelli. */
    private final Map<Integer, Move> REWARD_LVL;

    /** Mosse peculiari del Pokemon. */
    private final Map<Integer, Move> PECULIARMOVES;

    /** Nome dell'evoluzione del Pokemon. */
    private final String evolution;

    /** Livello di evoluzione del Pokemon. */
    private final int evolutionlvl;

    /** Abilità del Pokemon. */
    private Ability ability;

    /** Effetto di stato attuale del Pokemon. */
    private StatusEffect STATUS_EFFECT;

    /** Numero massimo di mosse per un Pokemon. */
    public final static int MAX_MOVES = 4;
    
    /**
     * Costruttore per la creazione di un Pokemon con due tipi.
     * @param name Nome del Pokemon
     * @param type0 Primo tipo del Pokemon
     * @param type1 Secondo tipo del Pokemon
     * @param REWARD_LVL Mappa dei movimenti ottenibili al raggiungimento di determinati livelli
     * @param baseHp Statistica base dei punti salute
     * @param baseAtk Statistica base dell'attacco
     * @param baseDef Statistica base della difesa
     * @param baseSatk Statistica base dell'attacco speciale
     * @param baseSdef Statistica base della difesa speciale
     * @param baseSpd Statistica base della velocità
     * @param lvl Livello del Pokemon
     * @param xp Esperienza del Pokemon
     * @param ability Abilità del Pokemon
     * @param PECULIARMOVES Mosse peculiari del Pokemon
     * @param FRONTSPRITE Nome dello sprite frontale del Pokemon
     * @param BACKSPRITE Nome dello sprite posteriore del Pokemon
     * ci sono sono altri 7 costruttori per le varie possibilità
     */
	Pokemon(String name, Type type0, Type type1, Map<Integer, Move> REWARD_LVL, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp,Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.type1=type1;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL; 
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.PECULIARMOVES=PECULIARMOVES;
		generateMoves();
		this.evolution=null;
		this.evolutionlvl=101;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
		resetPP();
        }
        
	Pokemon(String name, Type type0, Map<Integer, Move> REWARD_LVL, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp,Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);	
		this.PECULIARMOVES=PECULIARMOVES;
		generateMoves();
		this.evolution=null;
		this.evolutionlvl=101;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
		resetPP();
        }
	
	Pokemon(String name, Type type0, Type type1, Map<Integer, Move> REWARD_LVL, Move[] moves, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp,Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.type1=type1;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.moves=moves;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.evolution=null;
		this.evolutionlvl=101;
		this.PECULIARMOVES=PECULIARMOVES;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
		resetPP();
        }
	
	Pokemon(String name, Type type0, Map<Integer, Move> REWARD_LVL,Move[] moves, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.moves=moves;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);	
		this.evolution=null;
		this.evolutionlvl=101;
		this.PECULIARMOVES=PECULIARMOVES;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
		resetPP();
        }
	
	Pokemon(String name, Type type0, Type type1, Map<Integer, Move> REWARD_LVL, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp,String evolution, int evolutionlvl, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.type1=type1;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.PECULIARMOVES=PECULIARMOVES;
		generateMoves();
		this.evolution=evolution;
		this.evolutionlvl=evolutionlvl;
		
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
		resetPP();
        }
        
	Pokemon(String name, Type type0, Map<Integer, Move> REWARD_LVL, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp, String evolution, int evolutionlvl, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.PECULIARMOVES=PECULIARMOVES;
		generateMoves();
		this.evolution=evolution;
		this.evolutionlvl=evolutionlvl;
		
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
		resetPP();
        }
	
	Pokemon(String name, Type type0, Type type1, Map<Integer, Move> REWARD_LVL, Move[] moves, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp, String evolution, int evolutionlvl, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.type1=type1;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.moves=moves;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);
		this.evolution=evolution;
		this.evolutionlvl=evolutionlvl;
		this.PECULIARMOVES=PECULIARMOVES;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
		resetPP();
        }
	
	Pokemon(String name, Type type0, HashMap<Integer, Move> REWARD_LVL,Move[] moves, double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd,int lvl,int xp, String evolution, int evolutionlvl, Ability ability,Map<Integer, Move> PECULIARMOVES,String FRONTSPRITE,String BACKSPRITE){
		this.name=name;
		this.type0=type0;
		this.moves=new Move[MAX_MOVES];
		this.REWARD_LVL=REWARD_LVL;
		this.moves=moves;
		this.stats=new Stats(baseHp,baseAtk,baseDef,baseSatk,baseSdef,baseSpd,lvl,xp);	
		this.evolution=evolution;
		this.evolutionlvl=evolutionlvl;
		this.PECULIARMOVES=PECULIARMOVES;
		this.STATUS_EFFECT=StatusEffect.DEFAULT;
		this.FRONTSPRITE=FRONTSPRITE;
		this.BACKSPRITE=BACKSPRITE;
		resetPP();
        }
	
    /**
     * Genera le mosse del Pokemon in base al suo livello.
     */
	public void generateMoves() {
		int counter=0;
		if (PECULIARMOVES!=null) {
			for (int i=0; i<PECULIARMOVES.size() && counter<4; i++) {
				moves[counter]=PECULIARMOVES.get(i);
				
				counter++;
			}
		}
		
		for(int i=this.stats.lvl; i>0 && counter<4; i--) {
			if(REWARD_LVL.containsKey(i)) {
				moves[counter]=REWARD_LVL.get(i);
				counter++;
			}
			
			
		}

	}
	
	  /**
     * Reimposta i punti di potenza delle mosse del Pokemon.
     */
	public void resetPP() {
		pp = new int[MAX_MOVES];
		for (int i = 0; i < MAX_MOVES; i++)
			if (moves[i] != null)
				pp[i] = moves[i].getPp();
	}
	
	
	
    /**
     * Restituisce la mappa contenente i movimenti appresi dal Pokemon a determinati livelli.
     * @return La mappa dei movimenti appresi del Pokemon.
     */
    public Map<Integer, Move> getRewardLvl(){
        return REWARD_LVL;
    }
    
    /**
     * Restituisce il nome del Pokemon.
     * @return Il nome del Pokemon.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Restituisce il tipo primario del Pokemon.
     * @return Il tipo primario del Pokemon.
     */
    public Type getType0() { 
        return type0;
    }
    
    /**
     * Restituisce il tipo secondario del Pokemon.
     * @return Il tipo secondario del Pokemon, se presente.
     */
    public Type getType1() {
        return type1;
    }
    
    /**
     * Restituisce l'effetto di stato del Pokemon.
     * @return L'effetto di stato attuale del Pokemon.
     */
    public StatusEffect getStatusEffect() {
        return STATUS_EFFECT;
    }
    
    /**
     * Restituisce lo sprite frontale del Pokemon.
     * @return Il percorso dello sprite frontale del Pokemon.
     */
    public String getFrontSprite() {
        return FRONTSPRITE;
    }
    
    /**
     * Restituisce lo sprite posteriore del Pokemon.
     * @return Il percorso dello sprite posteriore del Pokemon.
     */
    public String getBackSprite() {
        return BACKSPRITE;
    }
    
    /**
     * Restituisce le statistiche base del Pokemon.
     * @return Le statistiche base del Pokemon.
     */
    public Stats getStats() {
        return stats;
    }
    
    /**
     * Restituisce l'array dei movimenti del Pokemon.
     * @return L'array dei movimenti del Pokemon.
     */
    public Move[] getMoves() {
        return moves;
    }
    
    /**
     * Restituisce il nome dell'evoluzione successiva del Pokemon.
     * @return Il nome dell'evoluzione successiva del Pokemon.
     */
    public String getEvolution() {
        return evolution;
    }
    
    /**
     * Restituisce il livello richiesto per l'evoluzione del Pokemon.
     * @return Il livello richiesto per l'evoluzione del Pokemon.
     */
    public int getEvolutionLvl() {
        return evolutionlvl;
    }
    
    /**
     * Imposta il nome del Pokemon.
     * @param name Il nome da impostare per il Pokemon.
     */
    public void setName(String name) {
        this.name=name;
    }
    
    /**
     * Imposta un movimento specifico del Pokemon in una determinata posizione.
     * @param move Il movimento da impostare.
     * @param index La posizione in cui impostare il movimento.
     */
    public void setOneMove(Move move, int index) {
        this.moves[index]=move;
    }
    
    /**
     * Imposta tutti i movimenti del Pokemon contemporaneamente.
     * @param moves L'array dei movimenti da impostare per il Pokemon.
     */
    public void setAllMoves(Move[] moves) {
        this.moves=moves;
    }
    
    /**
     * Imposta il tipo primario del Pokemon.
     * @param type0 Il tipo primario da impostare per il Pokemon.
     */
    public void setType0(Type type0) {
        this.type0=type0;
    }
    
    /**
     * Imposta il tipo secondario del Pokemon.
     * @param type1 Il tipo secondario da impostare per il Pokemon.
     */
    public void setType1(Type type1) {
        this.type1=type1;
    }
    
    /**
     * Imposta l'effetto di stato del Pokemon.
     * @param STATUS_EFFECT L'effetto di stato da impostare per il Pokemon.
     */
    public void setStatusEffect(StatusEffect STATUS_EFFECT) {
        this.STATUS_EFFECT=STATUS_EFFECT;
    }
    
    /**
     * Riduce i punti salute del Pokemon di una certa quantità.
     * @param dmg La quantità di danni da infliggere al Pokemon.
     */
    public void damage(double dmg) {
        this.getStats().setHp(this.getStats().getHp()-dmg);
    }
    
    /**
     * Aumenta i punti salute del Pokemon di una certa quantità.
     * @param hl La quantità di salute da aggiungere al Pokemon.
     */
    public void heal(double hl) {
        this.getStats().setHp(this.getStats().getHp()+hl);
    }
    
    /**
     * Restituisce i punti potenza (PP) di un determinato movimento del Pokemon.
     * @param i La posizione del movimento all'interno dell'array dei movimenti.
     * @return I punti potenza (PP) del movimento specificato.
     */
    public int getPP(int i) {
        return pp[i];
    }
    
    /**
     * Imposta i punti potenza (PP) di un determinato movimento del Pokemon.
     * @param pp I punti potenza (PP) da impostare per il movimento.
     * @param i La posizione del movimento all'interno dell'array dei movimenti.
     */
    public void setPP(int pp, int i) {
        this.pp[i] = pp;
    }
	
    /**
     * Classe interna che rappresenta le statistiche di base del Pokemon.
     */
    public class Stats {
        /** Punti esperienza del Pokemon. */
        private double xp;
        
        /** Livello del Pokemon. */
        private int lvl;
        
        /** Statistica base dei punti salute del Pokemon. */
        private double baseHp;
        
        /** Statistica base dell'attacco del Pokemon. */
        private double baseAtk;
        
        /** Statistica base della difesa del Pokemon. */
        private double baseDef;
        
        /** Statistica base dell'attacco speciale del Pokemon. */
        private double baseSatk;
        
        /** Statistica base della difesa speciale del Pokemon. */
        private double baseSdef;
        
        /** Statistica base della velocità del Pokemon. */
        private double baseSpd;
        
        /** Massimi punti salute del Pokemon. */
        private double maxHp;

        /** Attuali punti salute del Pokemon. */
        private double hp;
        
        /** Attacco del Pokemon. */
        private double atk;
        
        /** Difesa del Pokemon. */
        private double def;
        
        /** Attacco speciale del Pokemon. */
        private double satk;
        
        /** Difesa speciale del Pokemon. */
        private double sdef;
        
        /** Velocità del Pokemon. */
        private double spd;
    
		

		private Stats(double baseHp, double baseAtk, double baseDef, double baseSatk, double baseSdef, double baseSpd, int lvl,double xp){
			this.xp=xp;
			this.lvl=lvl;
			this.baseAtk=baseAtk;
			this.baseSatk=baseSatk;
			this.baseDef=baseDef;
			this.baseSdef=baseSdef;
			this.baseSpd=baseSpd;
			this.baseHp=baseHp;
			updateStats();
			//yay!
			
		}
		
        /**
         * Aggiorna le statistiche del Pokemon in base al suo livello attuale.
         * Questo metodo calcola i punti salute, attacco, difesa, attacco speciale,
         * difesa speciale e velocità del Pokemon utilizzando le sue statistiche di base
         * e il suo livello attuale.
         */
        public void updateStats() {
            // Calcola i punti salute del Pokemon
            hp = (baseHp * lvl / 50) + 10 + lvl;
            // Calcola l'attacco del Pokemon
            atk = (baseAtk * lvl / 50) + 5;
            // Calcola la difesa del Pokemon
            def = (baseDef * lvl / 50) + 5;
            // Calcola l'attacco speciale del Pokemon
            satk = (baseSatk * lvl / 50) + 5;
            // Calcola la difesa speciale del Pokemon
            sdef = (baseSdef * lvl / 50) + 5;
            // Calcola la velocità del Pokemon
            spd = (baseSpd * lvl / 50) + 5;
            // Imposta i punti salute massimi del Pokemon
            maxHp = hp;
        }
        
        
        /**
         * Restituisce i punti esperienza del Pokemon.
         * @return I punti esperienza del Pokemon.
         */
        public double getXp() {
            return xp;
        }
		
        /**
         * Restituisce il livello del Pokemon.
         * @return Il livello del Pokemon.
         */
        public int getLvl() {
            return lvl;
        }
		
        /**
         * Incrementa il livello del Pokemon di un certo valore.
         * @param i Il valore da aggiungere al livello del Pokemon.
         */
        public void giveLvl(int i) {
            lvl += i;
        }
		
        /**
         * Restituisce i punti salute base del Pokemon.
         * @return I punti salute base del Pokemon.
         */
        public double getBaseHp() {
            return baseHp;
        }
		
        /**
         * Restituisce l'attacco base del Pokemon.
         * @return L'attacco base del Pokemon.
         */
        public double getBaseAtk() {
            return baseAtk;
        }
		
        /**
         * Restituisce l'attacco speciale base del Pokemon.
         * @return L'attacco speciale base del Pokemon.
         */
        public double getBaseSatk() {
            return baseSatk;
        }
		
        /**
         * Restituisce la difesa base del Pokemon.
         * @return La difesa base del Pokemon.
         */
        public double getBaseDef() {
            return baseDef;
        }
		
        /**
         * Restituisce la difesa speciale base del Pokemon.
         * @return La difesa speciale base del Pokemon.
         */
        public double getBaseSdef() {
            return baseSdef;
        }
		
        /**
         * Restituisce la velocità base del Pokemon.
         * @return La velocità base del Pokemon.
         */
        public double getBaseSpd() {
            return baseSpd;
        }
		
        /**
         * Restituisce i punti salute attuali del Pokemon.
         * @return I punti salute attuali del Pokemon.
         */
        public double getHp() {
            return hp;
        }
        
        /**
         * Restituisce l'attacco attuale del Pokemon.
         * @return L'attacco attuale del Pokemon.
         */
        public double getAtk() {
            return atk;
        }
        
        /**
         * Restituisce l'attacco speciale attuale del Pokemon.
         * @return L'attacco speciale attuale del Pokemon.
         */
        public double getSatk() {
            return satk;
        }
		
        /**
         * Restituisce la difesa attuale del Pokemon.
         * @return La difesa attuale del Pokemon.
         */
        public double getDef() {
            return def;
        }
		
        /**
         * Restituisce la difesa speciale attuale del Pokemon.
         * @return La difesa speciale attuale del Pokemon.
         */
        public double getSdef() {
            return sdef;
        }
		
        /**
         * Restituisce la velocità attuale del Pokemon.
         * @return La velocità attuale del Pokemon.
         */
        public double getSpd() {
            return spd;
        } 	
		
        /**
         * Restituisce i punti salute massimi del Pokemon.
         * @return I punti salute massimi del Pokemon.
         */
        public double getMaxHp() {
            return maxHp;
        }
		
        /**
         * Imposta i punti salute massimi del Pokemon.
         * @param maxHp I punti salute massimi del Pokemon da impostare.
         */
        public void setMaxHp(double maxHp) {
            this.maxHp=maxHp;
        }

        /**
         * Imposta i punti salute attuali del Pokemon.
         * @param hp I punti salute attuali del Pokemon da impostare.
         */
        public void setHp(double hp) {
            this.hp=hp;
        }
		
        /**
         * Imposta l'attacco attuale del Pokemon.
         * @param atk L'attacco attuale del Pokemon da impostare.
         */
        public void setAtk(double atk) {
            this.atk=atk;
        }
		
        public void setSatk(double satk) {
            this.satk=satk;
        }
        
        /**
         * Imposta la difesa attuale del Pokemon.
         * @param def La difesa attuale del Pokemon da impostare.
         */
        public void setDef(double def) {
            this.def=def;
        }
        
        /**
         * Imposta la difesa speciale attuale del Pokemon.
         * @param sdef La difesa speciale attuale del Pokemon da impostare.
         */
        public void setSdef(double sdef) {
            this.sdef=sdef;
        }
        
        /**
         * Imposta la velocità attuale del Pokemon.
         * @param spd La velocità attuale del Pokemon da impostare.
         */
        public void setSpd(double spd) {
            this.spd=spd;
        }        
        
        /**
         * Imposta i punti esperienza del Pokemon.
         * @param xp I punti esperienza del Pokemon da impostare.
         */
        public void setXp(double xp) {
            this.xp=xp;
        }
        
        /**
         * Aggiunge una certa quantità di punti esperienza al Pokemon.
         * @param xp I punti esperienza da aggiungere al Pokemon.
         */
        public void giveXp(double xp) {
            this.xp+=xp;
        }
		
	}
	
    /**
     * Crea un'istanza di Pokemon con il tipo specificato e il livello specificato.
     * @param type Tipo del Pokemon
     * @param level Livello del Pokemon
     * @return Un'istanza di Pokemon con il tipo e il livello specificati
     */
	public static Pokemon createPokemon(String type, int level) {
        try {
            String packageName = Pokemon.class.getPackage().getName();
            String className = packageName + "." + type;
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(int.class);
            return (Pokemon) constructor.newInstance(level);
        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo di Pokemon non riconosciuto: " + type, e);
        }
    }
}
