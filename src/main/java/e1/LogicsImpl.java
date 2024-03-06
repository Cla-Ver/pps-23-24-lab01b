package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final ChessPiece pawn;
	private MovableChessPiece knight;
	private final Random random = new Random();
	//private final int size;
	 
    public LogicsImpl(int size){
    	Chessboard.getInstance().setSize(size);
        this.pawn = new Pawn(this.randomEmptyPosition());
        this.knight = new Knight(this.randomEmptyPosition());	
    }

	public LogicsImpl(int size, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn){
    	Chessboard.getInstance().setSize(size);
		this.pawn = new Pawn(pawn);
		this.knight = new Knight(knight);
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(Chessboard.getInstance().getSize()),this.random.nextInt(Chessboard.getInstance().getSize()));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= Chessboard.getInstance().getSize() || col >= Chessboard.getInstance().getSize()) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getPosition().getX();
		int y = col-this.knight.getPosition().getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.knight = new Knight(new Pair<>(row,col));
			return this.pawn.getPosition().equals(this.knight.getPosition());
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}

	public Pair<Integer, Integer> getKnightPosition(){
		return knight.getPosition();
	}

	public Pair<Integer, Integer> getPawnPosition(){
		return pawn.getPosition();
	}

}
