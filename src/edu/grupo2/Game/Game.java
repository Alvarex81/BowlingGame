package edu.grupo2.Game;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private final List<Line> lines;

    public Game (){
        this.lines = new LinkedList<>();
    }

    public void addNewPlayer(String name){

        if (!isPlayerAdded(name)) {
            this.lines.add(new Line(name));
        }
    }

    public void addRolls(String name, int...rolls){

        for (Line line :this.lines){
            if (line.getName().equals(name)){

                for (int roll :rolls){
                    line.addRoll(roll);
                }
            }
        }
    }

    public void addRolls(String name, String...rolls){

        for (Line line :this.lines){
            if (line.getName().equals(name)){

                for (String roll :rolls){
                    line.addRoll(roll);
                }
            }
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    private boolean isPlayerAdded (String name){

        for (Line line :this.lines) {
            if (line.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void calculatePuntuation () {
        for (Line line : this.lines) {
            line.caculateScores();
        }
    }
}
