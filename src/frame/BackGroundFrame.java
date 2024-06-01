package frame;

import javax.swing.*;
import java.awt.*;

public class BackGroundFrame extends JFrame {
	final static Color MAIN_COLOR =new Color(210, 220, 190);
	//final static ImageIcon BUTTON_TEXTURE=new ImageIcon(------);
	final static Color BUTTON_COLOR=new Color(54, 45, 62);
	final static Color BUTTON_BORDER=new Color(0,0,0);
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
    }}
