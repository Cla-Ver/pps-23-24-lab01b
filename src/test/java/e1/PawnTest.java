package e1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PawnTest {
    ChessPiece pawn;
    static final Pair<Integer, Integer> INITIAL_POSITION = new Pair<Integer,Integer>(0, 0);

    @BeforeEach
    public void beforeEach(){
        pawn = new Pawn(INITIAL_POSITION);
    }

    @Test
    public void positionTest(){
        assertEquals(INITIAL_POSITION.getX(), pawn.getPosition().getX());
        assertEquals(INITIAL_POSITION.getY(), pawn.getPosition().getY());
    }
}
