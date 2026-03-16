package FileManager.Json;


import DataClasses.MusicBand;


import java.io.*;
import java.util.Hashtable;


/**
 * Класс, который позволяет записывать данные в файл
 */
public class JsonWriter {

    private static JsonWriter instance;
    private final String fileName;

    private JsonWriter(String fileName) {
        this.fileName = fileName;
    }

    public static JsonWriter getInstance() {
        if (instance == null) {
            throw new IllegalStateException("JsonWriter has not been initialized");
        }

        return instance;
    }

    public static void initialize(String fileName) {
        if (instance == null) {
            instance = new JsonWriter(fileName);
        } else {
            throw new IllegalStateException("JsonWriter has already been initialized");
        }
    }

    public void writeValue(int key, MusicBand musicBand) {

        //в oldMap записываем копию текущего файла
        Hashtable<Integer, MusicBand> oldMap = JsonReader.getInstance().readFile();
        oldMap.put(key, musicBand);


        // создает поток записи в файл. Перезаписывает с нуля
        try (FileOutputStream file = new FileOutputStream(fileName)) {



            //записываем в файл
            Mapper.getInstance().getMapper().writeValue(file, oldMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // получает на вход сразу список значений

    public void writeMap(Hashtable<Integer, MusicBand> newMap) {


        // создает поток записи в файл. Перезаписывает с нуля

        try (FileOutputStream file = new FileOutputStream(fileName)) {


            //записываем в файл
            Mapper.getInstance().getMapper().writeValue(file, newMap);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

