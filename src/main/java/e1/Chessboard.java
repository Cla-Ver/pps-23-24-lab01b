package e1;

public class Chessboard {

    private int BOARD_SIZE;
    private boolean hasSizeBeenSet;
    private static Chessboard instance;

    private Chessboard(){
        hasSizeBeenSet = false;
        instance = null;
    }

    public static Chessboard getInstance(){
        if(instance == null){
            instance = new Chessboard();
        }
        return instance;
    }

    public void setSize(int size){
        if(hasSizeBeenSet && BOARD_SIZE != size){
            throw new IllegalStateException("Board size already been set");
        }
        BOARD_SIZE = size;
        hasSizeBeenSet = true;
    }

    public int getSize(){
        if(!hasSizeBeenSet){
            throw new IllegalStateException("Board size not set");
        }
        return BOARD_SIZE;
    }


}
