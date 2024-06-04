package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import battlemanager.BattleManager;
import battlemanager.Choice;
import battlemanager.Team;
import pokemon.Pokemon;

public class ChangePokemon extends JFrame {
    private Team team;
    private BattleManager bg;
    private int tm; //quale team sta cambiando 0 o 1

    ChangePokemon(BattleManager bg, int tm) {
        this.team = team;
        if (tm==0) {this.team=bg.getTeam0();}
        if (tm==1) {this.team=bg.getTeam1();}
        this.bg=bg;
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
            button.setText(team.getArrayTeam()[i].getStats().getHp()+"/"+team.getArrayTeam()[i].getStats().getMaxHp()+"Hp");
            button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0,0,0), 4),
                    BorderFactory.createEmptyBorder(0, 0, 0, 15)));
            		button.setFont(new Font("Arial", Font.BOLD, 15));
            		final int index=i;
           button.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

               	bg.turnOption(tm, new Choice(Choice.Option.SWITCH,index));
               	
               	if (tm==0) {new BattleGUI(bg,1);dispose();}
               	
               	if(tm==1 && bg.getFighter()[0].choice!=null && bg.getFighter()[1].choice!=null) {;bg.executeTurn();}
               	
               	dispose();
               }
               
           });
           
        }
        
        
        // Aggiunta di mainPanel2 a mainPanel
        mainPanel1.add(mainPanel2, BorderLayout.CENTER);
        mainPanel.add(mainPanel1);
        // Aggiunta di mainPanel al frame
        add(mainPanel);
    }
}
