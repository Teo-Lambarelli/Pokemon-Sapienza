package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuGUI extends JFrame {

    public MenuGUI() {
        super("Pokemon Battle");

        this.setLayout(new BorderLayout());
        // Imposta il layout del contenuto principale
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Aggiungi bordi neri ai lati
        mainPanel.setBorder(BorderFactory.createMatteBorder(0, 210, 0, 210, Color.BLACK));
        mainPanel.setBackground(new Color(210, 220, 190));
        
        add(mainPanel);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.decode("#ff2244")); // Imposta il colore di sfondo utilizzando un valore esadecimale

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10); // margini tra i bottoni

        // Create buttons
        JButton newPlayerButton = new JButton("New Player");
        newPlayerButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        newPlayerButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        
        JButton loadPlayerButton = new JButton("Load Player");
        loadPlayerButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        loadPlayerButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        
        JButton exitButton = new JButton("Exit");
        exitButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        exitButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        

        // Set preferred size to reduce button width
        Dimension buttonSize = new Dimension(350, 120); // larghezza e altezza desiderate
        Dimension exitSize = new Dimension(250, 90); // larghezza e altezza desiderate
        newPlayerButton.setPreferredSize(buttonSize);
        loadPlayerButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(exitSize);

        // Add buttons to the panel
        buttonPanel.add(newPlayerButton, gbc);
        buttonPanel.add(loadPlayerButton, gbc);
        buttonPanel.add(exitButton, gbc);

        // Add action listeners to the buttons
        newPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MenuGUI.this, "New Player button clicked");
            }
        });

        loadPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BattleGUI();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
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

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
    }}




//private JButton createCustomButton(String text) {
//    JButton button = new JButton(text);
//
//    // Customizing the button
//    button.setPreferredSize(new Dimension(150, 40));
//    button.setBackground(new Color(70, 130, 180)); // Set background color
//    button.setForeground(Color.WHITE); // Set text color
//    button.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
//
//    // Customizing the button border
//    button.setBorder(BorderFactory.createCompoundBorder(
//            BorderFactory.createLineBorder(Color.BLACK, 2),
//            BorderFactory.createEmptyBorder(5, 15, 5, 15)
//    ));
//    button.setFocusPainted(false); // Remove focus border
//    button.setOpaque(true);
//
//    return button;
//}