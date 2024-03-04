package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  Logics logics;
  private static final int BOARD_SIZE = 5;
  private static final Pair<Integer, Integer> knightPosition = new Pair<Integer,Integer>(0, 0);
  private static final Pair<Integer, Integer> pawnPosition = new Pair<Integer,Integer>(2, 1);


  @BeforeEach
  public void beforeEach(){
      logics = new LogicsImpl(BOARD_SIZE, knightPosition, pawnPosition);
  }

  @Test
  public void initialBoardTest() {
    assertTrue(logics.hasKnight(knightPosition.getX(), knightPosition.getY()));
    assertTrue(logics.hasPawn(pawnPosition.getX(), pawnPosition.getY()));
    // TODO: Add your test logic here
    // You can generate random inputs and assert the expected output
    // For example:
    // int result = Logic.someMethod(5, 10);
    // assertEquals(expectedResult, result);
  }

  @Test
  public void hitTest(){
    assertFalse(logics.hit(BOARD_SIZE-1, BOARD_SIZE-1));
    assertTrue(logics.hit(knightPosition.getX()+2, knightPosition.getY()+1));
    assertFalse(logics.hit(0, 0));
  }

  
}
