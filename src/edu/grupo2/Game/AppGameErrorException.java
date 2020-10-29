package edu.grupo2.Game;

public class AppGameErrorException extends RuntimeException {

    AppGameErrorException () {super();}
    AppGameErrorException (String message) {super(message);}
    AppGameErrorException (String message, Throwable cause) {super(message, cause);}
}
