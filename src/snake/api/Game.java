package snake.api;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private final Board board = new Board();
	private final Snaek snaek = board.getSnaek();
	private int foodRow;
	private int foodCol;
	final Scanner scan = new Scanner(System.in);
	public boolean isRunning = true;
	
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
	
	public void getInput() {
		String str = "0";
		int input = 0;

		System.out.print("Direction: ");
		str = scan.nextLine();

		if (str.equals("")) {
			return;
		}

		try {
			input = Integer.parseInt(str);
		} catch (final NumberFormatException e) {
			System.out.println("Wrong input, retry");
			return;
		}
		/*
		 * TODO: Check if it is going out of bounds here instead of in the
		 */

		if (input == 5 && snaek.getDirection() != Direction.DOWN) {
			snaek.setDirection(Direction.UP);
		} else if (input == 3 && snaek.getDirection() != Direction.LEFT) {
			snaek.setDirection(Direction.RIGHT);
		} else if (input == 2 && snaek.getDirection() != Direction.UP) {
			snaek.setDirection(Direction.DOWN);
		} else if (input == 1 && snaek.getDirection() != Direction.RIGHT) {
			snaek.setDirection(Direction.LEFT);
		} else {
			System.out.println("Wrong input, retry");
			return;
		}
	}
	
	public void gameOver() {
		isRunning = false;
		System.out.println("YOU LOST");
	}
	
	public void snaekMove() {
		Cell next = snaek.getNextMove();
		
		if(next == null || next.getType() == CellType.SNAKEBODY)
			gameOver();
		else 
			snaek.move();
	}
	
	public void update(){
		eatFood();
		snaekMove();
		board.updateSnake();
		if(isRunning) {
			board.printBoard();
		}
	}
	
}
