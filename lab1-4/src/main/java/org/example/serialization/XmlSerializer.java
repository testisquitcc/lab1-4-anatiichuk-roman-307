package org.example.serialization;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.text.SimpleDateFormat;


public class XmlSerializer<T> implements Serializer<T> {

    private final XmlMapper xmlMapper = new XmlMapper();
    Class<T> classType;

    public XmlSerializer(Class<T> classType) {
        this.xmlMapper.registerModule(new JavaTimeModule());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.xmlMapper.setDateFormat(dateFormat);
        this.classType = classType;
    }

    @Override
    public String serialize(T object) {
        try {
            return this.xmlMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public T deserialize(String string) {
        try {
            return this.xmlMapper.readValue(string, this.classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
