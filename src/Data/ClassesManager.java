package Data;

import DataClasses.MusicBand;
import FileManager.Json.JsonParser;
import TermenalManager.Colors;

import java.util.Hashtable;


public class ClassesManager {                           // переписать метод tostring в отдельный метод
    private static ClassesManager instance;
    private final Hashtable<Integer, MusicBand> Map;


    private ClassesManager(String filename) {

        Map = JsonParser.getInstance().ReadAllClassesAtFile();
    }

    public static ClassesManager getInstance() {
        if (instance == null) {
            throw new RuntimeException("ClassesManager not initialized");
        }
        return instance;
    }

    public static synchronized void initialize(String fileName) {


        if (instance == null) {
            instance = new ClassesManager(fileName);
        } else {
            throw new RuntimeException("ClassesManager already initialized");
        }


    }


    public int MapSize() {
        return Map.size();
    }


    public String GetCreationDate() {
        return JsonParser.getInstance().getCreationTimeOfFile();
    }


    public String GetCollectionType() {
        return Colors.GREEN + "Collection Type: " + Colors.RESET + Map.getClass().getName();
    }


    public Hashtable<Integer, MusicBand> GetMap() {
        return Map;
    }

    public void addMusicBandToCollection(int key, MusicBand mb) {
        Map.put(key, mb);
    }

    public void removeMusicBandFromCollection(int key) {
        Map.remove(key);
    }

    public boolean keyInMap(int key) {
        return Map.containsKey(key);
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Integer key : Map.keySet()) {
            s.append(Colors.GREEN)
                    .append("Key: ").append(Colors.RESET).append(key).append("\n")
                    .append(Colors.GREEN).append(" Value: ").append(Colors.RESET)
                    .append(Map.get(key).toString()).append("\n");

        }
        return s.toString();
    }


    public void SaveCollectionToFile() {
        JsonParser jsonParser = JsonParser.getInstance();
        jsonParser.WriteLibraryToFile(Map);
    }


    public void ClearCollection() {
        Map.clear();
    }

}
