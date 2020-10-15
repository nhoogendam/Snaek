package snake.api;

import java.util.LinkedList;

public class Snaek {

	private final LinkedList<Cell> snake = new LinkedList<>();
	private final Board board;
	private Direction dir;

	public Snaek(final Board board) {
		this.board = board;
	}

	public boolean collision() {

		return false;
	}

	public Direction getDirection() {
		return dir;
	}

	public LinkedList<Cell> getSnake() {
		return snake;
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

	public void moveDir(final int x, final int y) {
		// get the head of the snake
		final Cell head = snake.getFirst();

		// Get the cell based in relation to the head
		final Cell next = new Cell(head.getRow() + x, head.getCol() + y, CellType.SNAKEBODY);

		// remove the last cell and make the celltype empty
		final Cell tail = snake.removeLast();
		board.getCell(tail).setType(CellType.EMPTY);
		snake.addFirst(next);
	}

	public void setDirection(final Direction dir) {
		this.dir = dir;
	}

}
