package frame;

import javax.swing.*;
import java.awt.*;


/**
 * La classe BackgroundPanel estende JPanel e permette di impostare un'immagine di sfondo per il pannello.
 */
public class BackgroundPanel extends JPanel {

    /** L'immagine di sfondo del pannello. */
    private Image backgroundImage;

    /**
     * Costruttore della classe BackgroundPanel.
     *
     * @param backgroundImage L'immagine di sfondo da utilizzare nel pannello.
     */
    public BackgroundPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    /**
     * Sovrascrive il metodo paintComponent per disegnare l'immagine di sfondo.
     *
     * @param g L'oggetto Graphics utilizzato per disegnare l'immagine di sfondo.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}