package org.fsq;

import org.fsq.entity.item.equipment.armor.Armor;
import org.fsq.io.repo.armor.ArmorRepository;
import org.fsq.json.LootItemSerializer;
import org.fsq.json.LootItemSerializerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/tst")
public class JsonHelper {
    private static final String TEST_PATH = "src/test/resources/org/fsq/api/armor/";

    @Autowired
    private ArmorRepository armorRepository;

    private LootItemSerializer lootItemSerializer;

    public JsonHelper() {
        lootItemSerializer = new LootItemSerializerImpl();
    }

    @RequestMapping("/fetchSomeJson")
    public void produceJsonFile() throws IOException {
        File ft = new File("");
        System.out.println("File Path: " + ft.getAbsolutePath());
        File f = new File(TEST_PATH + "test.json");
        if (f.exists()) {
            f.delete();
        }
        Armor armor = armorRepository.getOne(1L);
        lootItemSerializer.writeItem(f, armor);
    }
}
