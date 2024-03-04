package e1;

import java.util.Random;

public class Pawn implements ChessPiece{

    private Pair<Integer, Integer> pawn;

    public Pawn(int BOARD_SIZE){
        pawn = setRandomPosition(BOARD_SIZE);
    }

    public Pawn(Pair<Integer, Integer> position){
        pawn = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return pawn;
    }

    private Pair<Integer, Integer> setRandomPosition(int max){
        return new Pair<Integer,Integer>(new Random().nextInt(max), new Random().nextInt(max));
    }

}
