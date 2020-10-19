package snake.application;

import java.util.Scanner;

import snake.api.Game;

public class Main {

	public static void main(final String[] args) {

		final Game game = new Game();
		
		game.generateFood();
		while (game.isRunning) {
			game.getInput();
			game.update();
		}
	}
}
