package frame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import pokemon.Pokemon;

public class Atkmn extends JFrame{
	
	private String sprite0;
	private String sprite1;
	private Pokemon pokemon0;
	private Pokemon pokemon1;
	private boolean another;
	private int i;
	private int c=60;
	private BackgroundPanel p=new BackgroundPanel(image);
	private final static ImageIcon icon = new ImageIcon("src/sprites/atkanm.png");
    private final static Image image = icon.getImage();
	public Atkmn(Pokemon pokemon0, Pokemon pokemon1,int i, boolean another) {
		this.pokemon0=pokemon0;
		this.pokemon1=pokemon1;
		this.another=another;
		this.sprite0=pokemon0.getBackSprite();
		this.sprite1=pokemon1.getFrontSprite();

		JLabel s0=new JLabel();
		JLabel s1=new JLabel();
		
		
        JLabel pokeStats0=new JLabel(pokemon0.getName()+"     lvl:"+pokemon0.getStats().getLvl()+"     hp:"+(String.format("%.2f",pokemon0.getStats().getHp())));
        JLabel pokeStats1=new JLabel(pokemon1.getName()+"     lvl:"+pokemon0.getStats().getLvl()+"     hp:"+(String.format("%.2f",pokemon1.getStats().getHp())));
        pokeStats0.setSize(400, 400);
        pokeStats0.setFont(new Font("Arial", Font.BOLD, 20));
        pokeStats1.setSize(400, 400);
        pokeStats1.setFont(new Font("Arial", Font.BOLD, 20));
        
        
		JPanel p000=new JPanel();
		p000.setOpaque(false);//qui metterò label
        p000.setBounds(400, 118, 600, 600);

        JPanel p001=new JPanel();
        p001.setOpaque(false);//qui metterò label2
        p001.setBounds(1020, 20, 500, 500);
        
        JPanel p002=new JPanel();
        p002.setOpaque(false);//qui metterò labelName
        p002.setBounds(190, 207, 500, 500);
        p002.add(pokeStats1);
        add(p002);

        
        JPanel p003=new JPanel();
        p003.setOpaque(false);//qui metterò labelName
        p003.setBounds(1200, 470, 500, 500);
        p003.add(pokeStats0);
        add(p003);
        
		ImageIcon ic0 = new ImageIcon(sprite0); 
        Image ima0 = ic0.getImage();
        Image scaledImag0 = ima0.getScaledInstance(750,820, Image.SCALE_SMOOTH);
        ImageIcon scaledIco0 = new ImageIcon(scaledImag0);
        s0.setIcon(scaledIco0);
        
        
        ImageIcon ic = new ImageIcon(sprite1); 
        Image ima = ic.getImage();
        Image scaledImag = ima.getScaledInstance(350,400, Image.SCALE_SMOOTH);
        ImageIcon scaledIco = new ImageIcon(scaledImag);
        s1.setIcon(scaledIco);
		
	       Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        	if(c<100) {
        	c++;
        	}
        	else if(c>=100 && c<=115){
        	
        	c++;
        	if(i==0) {p000.setLocation(600, 20);}
            if(i==1) {p001.setLocation(800, 100);}
     
        	
        	}
        	else if (c>115 && c<=134){
        	if(i==0) {p000.setLocation(400, 118);}
            if(i==1) {p001.setLocation(1020, 20);}
            c++;
        	}
        	
        	
        	else if (c==135){
        		int m=0;
        		if(i==0) {m=1;}
        		if (another==true) {new Atkmn(pokemon0,pokemon1,m,false);}
        		c++;
        	}
        	else {
        		dispose();
        	}
        }});
    timer.start(); // Avvia il timer
        
        
       
        
        
        
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
	    p001.add(s1);
	    p000.add(s0);
	    this.add(p000);
	    this.add(p001);
		this.add(p);
		this.setUndecorated(true); 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centra la finestra
        this.setVisible(true);
        this.setAlwaysOnTop(true);
	}

}