package e2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
//import org.w3c.dom.events.MouseEvent;

public class LogicsImpl implements Logics {

    private boolean isGameOver;

    public LogicsImpl(int size, int quantityOfMines) {
        Grid.getInstance().setup(size, quantityOfMines);
        isGameOver = false;
        setCellPrimaryAction();
        setCellSecondaryAction();
    }

    private void setCellPrimaryAction(){
        for (Cell c : Grid.getInstance().getCells().values()){
            c.setPrimaryAction(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(isGameOver){
                        throw new IllegalStateException("Game is over");
                    }
                    c.show();
                    autoShow(c);
                    if(c.hasMine()){
                        loss();
                    } else {
                        int minesFound = checkSurroundingMines(c);
                        c.setCellText(String.valueOf(minesFound));
                    }
                }
            });
        }
    }

    private void setCellSecondaryAction(){

        for (Cell c : Grid.getInstance().getCells().values()){
            c.setSecondaryAction(onRightClick);
        }
    }

    MouseInputListener onRightClick = new MouseInputAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            final Cell bt = (CellImpl)e.getSource();
            if(bt.isActive()){
                bt.toggleFlag();
            }
        }
    };


    private int checkSurroundingMines(Cell c){
        Pair<Integer, Integer> cellPos = c.getPosition();
        int minesFound = 0;
        for(int x = cellPos.getX()-1; x <= cellPos.getX()+1; x++){
            for(int y = cellPos.getY()-1; y <= cellPos.getY()+1; y++){
                if((x >= 0 && x < Grid.getInstance().getSize()) && (y >= 0 && y < Grid.getInstance().getSize())){
                    if(Grid.getInstance().getCells().get(new Pair<>(x, y)).hasMine()){
                        minesFound++;
                    }
                }
            }
        }
        return minesFound;
    }

    private void autoShow(Cell c){
        int nearbyMines = checkSurroundingMines(c);
        if(nearbyMines == 0){
            for(int x = c.getPosition().getX()-1; x <= c.getPosition().getX()+1; x++){
                for(int y = c.getPosition().getY()-1; y <= c.getPosition().getY()+1; y++){
                    if((x >= 0 && x < Grid.getInstance().getSize()) && (y >= 0 && y < Grid.getInstance().getSize())){
                        Cell nearby = Grid.getInstance().getCells().get(new Pair<>(x, y));
                        if(nearby.isActive() && !nearby.hasFlag()){
                            nearby.hit();
                            if(checkSurroundingMines(nearby) == 0){
                                autoShow(nearby);
                            }    
                        }
                    }
                }
            }    
        }
        
    }

    public void setCellPrimaryAction(ActionListener al){
        for (Cell c : Grid.getInstance().getCells().values()){
            c.setPrimaryAction(al);
        }
    }

    public void setCellSecondaryAction(MouseInputListener m){
        for (Cell c : Grid.getInstance().getCells().values()){
            c.setSecondaryAction(m);
        }
    }

    public void loss(){
        isGameOver = true;
        for(Cell c : Grid.getInstance().getCells().values()){
            c.show();
        }
    }

    @Override
    public boolean isGameOver() {
        return isGameOver;
    }

}
