
public class Cell {
	private int row;
	private int col;
	private char value;
	
	public Cell(int row, int col, char value){
		this.row = row;
		this.col = col;
		this.value = value;
	}
	
	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
}
