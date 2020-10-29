package edu.grupo2.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InitiateFromFile implements InitiateGame {

    private static final String rowSplit = " ";

    String fileName;
    String filepath;

    InitiateFromFile (String filepath, String fileName)
    {
        if (filepath.isEmpty()) {throw new AppGameErrorException("La ruta asociada al archivo esta vacía");}
        if (fileName.isEmpty()) {throw new AppGameErrorException("No se ha ingresado el nombre del archivo");}

        this.filepath = filepath;
        this.fileName = fileName;
    }

    @Override
    public void start(Game game) {
        try {
            uploadFile(game);
        }catch (Exception e){
            throw new AppGameErrorException("Se ha producido un error durante la carga del archivo "+e.getMessage());
        }
    }

    public void uploadFile (Game game) throws IOException {

        String rawData;
        FileReader inputFile = new FileReader(this.filepath + this.fileName);
        BufferedReader buffer = new BufferedReader(inputFile);

        while ((rawData = buffer.readLine()) != null) {

            String[] rawInfo = rawData.split(rowSplit);

            game.addNewPlayer(rawInfo[0]);
            game.addRolls(rawInfo[0], rawInfo[1]);
        }
    }
}
