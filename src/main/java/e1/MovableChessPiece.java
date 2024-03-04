package e1;

public interface MovableChessPiece extends ChessPiece{

    /**
     * 
     * @param destinationX The row where the piece should move
     * @param destinationY The column where the piece should move
     * @return if the piece has moved
     */
    boolean move(int destinationX, int destinationY);

}
