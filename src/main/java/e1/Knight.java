package e1;

public class Knight extends Piece implements MovableChessPiece {

    public Knight(Pair<Integer, Integer> initialPosition) {
        position = initialPosition;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public boolean move(int destinationX, int destinationY) {
        if(destinationX < 0 || destinationY < 0 || destinationX >= Chessboard.getInstance().getSize() || destinationY >= Chessboard.getInstance().getSize()){
            throw new IndexOutOfBoundsException();
        }
        if(Math.abs(position.getX() - destinationX) + Math.abs(position.getY() - destinationY) != 3 || Math.abs(position.getX() - destinationX) <= 0 || Math.abs(position.getY() - destinationY) <= 0){
            return false;
        }
        position = new Pair<Integer,Integer>(destinationX, destinationY);
        return true;
    }

}
