package snake.application;

import java.util.Scanner;

import snake.api.Board;
import snake.api.Direction;
import snake.api.Game;
import snake.api.Snaek;

public class Main {

	public static void main(final String[] args) {

		final Game game = new Game();
		final Scanner scan = new Scanner(System.in);
		final Board board = game.getBoard();
		final Snaek snake = board.getSnaek();
		
		game.generateFood();
		while (true) {
			String str = "0";
			int input = 0;

			System.out.print("Direction: ");
			str = scan.nextLine();

			if (str.equals("")) {
				game.update();
				continue;
			}

			try {
				input = Integer.parseInt(str);
			} catch (final NumberFormatException e) {
				System.out.println("Wrong input, retry");
				continue;
			}

			if (input == 5 && snake.getDirection() != Direction.DOWN) {
				snake.setDirection(Direction.UP);
			} else if (input == 3 && snake.getDirection() != Direction.LEFT) {
				snake.setDirection(Direction.RIGHT);
			} else if (input == 2 && snake.getDirection() != Direction.UP) {
				snake.setDirection(Direction.DOWN);
			} else if (input == 1 && snake.getDirection() != Direction.RIGHT) {
				snake.setDirection(Direction.LEFT);
			} else {
				System.out.println("Wrong input, retry");
				continue;
			}
			game.update();
		}
	}
}
