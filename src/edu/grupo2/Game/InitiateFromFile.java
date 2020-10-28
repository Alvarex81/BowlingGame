package edu.grupo2.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InitiateFromFile implements InitiateGame {

    private static final String rowSplit = " ";

    String fileName;
    String filepath;

    InitiateFromFile (String filepath, String fileName)
    {
        this.filepath = filepath;
        this.fileName = fileName;
    }

    @Override
    public void start(Game game) {
        try {
            uploadFile(game);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void uploadFile (Game game) throws FileNotFoundException, IOException {

        String rawData;
        FileReader inputFile = new FileReader(this.filepath + this.fileName);
        BufferedReader buffer = new BufferedReader(inputFile);

        while ((rawData = buffer.readLine()) != null) {

            String[] rawInfo = rawData.split(this.rowSplit);

            game.addNewPlayer(rawInfo[0]);
            game.addRolls(rawInfo[0], Integer.parseInt(rawInfo[1].replace("F", "0")));
        }
    }
}
