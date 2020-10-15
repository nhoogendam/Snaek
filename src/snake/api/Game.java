package snake.api;

import java.io.Console;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Game {
	private final Board board = new Board();
	private final Snaek snaek = board.getSnaek();
	private int foodRow;
	private int foodCol;
	
	public Game() {
		board.generate();
		board.getSnake().add(new Cell(1,2,CellType.SNAKEBODY));
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void generateFood() {
		Random rand = new Random();
		foodRow = rand.nextInt(Board.getRowCount());
		foodCol = rand.nextInt(Board.getColCount());
		LinkedList<Cell> snake = snaek.getSnake();
		Iterator<Cell> itr = snake.iterator();
		while(itr.hasNext()) {
			Cell body = itr.next();
			if(body.getRow() != foodRow || body.getCol() != foodCol) {
				board.getCell(foodRow, foodCol).setType(CellType.FOOD);
				break;
			}
			else {
				System.out.println("Had to rerandom");
				//Re-random the coordinates
				foodRow = rand.nextInt(Board.getRowCount());
				foodCol = rand.nextInt(Board.getColCount());
			}
		}
	}
	
	public void eatFood() {
		if(board.getCell(foodRow, foodCol).getType() != CellType.FOOD) {
			Cell body = snaek.getSnake().get(1);
			snaek.getSnake().addLast(body);
			snaek.getSnake().addLast(body);
			generateFood();
		}
	}
	
	public void gameOver() {
		
	}
	
	
	public void update(){
		snaek.move();
		eatFood();
		board.updateSnake();
		board.printBoard();
	}
	
}
