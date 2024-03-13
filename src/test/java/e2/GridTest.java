package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTest {
    private static final int GRID_SIZE = 5;
    private static final int QUANTITY_OF_MINES = 5;

    @BeforeAll
    public static void beforeAll(){
        Grid.getInstance().setup(GRID_SIZE, QUANTITY_OF_MINES);
    }

    /*@Test
    public void addCellTest(){
        /*for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                Grid.getInstance().addCell(new Cell(new Pair<Integer,Integer>(row, col), false));
            }
        }
        assertEquals(Math.pow(GRID_SIZE, 2), Grid.getInstance().getCells().size());
        assertThrows(IllegalStateException.class, () -> Grid.getInstance().addCell(new Cell(new Pair<Integer,Integer>(GRID_SIZE+1, 0), false)));
    }*/

    @Test
    public void sizeTest(){
        assertEquals(GRID_SIZE, Grid.getInstance().getSize());
    }

    @Test
    public void getCellsTest(){
        assertEquals(Math.pow(GRID_SIZE, 2), Grid.getInstance().getCells().values().size());
    }
}
