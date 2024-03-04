package e1;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightTest {

    MovableChessPiece knight;
    static final Pair<Integer, Integer> INITIAL_POSITION = new Pair<Integer,Integer>(0, 0);

    @BeforeEach
    public void beforeEach(){
        knight = new Knight(INITIAL_POSITION);
    }

    @Test
    public void moveTest(){
        assertFalse(knight.move(2, 2));
    }
    

}
