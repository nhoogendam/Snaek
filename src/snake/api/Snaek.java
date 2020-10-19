package snake.api;

import java.util.LinkedList;

public class Snaek {

	private final LinkedList<Cell> snakeBody = new LinkedList<>();
	private final Board board;
	private Direction dir = Direction.RIGHT;

	public Snaek(final Board board) {
		this.board = board;
	}

	public Direction getDirection() {
		return dir;
	}
	
	public Cell getHead() {
		return snakeBody.getFirst();
	}

	public LinkedList<Cell> getSnake() {
		return snakeBody;
	}
	public void moveDir(final int x, final int y) {
		// get the head of the snake
		final Cell head = snakeBody.getFirst();
		final Cell tail = snakeBody.removeLast();
		board.getCell(tail).setType(CellType.EMPTY);
		
		final Cell next = new Cell(head.getRow() + x, head.getCol() + y, CellType.SNAKEBODY);
		
		snakeBody.addFirst(next);
	}
	
	public Cell getNextMove() {
		Cell next = null;
		final Cell head = snakeBody.getFirst();
		//check if the cell is out of bounds
		int nextCol = head.getCol();
		int nextRow = head.getRow();
		/*
		 * This says if it goes out of bounds and at a direction then the game is over
		 */
		if((nextRow + 1 >= Board.getRowCount() && dir == Direction.DOWN) 
		|| (nextRow - 1 < 0 && dir == Direction.UP)
		|| (nextCol + 1 >= Board.getColCount() && dir == Direction.RIGHT)
		|| (nextCol - 1 < 0 && dir == Direction.LEFT)) {
			return next;
		}
		
		switch (dir) {
		case UP:
			next = board.getCell(head.getRow() - 1, head.getCol());
			break;
		case DOWN:
			next = board.getCell(head.getRow() + 1, head.getCol());
			break;
		case LEFT:
			next = board.getCell(head.getRow(), head.getCol() - 1);
			break;
		case RIGHT:
			next = board.getCell(head.getRow(), head.getCol() + 1);
			break;
	}
	return next;
}
	
	public void move() {
		switch (dir) {
			case UP:
				moveDir(-1, 0);
				break;
			case DOWN:
				moveDir(1, 0);
				break;
			case LEFT:
				moveDir(0, -1);
				break;
			case RIGHT:
				moveDir(0, 1);
				break;
		}
	}
	
	public void setDirection(final Direction dir) {
		this.dir = dir;
	}

}
