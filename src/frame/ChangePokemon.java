package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import battlemanager.BattleManager;
import battlemanager.Choice;
import battlemanager.Team;
import pokemon.Pokemon;

/**
 * La classe ChangePokemon rappresenta l'interfaccia grafica per la selezione di un nuovo Pokémon durante una battaglia.
 * Permette ai giocatori di scegliere un Pokémon dalla loro squadra per sostituire uno sconfitto o ferito.
 */
public class ChangePokemon extends JFrame {

    /** La squadra del giocatore. */
    private Team team;

    /** Il gestore della battaglia Pokémon. */
    private BattleManager bg;

    /** Indica quale squadra sta cambiando Pokémon (0 per la prima squadra, 1 per la seconda). */
    private int tm;

    /** Flag che indica se il Pokémon da cambiare è morto. */
    private boolean deadpkmn;

    /**
     * Costruttore della classe ChangePokemon.
     *
     * @param bg Il gestore della battaglia Pokémon.
     * @param tm Indica quale squadra sta cambiando Pokémon (0 per la prima squadra, 1 per la seconda).
     * @param deadpkmn Flag che indica se il Pokémon da cambiare è morto.
     */
    ChangePokemon(BattleManager bg, int tm, boolean deadpkmn) {
        this.team = team;
        if (tm==0) {this.team=bg.getTeam0();}
        if (tm==1) {this.team=bg.getTeam1();}
        this.bg=bg;
        this.deadpkmn=deadpkmn;
        this.tm=tm;
        

        
        this.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createMatteBorder(0, 210, 0, 210, Color.BLACK));

        
        add(mainPanel);
        this.setUndecorated(true); 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        
        
        
        
        // Creazione del mainPanel e configurazione del layout
        JPanel mainPanel1 = new JPanel(new BorderLayout());
        mainPanel1.setBorder(BorderFactory.createMatteBorder(30, 65, 30, 65, new Color(210, 220, 190)));
        
        
        
        
        JPanel mainPanel2 = new JPanel(new GridLayout(3, 2));
        
        
        // Aggiunta delle immagini dei Pokemon
        for (int i=0;i<team.getArrayTeam().length;i++) {
        	JButton button=new JButton();
            ImageIcon icon=new ImageIcon(team.getArrayTeam()[i].getFrontSprite());
            Image image= icon.getImage();
            Image newimage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            icon=new ImageIcon(newimage);
            button.setIcon(icon);
            mainPanel2.add(button);
            button.setText((String.format("%.2f", team.getArrayTeam()[i].getStats().getHp()))+"/"+(String.format("%.2f", team.getArrayTeam()[i].getStats().getMaxHp()))+"Hp");
            button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0,0,0), 4),
                    BorderFactory.createEmptyBorder(0, 0, 0, 15)));
            		button.setFont(new Font("Arial", Font.BOLD, 15));
            		final int index=i;
            		if (team.getArrayTeam()[i].getStats().getHp()<0) {button.setText("Dead");}
            		else {
           button.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

            	if (deadpkmn==true) {
            		
            		bg.turnOption(tm, new Choice(Choice.Option.SWITCH,index));
            		bg.executeAction(bg.getFighter()[tm]);
            		bg.turnOption(tm, null);
            		bg.setFighter(bg.getFighter()[tm].pokemon, bg.getFighter()[tm].team, tm);

            		new BattleGUI(bg,0);dispose();}
            	else {
               	bg.turnOption(tm, new Choice(Choice.Option.SWITCH,index));
 
               	if (tm==0) {new BattleGUI(bg,1);dispose();}
               	
               	if(tm==1) {;bg.executeTurn();}
               	
               	dispose();
            	}
               }
               
           });
           
        }}
        
        
        // Aggiunta di mainPanel2 a mainPanel
        mainPanel1.add(mainPanel2, BorderLayout.CENTER);
        mainPanel.add(mainPanel1);
        // Aggiunta di mainPanel al frame
        add(mainPanel);
    }
}
