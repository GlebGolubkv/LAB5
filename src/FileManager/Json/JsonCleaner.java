package FileManager.Json;

import java.io.FileOutputStream;
import java.io.IOException;


public class JsonCleaner {

    private final String fileName;
    private static JsonCleaner instance;

    private JsonCleaner(String fileName) {
        this.fileName = fileName;
    }


    public static JsonCleaner getInstance() {
        if (instance == null) {
            throw new IllegalStateException("JsonCleaner has not been initialized");
        }
        return instance;

    }

    public static void initialize(String fileName) {
        if (instance == null) {
            instance = new JsonCleaner(fileName);
        }
        else throw new IllegalStateException("JsonCleaner has been already initialized");

    }

    public void cleanFile() {
        try (FileOutputStream file = new FileOutputStream(fileName, true)) {
            //Ничего не вызываем. Перезаписываем файл в нулевой
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
