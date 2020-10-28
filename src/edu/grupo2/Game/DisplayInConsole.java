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

        String concatString = new String();

        for (int i = 0; i < line.getRolls().size(); i++){

            if (line.isStrike(i)){
                concatString += "| |X";
            }
            else if (line.isSpare(i)){
                concatString += "|"+line.getRoll(i)+"|/";
                i++;
            }
            else {
                concatString += "|"+line.getRoll(i)+"|"+line.getRoll(i+1);
                i++;
            }
        }

        concatString += "|";

        return concatString;
    }

    private String concatScores (Line line){

        String concatString = new String();

        for (int score: line.getScores()){
            concatString = concatString + score + "\t";
        }

        return concatString;
    }

    private void printLine(Game game){

        for (Line line :game.getLines()){

            String rollsConcat = concatRolls (line);
            String scoreConcat = concatScores (line);

            System.out.println(line.getName()+"\t\t"+rollsConcat+"\n\t\t\t"+scoreConcat+"\n");

        }

    }

}
