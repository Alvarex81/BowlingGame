package edu.grupo2.Game;

import java.util.ArrayList;

public class Line {

    private static final int maxPins = 10;
    private static final int maxNameCharacters = 11;

    private String Name;
    private ArrayList<Integer> rolls;
    private int[] scores;


    Line (String name){

        //Validaciones
        if (name.isEmpty()) {throw new AppGameErrorException("Nombre de linea vacio");}
        if (name.length() >= maxNameCharacters) {throw new AppGameErrorException("El nombre asignado a la linea: "+ name +"\nsupera los 11 caracteres, no puede ser mostrado en pantalla.");}

        this.Name = name;
        this.rolls = new ArrayList<>();
        this.scores = new int[10];

    }

    public String getName() {
        return Name;
    }

    public void addRoll (int roll){
        //Validaciones
        if (roll  < 0 || roll > 10) {throw new AppGameErrorException("La cantidad de pinos registrada "+roll+"\nno se encuentra en el rango permitido 0..10");}
        this.rolls.add(roll);
    }

    public void caculateScores (){

        int cursor = 0;
        int currentScore = 0;

        if (rolls.size() < 12) { throw new AppGameErrorException("La cantidad de jugadas registradas no alcanza al minimo requerido para evaluar la puntuación."); }
        if (rolls.size() > 21) { throw new AppGameErrorException("La cantidad de jugadas registradas supera el maximo requerido para evaluar la puntuación."); }


        try {
            for (int i = 0; i < this.scores.length; i++) {

                if (isStrike(cursor)) {
                    currentScore += maxPins + this.rolls.get(cursor + 1) + this.rolls.get(cursor + 2);
                    cursor++;
                } else if (isSpare(cursor)) {
                    currentScore += maxPins + this.rolls.get(cursor + 2);
                    cursor += 2;
                } else {
                    currentScore += this.rolls.get(cursor) + this.rolls.get(cursor + 1);
                    cursor += 2;
                }

                this.scores[i] = currentScore;
            }

        }
        catch (Exception ex){

            throw new AppGameErrorException("EL calculo de las puntuaciones no se ha podido completar, no se han registrado la cantidad de jugadas requeridas");
        }
    }

    public boolean isStrike (int cursor) {
        return this.rolls.get(cursor) == maxPins;
    }

    public boolean isSpare (int cursor) {
        return this.rolls.get(cursor) + this.rolls.get(cursor+1) == maxPins;
    }

    public ArrayList<Integer> getRolls() {
        return rolls;
    }

    public int[] getScores() {
        return scores;
    }

    public int getRoll(int cursor){
        return this.rolls.get(cursor);
    }
}
