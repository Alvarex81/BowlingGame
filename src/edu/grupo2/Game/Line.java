package edu.grupo2.Game;

import java.util.ArrayList;

public class Line {

    private static final int maxPins = 10;

    private String Name;
    private ArrayList<Integer> rolls;
    private int[] scores;


    Line (String name){
        this.Name = name;
        this.rolls = new ArrayList<>();
        this.scores = new int[10];

    }

    public String getName() {
        return Name;
    }

    public void addRoll (int roll){
        this.rolls.add(roll);
    }

    public void caculateScores (){

        int cursor = 0;
        int currentScore = 0;

        for (int i = 0; i < this.scores.length; i++){

            if (isStrike(cursor)){
                currentScore += maxPins + this.rolls.get(cursor + 1) + this.rolls.get(cursor + 2);
                cursor++;
            }
            else if (isSpare(cursor)){
                currentScore += maxPins + this.rolls.get(cursor + 2);
                cursor+=2;
            }
            else {
                currentScore += this.rolls.get(cursor) + this.rolls.get(cursor + 1);
                cursor+=2;
            }

            this.scores[i] = currentScore;
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
