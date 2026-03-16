package TermenalManager;

import Data.IDGenerator;
import DataClasses.Coordinates;
import DataClasses.Label;
import DataClasses.MusicBand;
import DataClasses.MusicGenre;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;

public class BandsFileReader {

    /**
     * Класс, который позволяет вводить новый объект MusicBand
     */


    private static BandsFileReader instance;

    private BandsFileReader() {
    }

    public static BandsFileReader getInstance() {
        if (instance == null) {
            throw new IllegalStateException("BandsInputFromFile has not been initialized");
        }
        return instance;
    }

    public static void initialize() {
        if (instance == null) {
            instance = new BandsFileReader();
        } else {
            throw new IllegalStateException("BandsInputFromFile has already been initialized");
        }
    }

    /**
     * Базовый ввод нового объекта
     *
     * @param bufferedReader
     * @return введенный MusicBand
     */

    public MusicBand InputBand(BufferedReader bufferedReader) {

        try {


            Integer Id = new IDGenerator().generateNewID(); // ID

            String Name = readName(bufferedReader);  //NAME


            Coordinates coordinates = new Coordinates(readXCoordinates(bufferedReader), readYCoordinates(bufferedReader)); // COORDINATES

            ZonedDateTime time = ZonedDateTime.now(); // TIME

            long numberOfParticipants = readNumberOfParticipants(bufferedReader); // participants

            long albumsCount = readAlbumsCount(bufferedReader); // albums

            MusicGenre musicGenre = readMusicGenre(bufferedReader); // genre

            Label label = readLabel(bufferedReader); // label


            MusicBand musicBand = new MusicBand(Id, Name, coordinates, time, numberOfParticipants, albumsCount, musicGenre, label);


            System.out.println("Вы ввели: " + musicBand);
            return musicBand;
        } catch (Exception _) {

            throw new IllegalArgumentException("Error reading from file.");

        }
    }

    public MusicBand InputBand(Integer Id, BufferedReader bufferedReader) {

        try {


            String Name = readName(bufferedReader);  //NAME


            Coordinates coordinates = new Coordinates(readXCoordinates(bufferedReader), readYCoordinates(bufferedReader)); // COORDINATES

            ZonedDateTime time = ZonedDateTime.now(); // TIME

            long numberOfParticipants = readNumberOfParticipants(bufferedReader); // participants

            long albumsCount = readAlbumsCount(bufferedReader); // albums

            MusicGenre musicGenre = readMusicGenre(bufferedReader); // genre

            Label label = readLabel(bufferedReader); // label


            MusicBand musicBand = new MusicBand(Id, Name, coordinates, time, numberOfParticipants, albumsCount, musicGenre, label);


            System.out.println("Вы ввели: " + musicBand);
            return musicBand;
        } catch (Exception _) {

            throw new IllegalArgumentException("Error reading from file.");

        }
    }


    private String readName(BufferedReader bufferedReader) throws IOException {
        String name = bufferedReader.readLine().trim();
        if (name.isEmpty()) {
            throw new IllegalStateException("Error: name cannot be empty.");
        } else return name;
    }

    private Integer readXCoordinates(BufferedReader bufferedReader) throws IOException {

        String x = bufferedReader.readLine().trim();

        if (x.isEmpty()) {

            throw new IllegalStateException("Error: coordinate cannot be empty.");
        } else try {
            int x1 = Integer.parseInt(x);
            if (x1 <= 254) {
                return x1;
            } else {

                throw new IllegalStateException("Error: coordinate must be less then 254.");
            }
        } catch (NumberFormatException e) {

            throw new IllegalStateException("Error: coordinate must be an integer.");
        }


    }

    private Double readYCoordinates(BufferedReader bufferedReader) throws IOException {

        String y = bufferedReader.readLine().trim();


        if (y.isEmpty()) {

            throw new IllegalStateException("Error: coordinate cannot be empty.");
        } else {
            try {
                Double y1 = Double.parseDouble(y);
                if (y1 <= 93) {
                    return y1;
                } else {

                    throw new IllegalArgumentException("Error: coordinate must be less then 93.");
                }
            } catch (NumberFormatException e) {

                throw new IllegalArgumentException("Error: coordinate must be an integer.");
            }
        }

    }

    private long readNumberOfParticipants(BufferedReader bufferedReader) throws IOException {

        String n = bufferedReader.readLine().trim();


        if (n.isEmpty()) {

            throw new IllegalArgumentException("Error: Number cannot be empty.");
        } else try {
            long n1 = Long.parseLong(n);
            if (n1 > 0) {
                return n1;
            } else {
                throw new IllegalArgumentException("Error: Number must be greater than 0.");
            }
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Error: Number must be double.");
        }
    }


    private long readAlbumsCount(BufferedReader bufferedReader) throws IOException {

        String n = bufferedReader.readLine().trim();


        if (n.isEmpty()) {

            throw new IllegalArgumentException("Error: Number cannot be empty.");
        } else try {
            long n1 = Long.parseLong(n);
            if (n1 > 0) {
                return n1;
            } else {
                throw new IllegalArgumentException("Error: Number must be greater than 0.");
            }
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Error: Number must be double.");
        }

    }

    private MusicGenre readMusicGenre(BufferedReader bufferedReader) throws IOException {

        String genre = bufferedReader.readLine().trim();
        if (genre.isEmpty()) {
            return null;
        } else {
            try {
                return MusicGenre.valueOf(genre.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Error: Invalid genre.");
            }
        }


    }

    private Label readLabel(BufferedReader bufferedReader) {

        try {
            Integer x = Integer.parseInt(bufferedReader.readLine().trim());
            return new Label(x);
        } catch (IllegalArgumentException | IOException e) {
            throw new IllegalArgumentException("Error: Invalid label.");
        }
    }

}

