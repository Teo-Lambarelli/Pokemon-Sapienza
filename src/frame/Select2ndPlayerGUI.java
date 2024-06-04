package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Select2ndPlayerGUI extends Frame{
	final static Color MAIN_COLOR =new Color(210, 220, 190);
	//final static ImageIcon BUTTON_TEXTURE=new ImageIcon(------);
	final static Color BUTTON_COLOR=new Color(54, 45, 62);
	final static Color BUTTON_BORDER=new Color(0,0,0);
	private String name;
	public Select2ndPlayerGUI(String name) {
        this.name=name;
        
        this.setLayout(new BorderLayout());
        // Imposta il layout del contenuto principale
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Aggiungi bordi neri ai lati
        mainPanel.setBorder(BorderFactory.createMatteBorder(0, 210, 0, 210,BUTTON_BORDER));
        mainPanel.setBackground(MAIN_COLOR);
        
        add(mainPanel);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(MAIN_COLOR); // Imposta il colore di sfondo utilizzando un valore esadecimale

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10); // margini tra i bottoni

        // Create buttons
        JButton newPlayerButton = new JButton("New 2nd Player");
        newPlayerButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BUTTON_BORDER, 4),
                BorderFactory.createEmptyBorder(5, 5, 5, 15)));
        newPlayerButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        
        
        JButton loadPlayerButton = new JButton("Load 2nd Player");
        loadPlayerButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BUTTON_BORDER, 4),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        loadPlayerButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        
        
        
        // Set preferred size to reduce button width
        Dimension buttonSize = new Dimension(350, 120); // larghezza e altezza desiderate
        Dimension exitSize = new Dimension(250, 90); // larghezza e altezza desiderate
        newPlayerButton.setPreferredSize(buttonSize);
        loadPlayerButton.setPreferredSize(buttonSize);


        // Add buttons to the panel
        buttonPanel.add(newPlayerButton, gbc);
        buttonPanel.add(loadPlayerButton, gbc);


        // Add action listeners to the buttons
        newPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new NewPlayerGUI(name);
            	dispose();
            	JOptionPane.showMessageDialog(null, "Team"+(NewPlayerGUI.player+1)+" is now choosing!");
            	
            }
        });

        loadPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//TODO
            	JOptionPane.showMessageDialog(null, "TODO");
            	
            }
        });

        // Add the button panel to the center of the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        this.setUndecorated(true); 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      //  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); TODO
        this.setLocationRelativeTo(null); // Centra la finestra
        this.setVisible(true);
        

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
    }}