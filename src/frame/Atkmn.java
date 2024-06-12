package frame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import battlemanager.BattleManager;
import battlemanager.Fighter;
import pokemon.Pokemon;

/**
 * La classe Atkmn estende JFrame e rappresenta una finestra in cui vengono visualizzati
 * e animati gli attacchi dei Pokémon durante una battaglia.
 */
public class Atkmn extends JFrame {

    private String sprite0;
    private String sprite1;
    private Pokemon pokemon0;
    private Pokemon pokemon1;
    private boolean another;
    private Fighter fighter0;
    private Fighter fighter1;
    private BattleManager bg;
    boolean cbg;
    private int i;
    private int c = 60;
    private BackgroundPanel p = new BackgroundPanel(image);
    private final static ImageIcon icon = new ImageIcon("src/sprites/atkanm.png");
    private final static Image image = icon.getImage();

    /**
     * Costruttore della classe Atkmn.
     *
     * @param fighter0 Il primo combattente.
     * @param fighter1 Il secondo combattente.
     * @param i Indice dell'attacco.
     * @param another Flag per determinare se avviare un'altra animazione.
     * @param bg Il gestore della battaglia.
     * @param cbg Flag per determinare se avviare la GUI della battaglia.
     */
    public Atkmn(Fighter fighter0, Fighter fighter1, int i, boolean another, BattleManager bg, boolean cbg) {
        this.bg = bg;
        this.cbg = cbg;
        this.pokemon0 = fighter0.pokemon;
        this.pokemon1 = fighter1.pokemon;
        this.fighter0 = fighter0;
        this.fighter1 = fighter1;
        this.another = another;
        this.sprite0 = pokemon0.getBackSprite();
        this.sprite1 = pokemon1.getFrontSprite();
        fighter1.opponent = fighter0;
        fighter0.opponent = fighter1;
        JLabel s0 = new JLabel();
        JLabel s1 = new JLabel();

        JLabel pokeStats0 = new JLabel(pokemon0.getName() + "     lvl:" + pokemon0.getStats().getLvl() + "     hp:" + (String.format("%.2f", pokemon0.getStats().getHp())));
        JLabel pokeStats1 = new JLabel(pokemon1.getName() + "     lvl:" + pokemon1.getStats().getLvl() + "     hp:" + (String.format("%.2f", pokemon1.getStats().getHp())));
        pokeStats0.setSize(400, 400);
        pokeStats0.setFont(new Font("Arial", Font.BOLD, 20));
        pokeStats1.setSize(400, 400);
        pokeStats1.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel p000 = new JPanel();
        p000.setOpaque(false);
        p000.setBounds(400, 118, 600, 600);

        JPanel p001 = new JPanel();
        p001.setOpaque(false);
        p001.setBounds(1020, 20, 500, 500);

        JPanel p002 = new JPanel();
        p002.setOpaque(false);
        p002.setBounds(190, 207, 500, 500);
        p002.add(pokeStats1);
        add(p002);

        JPanel p003 = new JPanel();
        p003.setOpaque(false);
        p003.setBounds(1200, 470, 500, 500);
        p003.add(pokeStats0);
        add(p003);

        ImageIcon ic0 = new ImageIcon(sprite0);
        Image ima0 = ic0.getImage();
        Image scaledImag0 = ima0.getScaledInstance(750, 820, Image.SCALE_SMOOTH);
        ImageIcon scaledIco0 = new ImageIcon(scaledImag0);
        s0.setIcon(scaledIco0);

        ImageIcon ic = new ImageIcon(sprite1);
        Image ima = ic.getImage();
        Image scaledImag = ima.getScaledInstance(350, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIco = new ImageIcon(scaledImag);
        s1.setIcon(scaledIco);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opp = 0;
                boolean deathCheck = false;
                if (c < 100) {
                    c++;
                } else if (c >= 100 && c <= 115) {
                    c++;
                    if (i == 0) {
                        p000.setLocation(600, 20);
                    }
                    if (i == 1) {
                        p001.setLocation(800, 100);
                    }
                } else if (c > 115 && c <= 134) {
                    if (i == 0) {
                        p000.setLocation(400, 118);
                    }
                    if (i == 1) {
                        p001.setLocation(1020, 20);
                    }
                    c++;
                } else if (c == 135) {

                    if (i == 0) {
                    	
                        bg.executeAttack(fighter0);
                        bg.setFighter(fighter1.pokemon, fighter1.team, 1);

                        if (fighter0.opponent.pokemon.getStats().getHp() <= 0) {
                            deathCheck = true;
                            pokeDeath(fighter0);
                            bg.checkXp(fighter0, 0);
                            opp = 1;
                        }

                        p003.revalidate();
                        p003.repaint();
                        p002.revalidate();
                        p002.repaint();

                    }

                    if (i == 1) {
                    	
                        bg.executeAttack(fighter1);
                        bg.setFighter(fighter0.pokemon, fighter0.team, 0);
                    }

                    if (fighter1.opponent.pokemon.getStats().getHp() <= 0) {
                        deathCheck = true;
                        pokeDeath(fighter1);
                        bg.checkXp(fighter1, 1);
                        opp = 0;
                    }

                    p003.revalidate();
                    p003.repaint();
                    p002.revalidate();
                    p002.repaint();

                    int m = 0;
                    if (i == 0) {
                        m = 1;
                    }

                    if (!deathCheck) {
                        if (another) {
                            new Atkmn(fighter0, fighter1, m, false, bg, true);
                        } else if (another==false && cbg) {
                            new BattleGUI(bg, 0);
                        }
                    } 
                    else {
                        new ChangePokemon(bg, opp, true);
                    }

                    c++;
                } 
                else {
                    dispose();
                }
            }
        });
        timer.start(); // Avvia il timer

        p001.add(s1);
        p000.add(s0);
        this.add(p000);
        this.add(p001);
        this.add(p);
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
    }

    /**
     * Gestisce la morte di un Pokémon.
     *
     * @param l'opponent del pkmn morto.
     */
    public void pokeDeath(Fighter fighter) {
        BattleGUI.bGUI.dispose();
        boolean win = true;
        for (Pokemon pkmn : fighter.opponent.team.getArrayTeam()) {
            if (pkmn.getStats().getHp() > 0) {
                win = false;
            }
        }
        if (win && fighter.team.turni==2) {
            dispose();
            fighter.team.partiteGiocate=+1;
            fighter.opponent.team.partiteGiocate=+1;
            fighter.team.vittorie=+1;
            fighter.opponent.team.sconfitte=+1;
            new End(fighter.team, fighter.opponent.team);
           
        }
        else if(win) {
        	
        	fighter.team.turni+=1;
        	fighter.opponent.team.turni+=1;
        	
        	for (Pokemon pkmn:fighter.team.getArrayTeam()) {pkmn.getStats().updateStats();}
        	for (Pokemon pkmn:fighter.opponent.team.getArrayTeam()) {pkmn.getStats().updateStats();}
        	BattleManager c=new BattleManager(fighter.team,fighter.opponent.team);
        	new BattleGUI(c,0);
        	dispose();
        }
    }
}
	
	

