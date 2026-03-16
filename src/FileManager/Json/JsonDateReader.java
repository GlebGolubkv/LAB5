package FileManager.Json;

import TermenalManager.Colors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class JsonDateReader {

    private static JsonDateReader instance;
    private final String fileName;

    private JsonDateReader(String fileName) {
        this.fileName = fileName;

    }

    public static JsonDateReader getInstance() {
        if (instance == null) {
            throw new IllegalStateException("JsonDateReader has not been initialized");
        }
        return instance;
    }

    public static void initialize(String fileName) {
        if (instance == null) {
            instance = new JsonDateReader(fileName);
        }
        else throw new IllegalStateException("JsonDateReader has been initialized");
    }


    public String getCreationTime() {
        Path path = Paths.get(fileName);

        try {
            FileTime creationTime = (FileTime) Files.getAttribute(path, "creationTime");
            ZonedDateTime created = ZonedDateTime.ofInstant(
                    creationTime.toInstant(), ZoneId.systemDefault());
            return (Colors.GREEN +  "Creation date: " + Colors.RESET + created);
        } catch (UnsupportedOperationException e) {
            return ("it is impossible to make an operation");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }




