package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import battlemanager.*;
import moves.Move;
import pokemon.*;

public class NewPlayerGUI extends JFrame {
	protected int ct0=0;
	protected int ct1=0;
	protected Pokemon[] team0 = new Pokemon[Team.MAX];
	protected Pokemon[] team1 = new Pokemon[Team.MAX];
	public JPanel p=new JPanel();
	public JPanel p1=new JPanel();
	public JPanel p2=new JPanel();
	public JPanel p3=new JPanel();
    public NewPlayerGUI() {
        super("Pokemon Battle");
        
        // Configurazione della finestra principale
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centra la finestra

        p.setLayout(new GridLayout(4, 3)); // Disposizione a griglia 4x3
        p1.setLayout(new GridLayout(4, 3)); // Disposizione a griglia 4x3
        p2.setLayout(new GridLayout(4, 3)); // Disposizione a griglia 4x3
        p3.setLayout(new GridLayout(4, 3)); // Disposizione a griglia 4x3
        
        // Pannello principale con bordo e colore di sfondo
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createMatteBorder(0, 210, 0, 210, Color.BLACK));
        mainPanel.setBackground(new Color(210, 220, 190));
        mainPanel.setFocusable(true);
        mainPanel.requestFocusInWindow();
        mainPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });

        // Pannello per i pulsanti
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3)); // Disposizione a griglia 4x3
        buttonPanel.add(p);
        buttonPanel.add(p1);
        buttonPanel.add(p2);
        buttonPanel.add(p3);   

        // Creazione dei pulsanti
        for (int i = 0; i <= 11; i++) {
            JButton button = new JButton("" + i);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
            button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0,0,0), 4),
                    BorderFactory.createEmptyBorder(0, 0, 0, 15)));
            		button.setFont(new Font("Arial", Font.BOLD, 0));
                    switch (i) {
                    case 0: photoButton("src/frame/charmander.png",button);break;
                    case 1: photoButton("src/frame/squirtle.png",button);break;
                    case 2: photoButton("src/frame/bulbasaur.png",button);break;
                    case 3: photoButton("src/frame/charmander.png",button);break;	
                    case 4: photoButton("src/frame/charmander.png",button);break;
                    case 5: photoButton("src/frame/charmander.png",button);break;
                    case 6: photoButton("src/frame/charmander.png",button);break;
                    case 7: photoButton("src/frame/charmander.png",button);break;
                    case 8: photoButton("src/frame/charmander.png",button);break;
                    case 9: photoButton("src/frame/charmander.png",button);break;
                    case 10: photoButton("src/frame/charmander.png",button);break;
                    case 11: photoButton("src/frame/charmander.png",button);break;
                    default: break;
                }
        }
        
        // Aggiunta del pannello dei pulsanti al pannello principale
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        // Aggiunta del pannello principale alla finestra
        add(mainPanel, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    private void photoButton(String i, JButton button) {
       
        ImageIcon icon=new ImageIcon(i);
        Image image= icon.getImage();
        Image newimage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icon=new ImageIcon(newimage);
        button.setIcon(icon);
 
    }
    
    protected void selectedPokemon(Pokemon pokemon, int o) {
    	
        switch (pokemon.getName()) {
        case "Charmander": addSelection("src/frame/charmander.png",o);break;
        case "Squirtle": addSelection("src/frame/squirtle.png",o);break;
        case "Bulbasaur": addSelection("src/frame/bulbasaur.png",o);break;
//        case "3": return new Pikachu(5);break;
//        case "4": return new Eevee(5);break;
//        case "5": return new Jigglypuff(5);break;
//        case "6": return new Meowth(5);break;
//        case "7": return new Psyduck(5);break;
//        case "8": return new Machop(5);break;
//        case "9": return new Geodude(5);break;
//        case "10": return new Abra(5);break;
//        case "11": return new Gastly(5);break;
        default: break;
        }
    	
    }
    
    protected void addSelection(String i,int o) {
    	if(o==0) {
    	JLabel pippo= new JLabel();
    	ImageIcon icon=new ImageIcon(i);
        Image image= icon.getImage();
        Image newimage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icon=new ImageIcon(newimage);
        pippo.setIcon(icon);
        p.add(pippo);
        p.revalidate();
        p.repaint();
    	}
    	else {
    		JLabel pippo= new JLabel();
        	ImageIcon icon=new ImageIcon(i);
            Image image= icon.getImage();
            Image newimage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            icon=new ImageIcon(newimage);
            pippo.setIcon(icon);
            p3.add(pippo);
            p3.revalidate();
            p3.repaint();
    	}
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }
    // Listener per i pulsanti
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            
            switch (source.getText()) {
            case "0": addPokemon(new Charmander(5));break;
            case "1": addPokemon(new Squirtle(5));break;
            case "2": addPokemon(new Bulbasaur(5));break;
//            case "3": return new Pikachu(5);break;
//            case "4": return new Eevee(5);break;
//            case "5": return new Jigglypuff(5);break;
//            case "6": return new Meowth(5);break;
//            case "7": return new Psyduck(5);break;
//            case "8": return new Machop(5);break;
//            case "9": return new Geodude(5);break;
//            case "10": return new Abra(5);break;
//            case "11": return new Gastly(5);break;
            default: break;
            }
        }
            
            
            private void addPokemon(Pokemon pokemon) {
            if(ct0<Team.MAX) { if(ct0==0)
            	team0[ct0]=pokemon;
            	//JOptionPane.showMessageDialog(null, team0[ct0].getName()+ " has been added to team 1!");
            	selectedPokemon(pokemon,0);
            	ct0++;
            	if(ct0==6) {JOptionPane.showMessageDialog(null, "Team2 is now chosing!");}
            }
            else if(ct1<Team.MAX){ 
            	team0[ct1]=pokemon;
            	//JOptionPane.showMessageDialog(null, team0[ct1].getName()+ " has been added to team 2!");
            	selectedPokemon(pokemon,1);
            	ct1++;
            	if(ct1==6) {
            		JOptionPane.showMessageDialog(null, "Let's battle!");
            		Team BattleTeam0= new Team(team0);
            		Team BattleTeam1= new Team(team1);
            		BattleManager bg= new BattleManager(BattleTeam0,BattleTeam1);
                    new BattleGUI();
            	}
            }
        }
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        }
    }
    
}    
