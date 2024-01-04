package org.example.serialization;

public interface Serializer<T> {
    String serialize(T object);
    T deserialize(String string);
}
