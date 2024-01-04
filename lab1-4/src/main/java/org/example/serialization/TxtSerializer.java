package org.example.serialization;

import org.example.Fertilizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtSerializer<T> implements Serializer<T>{

    @Override
    public String serialize(T object) {
        return object.toString();
    }

    @Override
    public T deserialize(String string) {
        Pattern pattern = Pattern.compile("Fertilizer\\{name='(.*?)', description='(.*?)'}");
        Matcher matcher = pattern.matcher(string);

        if (!matcher.matches()) return null;
        return (T) (new Fertilizer(matcher.group(1), matcher.group(2)));
    }
}
