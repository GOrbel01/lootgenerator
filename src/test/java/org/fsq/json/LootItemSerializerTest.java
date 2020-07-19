package org.fsq.json;

import org.fsq.entity.TestEntity;
import org.fsq.entity.item.armor.Armor;
import org.fsq.entity.item.armor.detail.ArmorProperties;
import org.fsq.entity.item.types.ArmorTypes;
import org.fsq.entity.stats.armor.ArmorStatValues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LootItemSerializerTest {

    private LootItemSerializerImpl lootItemSerializer;

    private File f;

    private static final String JSON_FILE_EXT = ".json";

    private static final String BASE_FILE_PATH = "src/test/resources/org.fsq.json/";

    @Before
    public void setup() {
        lootItemSerializer = new LootItemSerializerImpl();
    }

    @Test
    public void testReadJsonSingle() throws IOException {
        TestEntity te = new TestEntity("Bob", "22");

        f = getTestFilePath("TestKnown1");

        TestEntity result = (TestEntity) lootItemSerializer.readItem(f, TestEntity.class);

        assertEquals(te, result);
    }

    @Test
    public void testWriteJsonSingle() throws IOException {
        f = getTestFilePath("test");

        if (f.exists()) {
            f.delete();
        }

        ArmorProperties ap = new ArmorProperties();
        ap.setArmorValue(500);
        ap.setArmorType(new ArmorTypes("Test Type"));

        Armor armor = new Armor("Plate Mail", null, null, ap);
        armor.setId(1L);
        armor.setStats(getStatsList());
        lootItemSerializer.writeItem(f, armor);

        assertEquals(armor, lootItemSerializer.readItem(f, Armor.class));
    }

    @Test
    public void testWriteJsonSingleB() throws IOException {
        f = getTestFilePath("test");

        if (f.exists()) {
            f.delete();
        }

        ArmorProperties ap = new ArmorProperties();
        ap.setArmorValue(500);
        ap.setArmorType(new ArmorTypes("Test Type"));
        Armor armor = new Armor("Plate Mail", null, null, ap);
        armor.setStats(getStatsList());
        armor.setId(1L);

        lootItemSerializer.writeItem(f, armor);
    }

    @After
    public void cleanup() {
        f.delete();
    }

    private List<ArmorStatValues> getStatsList() {
        ArmorStatValues one = new ArmorStatValues(1L, 1, 10);
        ArmorStatValues two = new ArmorStatValues(1L, 4, 5);
        ArmorStatValues three = new ArmorStatValues(1L, 5, 4);

        List<ArmorStatValues> results = new ArrayList<>();
        results.add(one);
        results.add(two);
        results.add(three);

        return results;
    }

    private File getTestFilePath(String fileName) {
        return new File(BASE_FILE_PATH + fileName + JSON_FILE_EXT);
    }
}
