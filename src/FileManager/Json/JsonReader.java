package FileManager.Json;

import DataClasses.MusicBand;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Класс, который позволяет читать данные из файла
 */
public class JsonReader {

    private static JsonReader instance;
    private final String fileName;

    private JsonReader(String filename) {
        this.fileName = filename;
    }


    public static JsonReader getInstance() {
        if (instance == null) {
            throw  new IllegalStateException("JsonReader has not been initialized");
        }
        return instance;
    }

    public static void initialize(String fileName) {
        if (instance == null) {
            instance = new JsonReader(fileName);
        }
        else {
            throw new IllegalStateException("JsonReader has already been initialized");
        }
    }

    public Hashtable<Integer, MusicBand> readFile() {

        // Если файл не существует или пустой, возвращаем пустую таблицу
        if (!new File(fileName).exists() || (new File(fileName).length() == 0)) {
            return new Hashtable<>();
        }


        try (FileInputStream file = new FileInputStream(fileName)) {




            Hashtable<Integer, MusicBand> map = Mapper.getInstance().getMapper().readValue(file, new TypeReference<Hashtable<Integer, MusicBand>>() {
            });

            return map;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
