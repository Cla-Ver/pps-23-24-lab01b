package e1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightTest {

    MovableChessPiece knight;
    static final Pair<Integer, Integer> INITIAL_POSITION = new Pair<Integer,Integer>(0, 0);
    final int BOARD_SIZE = 5;

    @BeforeEach
    public void beforeEach(){
        knight = new Knight(INITIAL_POSITION);
        Chessboard.getInstance().setSize(BOARD_SIZE);
    }

    @Test
    public void moveTest(){
        assertThrows(IndexOutOfBoundsException.class, ()-> knight.move(-1, -1));
        assertThrows(IndexOutOfBoundsException.class, ()-> knight.move(BOARD_SIZE, BOARD_SIZE));
        assertFalse(knight.move(2, 2));
        assertTrue(knight.move(1, 2));
    }
    

}
