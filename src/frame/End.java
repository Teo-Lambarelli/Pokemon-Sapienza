package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import JPokeBattle.SafeManager;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import battlemanager.Team;

/**
 * La classe End rappresenta l'interfaccia grafica che compare alla fine della battaglia Pokémon.
 * Permette ai giocatori di concludere la partita e salvare i progressi.
 */
public class End extends JFrame {

    /** Il colore principale utilizzato nell'interfaccia grafica. */
    final static Color MAIN_COLOR = new Color(210, 220, 190);

    /** Il colore dei pulsanti. */
    final static Color BUTTON_COLOR = new Color(54, 45, 62);

    /** Il colore del bordo dei pulsanti. */
    final static Color BUTTON_BORDER = new Color(0, 0, 0);

    /** La squadra del primo giocatore. */
    private Team team0;

    /** La squadra del secondo giocatore. */
    private Team team1;

    /**
     * Costruttore della classe End.
     *
     * @param team0 La squadra del primo giocatore.
     * @param team1 La squadra del secondo giocatore.
     */
	    public End(Team team0, Team team1) {
	        this.team0=team0;
	        this.team1=team1;
	        this.setLayout(new BorderLayout());
	        // Imposta il layout del contenuto principale
//	        JPanel mainPanel = new JPanel();
//	        mainPanel.setLayout(new BorderLayout());
	        ImageIcon icon = new ImageIcon("src/sprites/ni2.png");
	        Image image = icon.getImage();
	        BackgroundPanel mainPanel = new BackgroundPanel(image);
	        mainPanel.setLayout(new BorderLayout());
	        
	        
	        // Aggiungi bordi neri ai lati
	        mainPanel.setBorder(BorderFactory.createMatteBorder(0, 210, 0, 210, Color.BLACK));
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
	        JButton finish = new JButton("Finish and save");
	        finish.setBorder(BorderFactory.createCompoundBorder(
	                BorderFactory.createLineBorder(BUTTON_BORDER, 4),
	                BorderFactory.createEmptyBorder(5, 5, 5, 15)));
	        finish.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
	        

	        
	        
	        
	        // Set preferred size to reduce button width
	        Dimension buttonSize = new Dimension(350, 120); // larghezza e altezza desiderate
	        Dimension exitSize = new Dimension(250, 90); // larghezza e altezza desiderate
	        finish.setPreferredSize(buttonSize);


	        // Add buttons to the panel
	        buttonPanel.add(finish, gbc);

	        // Add action listeners to the buttons
	        finish.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                SafeManager.safeFile(team1);
	                SafeManager.safeFile(team0);
	                System.exit(0);
	            }
	        });
	        


	        // Add the button panel to the center of the main panel
	        mainPanel.add(buttonPanel, BorderLayout.CENTER);

	        this.setUndecorated(true); 
	        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null); // Centra la finestra
	        this.setVisible(true);
	        this.setAlwaysOnTop(true);

	    }}
	