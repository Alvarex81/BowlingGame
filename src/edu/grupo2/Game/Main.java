package edu.grupo2.Game;

import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
	// write your code here
        try {
            Game game = new Game();
            DisplayGame display = new DisplayInConsole();
            InitiateGame initiator = new InitiateFromFile("src/edu/grupo2/Game/", "Bowling.txt");

            game.addNewPlayer("Alvarex");
            game.addRolls("Alvarex", 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

            game.addNewPlayer("Luis");
            game.addRolls("Luis", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            game.addNewPlayer("Pedro");
            game.addRolls("Pedro", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F");

            initiator.start(game);
            game.calculatePuntuation();
            display.showGame(game);
        }
        catch (AppGameErrorException ex) {
            System.out.println("ERROR - JUEGO ABORTADO");
            System.out.println(ex.getMessage());
        }

    }
}
