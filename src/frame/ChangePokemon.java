package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import battlemanager.BattleManager;
import battlemanager.Team;
import pokemon.Pokemon;

public class ChangePokemon extends JFrame {
    private Team team;
    private BattleManager bg;
    private int tm;
    private Team t;
    ChangePokemon(Team team, BattleManager bg, int tm, Team t) {
        this.team = team;
        this.bg=bg;
        this.tm=tm;
        this.team=t;
        
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
            	Pokemon[] p=new Pokemon[1];
            	
            	p[0]=team.getArrayTeam()[0];
            	team.setPkmn(team.getArrayTeam()[index],0);
            	team.setPkmn(p[0],index);
               	JOptionPane.showMessageDialog(null, "TODO "+(index+1));
//               	System.out.println(team.getArrayTeam()[0].getName());
               	if(tm==0) {bg.setTeam0(team); bg.setFighter(team.getArrayTeam()[0], team, tm);}
               	else if(tm==1) {bg.setTeam1(team); bg.setFighter(team.getArrayTeam()[0], team, tm);}
               	new BattleGUI(bg, tm);
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
