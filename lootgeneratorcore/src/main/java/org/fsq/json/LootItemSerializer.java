package org.fsq.json;

import java.io.File;
import java.io.IOException;

public interface LootItemSerializer {
    void writeItem(File f, Object o) throws IOException;

    Object readItem(File f, Class c) throws IOException;

    String writeItemToString(Object o) throws IOException;
}
