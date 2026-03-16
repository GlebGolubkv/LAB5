package FileManager.Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonDataMapper {

    private static JsonDataMapper instance;
    private final ObjectMapper mapper;


    private JsonDataMapper() {

        this.mapper = new ObjectMapper();
        //регаем новый модуль
        mapper.registerModule(new JavaTimeModule());
        //выставляем читаемую запись в файле
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        //выставляем отображение времени в файле
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }


    public static JsonDataMapper getInstance() {
        if (instance == null) {
            throw new NullPointerException("Mapper has not been initialized");
        }
        return instance;
    }

    public static void initialize() {
        if (instance == null) {
            instance = new JsonDataMapper();
        } else {
            throw new IllegalStateException("Mapper has already been initialized");
        }
    }

    public ObjectMapper getMapper() {
        return mapper;
    }
}
