package org.example.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonSerializer<T> implements Serializer<T>{
    Class<T> type;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonSerializer(Class<T> type) {
        this.objectMapper.registerModule(new JavaTimeModule());
        this.type = type;
    }
    @Override
    public String serialize(T object) {
        try {
            return this.objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public T deserialize(String data) {
        try {
            return this.objectMapper.readValue(data, this.type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
