package frame;

import java.awt.*;
import javax.swing.*;

import battlemanager.Team;
import pokemon.Pokemon;

public class ChangePokemon extends JFrame {
    private Team team;

    ChangePokemon(Team team) {
        this.team = team;
        
        
        
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
        
//        // Creazione di due pannelli interni
//        JPanel p0 = new JPanel();
//        p0.setBackground(new Color(210, 220, 190));
//        JPanel p1 = new JPanel();
//        p1.setBackground(new Color(210, 220, 190));
//        
//        // Aggiunta dei pannelli interni a mainPanel2
//        mainPanel2.add(p0);
//        mainPanel2.add(p1);

        // Aggiunta delle immagini dei Pokemon
        for (Pokemon p : team.getArrayTeam()) {
        	JButton button=new JButton();
            ImageIcon icon=new ImageIcon(p.getFrontSprite());
            Image image= icon.getImage();
            Image newimage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            icon=new ImageIcon(newimage);
            button.setIcon(icon);
            mainPanel2.add(button);
            button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0,0,0), 4),
                    BorderFactory.createEmptyBorder(0, 0, 0, 15)));
            		button.setFont(new Font("Arial", Font.BOLD, 0));
        }
        
        // Aggiunta di mainPanel2 a mainPanel
        mainPanel1.add(mainPanel2, BorderLayout.CENTER);
        mainPanel.add(mainPanel1);
        // Aggiunta di mainPanel al frame
        add(mainPanel);
    }
}