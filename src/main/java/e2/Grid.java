package e2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Grid {

    HashMap<Pair<Integer, Integer>, Cell> cells;
    private int size;
    private static Grid instance = null;
    private boolean hasSizeBeenSet;

    private Grid(){
        hasSizeBeenSet = false;
        cells = new HashMap<>();
    }

    public static Grid getInstance() {
        if(instance == null){
            instance = new Grid();
        }
        return instance;
    }

    public void setup(int gridSize, int numberOfMines){
        if((hasSizeBeenSet && this.size != gridSize)){
            throw new IllegalStateException();
        }
        if(!hasSizeBeenSet){
            this.size = gridSize;
            hasSizeBeenSet = true;
            generateCells();
            setMines(numberOfMines);    
        }
    }

    private void addCell(CellImpl cell){
        checkSetup();
        if(cells.size() == Math.pow(size, 2)){
            throw new IllegalStateException("Grid is full");
        }
        cells.put(cell.getPosition(), cell);
    }

    public HashMap<Pair<Integer, Integer>, Cell> getCells() {
        checkSetup();
        return cells;
    }

    private void checkSetup(){
        if(instance == null || !hasSizeBeenSet){
            throw new IllegalStateException();
        }
    }

    private void generateCells(){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                Grid.getInstance().addCell(new CellImpl(new Pair<Integer,Integer>(row, col), false));
            }
        }
    }

    private void setMines(int numberOfMines){
        int generatedMines = 0;
        Random r = new Random();
        Pair<Integer, Integer> minePosition;
        while(generatedMines < numberOfMines){
            minePosition = new Pair<Integer,Integer>(r.nextInt(size), r.nextInt(size));
            if(!cells.get(minePosition).hasMine()){
                cells.get(minePosition).setMine(true);
                generatedMines++;
            }
        }
    }

    public Integer getSize() {
        return size;
    }

}
