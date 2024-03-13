package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogicsTest {

    Logics logics;
    static final int BOARD_SIZE = 7;
    static final int QUANTITY_OF_MINES = 0;

    @BeforeEach
    public void beforeEach(){
        logics = new LogicsImpl(BOARD_SIZE, QUANTITY_OF_MINES);
    }

    @Test
    public void endGameTest(){
        /*Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).setMine(true);
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).doClick();*/
        logics.loss();
        for(Cell c : Grid.getInstance().getCells().values()){
            assertFalse(c.isActive());
        }
    }

    @Test
    public void addCellLogicTest(){
        ActionListener onClick = (e)->{
            final Cell bt = (Cell)e.getSource();
            bt.show();
        };

        logics.setCellPrimaryAction(onClick);
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).hit();
        assertFalse(Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).isActive());

    }

    @Test
    public void gameOverTest(){

        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).setMine(false);
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(1, 0)).setMine(true);
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).hit();
        assertFalse(logics.isGameOver());
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(1, 0)).hit();
        assertTrue(logics.isGameOver());
        //assertThrows(IllegalStateException.class, () -> Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).hit());
    }

    @Test
    public void nearbyMinesTest(){
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).setMine(false);
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(1, 0)).setMine(true);
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).hit();
        assertEquals("1", Grid.getInstance().getCells().get(new Pair<Integer,Integer>(0, 0)).getCellText());
    }

    @Test
    public void autoShowCellsSingleMineTest(){
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(BOARD_SIZE/2, BOARD_SIZE/2)).setMine(true);
        Grid.getInstance().getCells().get(new Pair<Integer,Integer>(BOARD_SIZE/2, BOARD_SIZE/2)).hit();

        for(Cell c : Grid.getInstance().getCells().values()){
            if(c.hasMine()){
                assertTrue(c.isActive());
            } else {
                assertFalse(c.isActive());
            }
            
        }
    }

}
