package edu.grupo2.Game;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Line> lines;

    public Game() {
        this.lines = new LinkedList<>();
    }

    public void addNewPlayer(String name) {

        if (!isPlayerAdded(name)) {
            this.lines.add(new Line(name));
        }
    }

    public void addRolls(String name, int... rolls) {

        this.lines.stream()
                .forEach(line -> {
                    if (line.getName().equals(name)) {
                        if (rolls.length > 0) {
                            Arrays.stream(rolls)
                                    .boxed()
                                    .collect(Collectors.toList())
                                    .forEach(roll -> line.addRoll(roll));
                        }
                    }
                });

    }

    public void addRolls(String name, String... rolls) {

        this.lines.stream()
                .forEach(line -> {
                    if (line.getName().equals(name)) {
                        if (rolls.length > 0) {
                            Arrays.asList(rolls)
                                    .stream()
                                    .forEach(roll -> line.addRoll(roll));
                        }
                    }
                });

    }

    public List<Line> getLines() {
        return lines;
    }

    private boolean isPlayerAdded(String name) {
        return this.lines.stream()
                .anyMatch(line -> line.getName()
                        .equals(name));
    }

    public void calculatePuntuation() {
        this.lines.stream()
                .forEach(line -> line.caculateScores());

    }
}
