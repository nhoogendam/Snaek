
public class Board {

	private final int ROW_COUNT = 15;
	private final int COL_COUNT = 20;
	
	private Cell[][] board = new Cell[ROW_COUNT][COL_COUNT];
	
	public void generate() {
		for(int row = 0; row < ROW_COUNT; row++) {
			for(int col = 0; col < COL_COUNT; col++) {
				board[row][col] = new Cell(row, col, ' ');
			}
		}
	}
	
	
	public void printBoard() {
		System.out.print(" ");
		for(int i = 0; i < COL_COUNT; i++) { System.out.print("+ "); }
		System.out.println();
		for(int row = 0; row < ROW_COUNT; row++) {
			System.out.print("|");
			for(int col = 0; col < COL_COUNT; col++) {
				System.out.print(board[row][col].getValue() + " ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.print(" ");
		for(int i = 0; i < COL_COUNT; i++) { System.out.print("+ "); }
	}
	
}
