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
	protected static int player;
	protected int ct0=0;
	protected boolean cp=false; //controllo pokemon
	protected boolean cn=false; //controllo nome
	protected Pokemon[] team0 = new Pokemon[Team.MAX];
	//protected Pokemon[] team1 = new Pokemon[Team.MAX];
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
        

        
        
        
        
        p.add(new JPanel());
        JTextField inputField = new JTextField();
        inputField.setBounds(50, 50, 200, 30);
        inputField.setFont(new Font("Arial", Font.BOLD, 15));
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0), 4),
                BorderFactory.createEmptyBorder(0, 0, 0, 15)));
        p.add(inputField);
        
        JButton submitButton = new JButton("Choose your name!");
        submitButton.setBounds(270, 50, 80, 30);
        submitButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0), 4),
                BorderFactory.createEmptyBorder(0, 0, 0, 15)));
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        p.add(submitButton);
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ottenere il testo dall'inputField e visualizzarlo nell'etichetta
                String userInput = inputField.getText();
                cn=true;
                if(cp==true && cn==true) {
            		//TODO
                	
                	JOptionPane.showMessageDialog(null, "squadra finitpTODOnext");
            		System.out.println("finiscisquadra");
            	}
            }
        });
    
        
        
        
        
        
        
        // Pannello per i pulsanti
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3)); // Disposizione a griglia 4x3
//        for (int i = 0; i <= 3; i++) {
//        	buttonPanel.add(new JPanel());
//        }
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
                    case 0: photoButton("src/sprites/charmander.png",button);break;
                    case 1: photoButton("src/sprites/squirtle.png",button);break;
                    case 2: photoButton("src/sprites/bulbasaur.png",button);break;
                    case 3: photoButton("src/sprites/charmander.png",button);break;	
                    case 4: photoButton("src/sprites/charmander.png",button);break;
                    case 5: photoButton("src/sprites/charmander.png",button);break;
                    case 6: photoButton("src/sprites/charmander.png",button);break;
                    case 7: photoButton("src/sprites/charmander.png",button);break;
                    case 8: photoButton("src/sprites/charmander.png",button);break;
                    case 9: photoButton("src/sprites/charmander.png",button);break;
                    case 10: photoButton("src/sprites/charmander.png",button);break;
                    case 11: photoButton("src/sprites/charmander.png",button);break;
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
    
    protected void selectedPokemon(Pokemon pokemon) {
    	
        switch (pokemon.getName()) {
        case "Charmander": addSelection("src/sprites/charmander.png");break;
        case "Squirtle": addSelection("src/sprites/squirtle.png");break;
        case "Bulbasaur": addSelection("src/sprites/bulbasaur.png");break;
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
    
    protected void addSelection(String i) {
    	
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
            if(ct0<Team.MAX) { 
            	team0[ct0]=pokemon;
            	//JOptionPane.showMessageDialog(null, team0[ct0].getName()+ " has been added to team 1!");
            	selectedPokemon(pokemon);
            	ct0++;
            	if(ct0==6) {
            		cp=true;//JOptionPane.showMessageDialog(null, "Team2 is now choosing!");}
            	}
            	if(cp==true && cn==true) {
            		//TODO
            		JOptionPane.showMessageDialog(null, "squadra finitpTODOnext");
            		System.out.println("finiscisquadra");
            	}
            }
//            else if(ct1<Team.MAX){ 
//            	team1[ct1]=pokemon;
//            	//JOptionPane.showMessageDialog(null, team0[ct1].getName()+ " has been added to team 2!");
//            	selectedPokemon(pokemon,1);
//            	ct1++;
//            	if(ct1==6) {
//            		JOptionPane.showMessageDialog(null, "Let's battle!");
//            		Team BattleTeam0= new Team(team0);
            		//Team BattleTeam1= new Team(team1);
            	   // BattleManager bg= new BattleManager(BattleTeam0,BattleTeam1);
                  //  new BattleGUI(bg);//TODO
                 //   dispose();

                   
              //}
            }
        }
   
            
        
    }
    