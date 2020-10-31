package edu.grupo2.Game;


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DisplayInConsole implements DisplayGame {

    @Override
    public void showGame(Game game) {

        DisplayGameBoard displayGameBoard = (g) -> {

            DisplayRollBoard rollBoardBehaviour = (line) -> {
                StringBuilder concatString = new StringBuilder();

                final boolean[] skipRoll = {Boolean.FALSE};
                IntStream.range(0, line.getRolls().size())
                        .forEach(i -> {
                            System.out.println("INDEX = " + i);
                            if (!skipRoll[0]){
                                if (line.isStrike(i)) {
                                    concatString.append("| |X");
                                } else {
                                    if (line.isSpare(i)) {
                                        concatString.append("|" + line.getRoll(i) + "|/");
                                    } else {

                                        if (line.getFoul(i).equals("F")) {
                                            concatString.append("|").append(line.getFoul(i));
                                        } else {
                                            concatString.append("|").append(line.getRoll(i));
                                        }

                                        if (line.getFoul(i + 1).equals("F")) {
                                            concatString.append("|").append(line.getFoul(i + 1));
                                        } else {
                                            concatString.append("|").append(line.getRoll(i + 1));
                                        }
                                    }
                                    skipRoll[0] = Boolean.TRUE;
                                }
                            } else {
                                skipRoll[0] = Boolean.FALSE;
                            }
                        });

                return concatString.append("|")
                        .toString();
            };

            DisplayScoreBoard scoreBoardBehaviour = (line) -> {

                StringBuilder sb = new StringBuilder();
                Arrays.stream(line.getScores())
                        .boxed()
                        .collect(Collectors.toList())
                        .forEach(score -> {
                            sb.append(score)
                                    .append("\t");

                        });

                return sb.toString();
            };


            StringBuilder builder = new StringBuilder();
            // Header
            builder.append("Bowling Score")
                    .append(System.lineSeparator())
                    .append("------------------------------------------------------------------------------------------------")
                    .append(System.lineSeparator())
                    .append("Name \t\t| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |")
                    .append(System.lineSeparator())
                    .append("\t\t\t------------------------------------------")
                    .append(System.lineSeparator())
                    .toString();

            // All Game Lines
            game.getLines()
                    .stream()
                    .forEach(line -> {

                        String rollsConcat = rollBoardBehaviour.concatRolls(line);
                        /*String rollsConcat = concatRolls(line);*/
                        String scoreConcat = scoreBoardBehaviour.concatScores(line);
                        builder.append(line.getName() + "\t\t" + rollsConcat + "\n\t\t\t" + scoreConcat + "\n")
                                .append(System.lineSeparator());
                    });

            // Footer
            builder.append("------------------------------------------------------------------------------------------------");

            System.out.println(builder.toString());


        };
        displayGameBoard.printAllGame(game);
    }

    private void printHeader() {
        System.out.println("Bowling Score");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Name \t\t| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |");
        System.out.println("\t\t\t------------------------------------------");
    }

    public interface DisplayGameBoard {
        void printAllGame(Game game);
    }

    public interface DisplayRollBoard {
        String concatRolls(Line line);
    }

    public interface DisplayScoreBoard {
        String concatScores(Line line);
    }

}
