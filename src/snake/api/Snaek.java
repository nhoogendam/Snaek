package snake.api;
import java.util.Iterator;
import java.util.LinkedList;

public class Snaek {

	private final LinkedList<Cell> snake = new LinkedList<>();
	private final Board board;
	private Direction dir;
	
	public Snaek(Board board) {
		this.board = board;
	}

	public void move() {
		
		Cell head;
		
		Cell next;
		Cell tail;
		switch(dir) {
		
			case UP:
				head = snake.getFirst();
				
				next = new Cell(head.getRow() - 1, head.getCol(), CellType.SNAKEBODY);
				tail = snake.removeLast();
				board.getCell(tail.getRow(), tail.getCol()).setType(CellType.EMPTY);
				snake.addFirst(next);
				break;
			case DOWN:
				head = snake.getFirst();
				
				next = new Cell(head.getRow() + 1, head.getCol(), CellType.SNAKEBODY);
				tail = snake.removeLast();
				board.getCell(tail.getRow(), tail.getCol()).setType(CellType.EMPTY);
				snake.addFirst(next);
				break;
			case LEFT:
				head = snake.getFirst();
				
				next = new Cell(head.getRow(), head.getCol() - 1, CellType.SNAKEBODY);
				tail = snake.removeLast();
				board.getCell(tail.getRow(), tail.getCol()).setType(CellType.EMPTY);
				snake.addFirst(next);
				break;
			case RIGHT:
				head = snake.getFirst();
				next = new Cell(head.getRow(), head.getCol() + 1, CellType.SNAKEBODY);
				tail = snake.removeLast();
				board.getCell(tail.getRow(), tail.getCol()).setType(CellType.EMPTY);
				snake.addFirst(next);
				break;
		}
	}

	public LinkedList<Cell> getSnake(){
		return snake;
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public void setDirection(Direction dir) {
		this.dir = dir;
	}

	public boolean collision() {
		
		return false;
	}
	

}
