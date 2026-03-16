package Data;

import FileManager.CommandsParser.CommandsReader;
import FileManager.Json.*;
import TermenalManager.BandsFileReader;
import TermenalManager.BandsInputManager;

public class DataInitializer {

    public static DataInitializer instance;

    private DataInitializer(String fileName) {

        JsonDataMapper.initialize();
        DataCommands.initialize();
        BandsInputManager.initialize();
        BandsFileReader.initialize();
        CommandsReader.initialize();
        JsonWriter.initialize(fileName);
        JsonReader.initialize(fileName);
        JsonParser.initialize();
        JsonDateReader.initialize(fileName);
        JsonCleaner.initialize(fileName);
        ClassesManager.initialize(fileName);

    }

    public static DataInitializer getInstance() {
        if (instance == null) {
            throw new RuntimeException("Data has not been initialized");
        }
        return instance;
    }

    public static void initialize(String fileName) {
        if (instance == null) {
            instance = new DataInitializer(fileName);
        } else {
            throw new RuntimeException("Data has not been initialized");
        }
    }
}
