package edu.grupo2.Game;

public class DisplayInConsole implements DisplayGame {

    @Override
    public void showGame (Game game){
        printHeader();
        printLine(game);
        printFooter();
    }

    private void printHeader(){
        System.out.println("Bowling Score");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Name \t\t| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |");
        System.out.println("\t\t\t------------------------------------------");
    }

    private void printFooter(){
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    private String concatRolls (Line line){

        StringBuilder concatString = new StringBuilder();

        for (int i = 0; i < line.getRolls().size(); i++){

            if (line.isStrike(i)){
                concatString.append("| |X");
            }
            else if (line.isSpare(i)){
                concatString.append("|").append(line.getRoll(i)).append("|/");
                i++;
            }
            else {

                if (line.getFoul(i).equals("F")){
                    concatString.append("|").append(line.getFoul(i)).append("|").append(line.getRoll(i + 1));
                }
                else concatString.append("|").append(line.getRoll(i)).append("|").append(line.getRoll(i + 1));

                i++;
            }
        }

        concatString.append("|");

        return concatString.toString();
    }

    private String concatScores (Line line){

        StringBuilder concatString = new StringBuilder();

        for (int score: line.getScores()){
            concatString.append(score).append("\t");
        }

        return concatString.toString();
    }

    private void printLine(Game game){

        for (Line line :game.getLines()){

            String rollsConcat = concatRolls (line);
            String scoreConcat = concatScores (line);

            System.out.println(line.getName()+"\t\t"+rollsConcat+"\n\t\t\t"+scoreConcat+"\n");

        }

    }

}
