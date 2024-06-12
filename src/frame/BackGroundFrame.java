package frame;

import javax.swing.*;
import java.awt.*;

/**
 * La classe BackGroundFrame estende JFrame e rappresenta una finestra principale con un layout specifico e uno stile personalizzato.
 */
public class BackGroundFrame extends JFrame {

    /** Colore principale dello sfondo della finestra. */
    final static Color MAIN_COLOR = new Color(210, 220, 190);

    /** Colore del pulsante utilizzato nella finestra. */
    final static Color BUTTON_COLOR = new Color(54, 45, 62);

    /** Colore del bordo del pulsante utilizzato nella finestra. */
    final static Color BUTTON_BORDER = new Color(0, 0, 0);

    /**
     * Costruttore della classe BackGroundFrame.
     * Inizializza la finestra con un layout personalizzato e uno stile definito.
     */
    public BackGroundFrame() {
        super();
        this.setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createMatteBorder(0, 210, 0, 210, Color.BLACK));
        mainPanel.setBackground(MAIN_COLOR);

        add(mainPanel);
        this.setUndecorated(true); 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}