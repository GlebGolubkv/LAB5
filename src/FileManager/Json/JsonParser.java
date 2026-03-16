package FileManager.Json;

import DataClasses.MusicBand;

import java.util.Hashtable;

/**
 * Класс, через который выполняется вся работа с файлом
 * <p>
 *     Этот класс объединяет в себе методы JsonReader, JsonWriter, JsonDateReader, JsonCleaner для удобства обращения к
 *     их функциям
 * </p>
 */
public class JsonParser {

    private static JsonParser instance;


    public static void initialize()
    {
        if (instance == null) {
            instance = new JsonParser();
        }
        else throw new IllegalStateException("JsonParser has been already initialized");
    }

    public static JsonParser getInstance(){
        if (instance == null) {
            throw new IllegalStateException("JsonParser has not been initialized");
        }
        return instance;
    }

    private JsonParser() {

    }

    /**
     * Метод, позволяющий записать один объект MusicBand в класс, при этом сохранив все ранее записанное в файе
     * @param key
     * @param musicBand
     */

    public void WriteOneClassToFile(int key, MusicBand musicBand) {
        JsonWriter.getInstance().writeValue( key, musicBand);

    }

    /**
     * Метод, позволяющий записать в файл весь список данных. При этом все находящееся в файле будет перезаписано.
     * @param Map
     */
    public void WriteLibraryToFile(Hashtable<Integer, MusicBand> Map) {
        JsonWriter.getInstance().writeMap(Map);
    }

    /**
     * Метод считывает все содержимое файла
     * @return Hashtable, на основе которого производится вся последующая работа
     */

    public Hashtable<Integer, MusicBand> ReadAllClassesAtFile() {
        return JsonReader.getInstance().readFile();
    }

    /**
     * Метод отчищает файл
     */
    public void CleanFile() {
        JsonCleaner.getInstance().cleanFile();
    }

    /**
     * Метод, который считывает дату создания файла
     * @return дата создания файла
     */
    public String getCreationTimeOfFile() {
        return JsonDateReader.getInstance().getCreationTime();
    }



}
