package frame;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import battlemanager.BattleManager;
import battlemanager.Choice;
import battlemanager.Choice.Option;
import battlemanager.Fighter;
import battlemanager.Team;
import moves.Move;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Pokemon;
import pokemon.Squirtle;


public class BattleGUI extends JFrame {
//	public JButton[] moves0=
//	public JButton[] moves1=
	private int tm=0;
	public JPanel p0=new JPanel();
	public JPanel p1=new JPanel();
	public JPanel p2=new JPanel();
	public JPanel p3=new JPanel();
	public JPanel p4=new JPanel();
	public JPanel p5=new JPanel();
	public JPanel p7=new JPanel();
	public JPanel p6=new JPanel();
	private int indx;
	private int yCoordinate=113;
	protected BattleManager bg;
    public BattleGUI(BattleManager bg, int indx) {
        super("Pokemon Battle");
        this.bg=bg;
        this.indx=indx;
        JPanel p000=new JPanel();
        JLabel label=new JLabel();
        p000.setOpaque(false);
        p000.setBounds(320, 0, 1000, 850);
        
        ImageIcon ico = new ImageIcon(bg.getFighter()[indx].pokemon.getBackSprite());
        Image imag = ico.getImage();
        Image scaledImage = imag.getScaledInstance(750, 820, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
        
        
        Timer timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aggiorna la posizione della label
                if (yCoordinate < 116) {
                    yCoordinate += 1; // Muovi verso il basso
                } else {
                    yCoordinate -= 2; // Muovi verso l'alto
                }
                label.setLocation(0, yCoordinate); // Imposta la nuova posizione
            }
        });
        timer.start(); // Avvia il timer
        
        
        
        
        
        
        
        
        
        p000.setVisible(true);
        p000.add(label);
        add(p000);
        this.setLayout(new BorderLayout());
        // Imposta il layout del contenuto principale
        ImageIcon icon = new ImageIcon("src/sprites/semenano2.png");
        Image image = icon.getImage();
        
        
        BackgroundPanel background=new BackgroundPanel(image);
        background.setLocation(0, 0);
        background.setBounds(503, -130, 1000, 850);
        background.setBackground(new Color(210, 220, 190));
        
        
        
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Aggiungi bordi neri ai lati
        mainPanel.setBorder(BorderFactory.createMatteBorder(0, 210, 0, 210, Color.BLACK));
        mainPanel.setBackground(new Color(210, 220, 190));
        
        mainPanel.setLayout(new BorderLayout());
     
        
        JPanel abilityPanel = new JPanel();
        abilityPanel.setBorder(BorderFactory.createMatteBorder(0, 65, 0, 65, new Color(210, 220, 190)));
        abilityPanel.setLayout(new GridLayout(6, 2));
        abilityPanel.setOpaque(false);
        
        abilityPanel.add(p0);
        p0.setOpaque(false);
        abilityPanel.add(p1);
        p1.setOpaque(false);
        abilityPanel.add(p2);
        p2.setOpaque(false);
        abilityPanel.add(p3);
        p3.setOpaque(false);
        abilityPanel.add(p4);
        p4.setOpaque(false);
        abilityPanel.add(p5);
        p5.setOpaque(false);
        
        
        
        p6.setLayout(new GridLayout(2,3));
        JPanel n0=new JPanel();
        n0.setOpaque(false);
        p6.add(n0);
        JPanel n3=new JPanel();
        n3.setOpaque(false);
        p6.add(n3);
        JPanel n4=new JPanel();
        n4.setOpaque(false);
        
        
        JPanel n1=new JPanel();
        n1.setOpaque(false);
        p6.add(n1);
        JButton n2=new JButton("Change Pkmn");
        n2.setFont(new Font("Arial", Font.BOLD, 20));
        n2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0), 4),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        n2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(tm==0) {new ChangePokemon(bg.getTeam0(),bg, tm, bg.getTeam1());dispose();}
            	else if(tm==1) {new ChangePokemon(bg.getTeam1(),bg, tm, bg.getTeam0());dispose();}
            	
            	
            	
            	
           
            }
        });
        p6.add(n2);
        
        p6.add(n4);
        
        
        abilityPanel.add(p6);
        p6.setOpaque(false);
        abilityPanel.add(p7);
        p7.setOpaque(false);

        makeButtons(abilityPanel, 0, true);
       
        add(background);
        mainPanel.add(abilityPanel);
//        mainPanel.setOpaque(false);
        
        add(mainPanel);
       
        this.setUndecorated(true); 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null); // Centra la finestra,ma nn ci serve
        this.setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });   
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        System.exit(0);
                    }
                } 
                return false;
            }
        });
        p000.revalidate();
        p000.repaint();
        mainPanel.revalidate();
        mainPanel.repaint();
        abilityPanel.revalidate();
        abilityPanel.repaint();
    	
    }
        
        

    public void makeButtons(JPanel abilityPanel, int index, boolean bool) {
    for (int i = 0; i <= 3; i++) {
    	Move move=bg.getFighter()[index].pokemon.getMoves()[i];
        JButton button = new JButton();
        if (bool) {abilityPanel.add(button);}
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0), 4),
                BorderFactory.createEmptyBorder(0, 0, 0, 15)));
        		button.setFont(new Font("Arial", Font.BOLD, 20));
                setBut(i, button, move,index);     
    }}

    public void setBut(int i, JButton button, Move move, int index){
	if(move!=null) {button.setText(move.toString()+" "+move.getPp()+"/"+move.getPp()+" "+move.getType().toString());
	button.addActionListener(new ButtonClickListener(move,button,move.getPp(),i,index));}else{button.setText("////");};
	}
    
    public void setTxt(JButton b, String txt) {
    	b.setText(txt);
        b.revalidate();
        b.repaint();
    }
    
private class ButtonClickListener implements ActionListener {
	private int i;
	private int fighter;
	private int current_pp;
	private JButton button;
	private Move move;
	private ButtonClickListener(Move move, JButton button, int current_pp,int i, int fighter) {
		this.current_pp=current_pp;
		this.move=move;
		this.i=i;
		this.fighter=fighter;
		this.button=button;
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        Choice choice=new Choice(Option.MOVE,i);
        if(current_pp>0) {
        	current_pp--;
        	setTxt(button,move.toString()+" "+(current_pp)+"/"+(move.getPp())+" "+move.getType().toString());
        	bg.turnOption(fighter, choice);
        }
        
    }
    
}

}    