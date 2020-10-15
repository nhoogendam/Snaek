package snake.api;
public class Cell {
	private int row;
	private int col;
	private CellType type;

	public Cell(final int row, final int col, final CellType value) {
		this.row = row;
		this.col = col;
		this.type = value;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public CellType getType() {
		return type;
	}

	public void setCol(final int col) {
		this.col = col;
	}

	public void setRow(final int row) {
		this.row = row;
	}

	public void setType(final CellType value) {
		this.type = value;
	}

}
