package org.fsq.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class LootItemSerializerImpl implements LootItemSerializer {
    private ObjectMapper om;

    @Autowired
    public LootItemSerializerImpl() {
        om = new ObjectMapper();
        om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public void writeItem(File f, Object o) throws IOException {
        om.writeValue(f, o);
    }

    public Object readItem(File f, Class c) throws IOException {
        return om.readValue(f, c);
    }

    public String writeItemToString(Object o) throws IOException {
        return om.writeValueAsString(o);
    }
}