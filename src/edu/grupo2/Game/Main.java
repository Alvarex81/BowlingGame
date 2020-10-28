package edu.grupo2.Game;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Game game = new Game();
        DisplayGame display = new DisplayInConsole();
        InitiateGame initiator = new InitiateFromFile("src/edu/grupo2/Game/", "Bowling.txt" );

        game.addNewPlayer("Alvarex");
        game.addRolls("Alvarex", 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

        initiator.start(game);
        game.calculatePuntuation();
        display.showGame (game);

    }
}
