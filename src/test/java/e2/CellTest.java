package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellTest {

    CellImpl cell;
    Pair<Integer, Integer> position = new Pair<Integer,Integer>(0, 0);

    /*@BeforeEach
    public void beforeEach(){
        cell = new Cell(position);
    }*/

    @Test 
    public void positionTest(){
        cell = new CellImpl(position, false);
        assertEquals(new Pair<>(0, 0), cell.getPosition());
    }


    @Test
    public void mineTest(){
        cell = new CellImpl(position, true);
        assertTrue(cell.hit());
        cell = new CellImpl(position, false);
        assertFalse(cell.hit());
    }

    @Test
    public void actionTest(){
        cell = new CellImpl(position, false);

        ActionListener onClick = (e)->{
            final CellImpl bt = (CellImpl)e.getSource();
            bt.setEnabled(false);
        };

        cell.setPrimaryAction(onClick);
        assertTrue(cell.isEnabled());
        cell.doClick();
        assertFalse(cell.isEnabled());
    }

}
