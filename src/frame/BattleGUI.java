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
import javax.swing.*;
import battlemanager.BattleManager;
import battlemanager.Choice;
import battlemanager.Choice.Option;
import battlemanager.Fighter;
import battlemanager.Team;
import moves.Move;



public class BattleGUI extends JFrame {		//di chi è il turno
	private int indx;
	private int indx2;
	private int yCoordinate=5;
	protected BattleManager bg;
	protected BattleGUI bGUI;
    public BattleGUI(BattleManager bg, int indx) {
        super("Pokemon Battle");
        this.bg=bg;
        this.indx=indx;
        if (indx==0) {indx2=1;}
        if (indx==1) {indx2=0;}
        JPanel p001=new JPanel();
        JPanel p000=new JPanel();
        JLabel label=new JLabel();
        JLabel label2=new JLabel();
        this.bGUI=this;
        
        p001.setOpaque(false);//qui metterò label2
        p001.setBounds(1020, 20, 500, 500);
        
        
        p000.setOpaque(false);//qui metterò label
        p000.setBounds(400, 118, 600, 600);
        
        
        ImageIcon ico = new ImageIcon(bg.getFighter()[indx].pokemon.getBackSprite()); //label=pokemon0
        Image imag = ico.getImage();
        Image scaledImage = imag.getScaledInstance(750, 820, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
        
        
        ImageIcon ic = new ImageIcon(bg.getFighter()[indx2].pokemon.getFrontSprite()); //label2=pokemon1
        Image ima = ic.getImage();
        Image scaledImag = ima.getScaledInstance(350,400, Image.SCALE_SMOOTH);
        ImageIcon scaledIco = new ImageIcon(scaledImag);
        label2.setIcon(scaledIco);
        
        
        Timer timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//Aggiorna la posizione della label
                if (yCoordinate < 7) {
                    yCoordinate += 1; // Muovi verso il basso
                } else {
                    yCoordinate -= 2; // Muovi verso l'alto
                }
                label.setLocation(label.getX(), yCoordinate); // Imposta la nuova posizione
                label2.setLocation(label2.getX(), yCoordinate);
            }
        });
        timer.start(); // Avvia il timer

        
        p000.setVisible(true);
        p000.add(label);
        p001.add(label2);
        p001.setVisible(true);
        label2.setOpaque(false);
        label.setOpaque(false);
        
        
        add(p000);
        add(p001);
        
        
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
        
        
        JPanel p0=new JPanel();
        JPanel p1=new JPanel();
    	JPanel p2=new JPanel();
    	JPanel p3=new JPanel();
    	JPanel p4=new JPanel();
    	JPanel p5=new JPanel();
    	JPanel p6=new JPanel();
    	JPanel p7=new JPanel();
    	
    	JLabel nt0=new JLabel(bg.getTeam0().getName()+"'s POV");
    	JLabel nt1=new JLabel(bg.getTeam1().getName()+"'s POV");
    	nt0.setFont(new Font("Arial", Font.BOLD, 20));
    	nt1.setFont(new Font("Arial", Font.BOLD, 20));
    	
        abilityPanel.add(p0);
        p0.setLayout(new GridLayout(2,1));
        if (indx==0) {p0.add(nt0);}
        if (indx==1) {p0.add(nt1);}
        p0.setOpaque(false);
        abilityPanel.add(p1);
        p1.setOpaque(false);
        abilityPanel.add(p2);
        p2.setOpaque(false);					//aggiungo pannelli invisibili per mettere i 4 pulsanti alla fine
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
        n3.setOpaque(false);										//divido il panel p6 (in basso a sx prima dei tasti move)
        p6.add(n3);
        JPanel n4=new JPanel();
        n4.setOpaque(false);
        
        
        JPanel n1=new JPanel();
        n1.setOpaque(false);
        p6.add(n1);
        JButton n2=new JButton("Switch Pkmn");
        n2.setFont(new Font("Arial", Font.BOLD, 20));
        n2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0), 4),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));				//creo un button che mi permetta di cambiare i pokemon
        n2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(indx==0) {new ChangePokemon(bg, indx);dispose();}
            	else if(indx==1) {new ChangePokemon(bg, indx); dispose();}
            	dispose();
            }
        });
        p6.add(n2);
        p6.add(n4);
        
        
        abilityPanel.add(p6);
        p6.setOpaque(false);
        abilityPanel.add(p7);
        p7.setOpaque(false);

        makeButtons(abilityPanel, indx, true);
       
        add(background);
        mainPanel.add(abilityPanel);
        
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
        
//        bg.getFighter()[0].choice=null;
//        bg.getFighter()[1].choice=null;
        
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
	button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	bg.turnOption(indx, new Choice(Choice.Option.MOVE,i));;
        	if (indx==1) {bg.executeTurn();}
        	new BattleGUI(bg,indx2);
        	bGUI.dispose();
        }
    });;}else{button.setText("////");};
	}
    
    public void setTxt(JButton b, String txt) {
    	b.setText(txt);
        b.revalidate();
        b.repaint();
    }

    


}    