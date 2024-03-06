package e1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChessboardTest {
    Chessboard chessboard;
    static final int BOARD_SIZE = 5;

    @BeforeEach
    public void beforeEach(){
        chessboard = Chessboard.getInstance();
    }

    @Test
    public void sizeTest(){
        assertThrows(IllegalStateException.class, () -> chessboard.getSize());
        chessboard.setSize(BOARD_SIZE);
        assertEquals(BOARD_SIZE, chessboard.getSize());
        assertThrows(IllegalStateException.class, () -> chessboard.setSize(BOARD_SIZE));
    }
}
