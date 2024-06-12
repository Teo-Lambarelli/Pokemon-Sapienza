package frame;
import javax.swing.*;

import pokemon.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//public class PokemonButtonBox extends JFrame {
//    public PokemonButtonBox() {
//        // Impostazioni di base della finestra
//        setTitle("Pokémon Button Box");
//        setSize(400, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        // Layout a griglia per posizionare i pulsanti
//        setLayout(new GridLayout(4, 3));
//        
//        // Creare i pulsanti
//        for (int i = 1; i <= 12; i++) {
//            JButton button = new JButton("Pokémon " + i);
//            button.addActionListener(new ButtonClickListener());
//            add(button);
//        }
//    }
//
//    // Listener per i pulsanti
//    private class ButtonClickListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JButton source = (JButton) e.getSource();
////            JOptionPane.showMessageDialog(null, source.getText() + " selected!");
//            
//        }
//    }
//
//    public static void main(String[] args) {
//        // Creare e mostrare la finestra
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new PokemonButtonBox().setVisible(true);
//            }
//        });
//    }
//}