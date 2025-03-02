package e2;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.util.Map.Entry;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Pair<Integer,Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size, int mines) {
        this.logics = new LogicsImpl(size, mines);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener onClick = (e)->{
            final CellImpl bt = (CellImpl)e.getSource();
            //final Pair<Integer,Integer> pos = buttons.get(bt);
            boolean aMineWasFound = bt.hasMine(); // call the logic here to tell it that cell at 'pos' has been seleced
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
            } else {
                drawBoard();            	
            }
            boolean isThereVictory = false; // call the logic here to ask if there is victory
            if (isThereVictory){
                //quitGame();
                logics.loss();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        /*MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton)e.getSource();
                if (bt.isEnabled()){
                    final Pair<Integer,Integer> pos = buttons.get(bt);
                    // call the logic here to put/remove a flag
                    System.out.println("right click!");
                }
                drawBoard(); 
            }
        };*/
                
        /*for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }*/
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                panel.add((CellImpl)Grid.getInstance().getCells().get(new Pair<Integer,Integer>(row, col)));
            }
        }
        /*for(Cell c: Grid.getInstance().getCells().values()){
            
            //c.setPrimaryAction(onClick);
            //c.setSecondaryAction(onRightClick);
            panel.add((CellImpl)c);
        }*/
        this.drawBoard();
        this.setVisible(true);
    }
    
    private void quitGame() {
        this.drawBoard();
    	/*for (Cell c: Grid.getInstance().getCells().values()) {
            // call the logic here
            // if this button is a mine, draw it "*"
            // disable the button
            c.setEnabled(false);
            if(c.hasMine()){
                c.setText("*");
            }
    	}*/
        logics.loss();
    }

    private void drawBoard() {
        for (Cell c: Grid.getInstance().getCells().values()) {
            // call the logic here
            // if this button is a cell with counter, put the number
            // if this button has a flag, put the flag

    	}
    }
    
}
