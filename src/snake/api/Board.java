package snake.api;

import java.util.Iterator;
import java.util.LinkedList;

public class Board {

	private static final int ROW_COUNT = 15, COL_COUNT = 20;

	public static int getRowCount() {
		return ROW_COUNT;
	}

	public static int getColCount() {
		return COL_COUNT;
	}

	private final Cell[][] board = new Cell[ROW_COUNT][COL_COUNT];

	private final Snaek snaek = new Snaek(this);

	public void generate() {
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int col = 0; col < COL_COUNT; col++) {
				board[row][col] = new Cell(row, col, CellType.EMPTY);
			}
		}
		snaek.getSnake().add(new Cell(2,2,CellType.SNAKEBODY));
		printBoard();
	}

	public void printBoard() {
		System.out.print(" ");
		for (int i = 0; i < COL_COUNT; i++) {
			System.out.print("+ ");
		}
		System.out.println();
		for (int row = 0; row < ROW_COUNT; row++) {
			System.out.print("|");
			for (int col = 0; col < COL_COUNT; col++) {
				switch(board[row][col].getType()) {
					case EMPTY:
						System.out.print("  ");
						break;
					case SNAKEBODY:
						System.out.print("X ");
						break;
					case FOOD:
						System.out.print("0 ");
				}
			}
				System.out.print("|");
			System.out.println();
		}
		System.out.print(" ");
		for (int i = 0; i < COL_COUNT; i++) {
			System.out.print("+ ");
		}
		System.out.println();
	}
	
	public void updateSnake() {
		Iterator<Cell> itr = snaek.getSnake().iterator();
		while(itr.hasNext()) {
			Cell body = itr.next();
			int row = body.getRow();
			int col = body.getCol();
			board[row][col].setType(body.getType());
		}
	}
	
	public LinkedList<Cell> getSnake() {
		return snaek.getSnake();
	}
	
	public Cell getCell(int x, int y) {
		return board[x][y];
	}
	
	public Cell getCell(Cell cell) {
		return getCell(cell.getRow(), cell.getCol());
	}
	
	public Snaek getSnaek() {
		return snaek;
	}
}
