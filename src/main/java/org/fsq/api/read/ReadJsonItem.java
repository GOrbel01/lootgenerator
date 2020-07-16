package org.fsq.api.read;

import org.fsq.entity.item.armor.Armor;
import org.fsq.entity.item.armor.detail.ArmorProperties;
import org.fsq.entity.stats.armor.ArmorStatValues;
import org.fsq.io.repo.ArmorRepository;
import org.fsq.json.LootItemSerializerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReadJsonItem {
    @Autowired
    private ArmorRepository armorRepository;

    @Autowired
    private LootItemSerializerImpl lootItemSerializer;

    private static final String BASE_FILE_PATH = "src/main/resources/org/fsq/json/";

    @RequestMapping("test")
    public String indexTest() {
        return "What is this!";
    }

    @RequestMapping("viewItem")
    public String findItem() throws IOException {
        Armor armor = (Armor) lootItemSerializer.readItem(new File(BASE_FILE_PATH + "test.json"), Armor.class);
        return lootItemSerializer.writeItemToString(armor);
    }

    @RequestMapping("viewAll")
    public String viewAll() throws IOException {
        List<Armor> armors = armorRepository.findAll();
        StringBuilder sb = new StringBuilder();
        for (Armor a : armors) {
            sb.append(lootItemSerializer.writeItemToString(a));
            sb.append("\n");
        }
        return sb.toString();
    }

    @RequestMapping("deleteAll")
    public void deleteAll() {
        armorRepository.deleteAll();
        System.out.println("All Armor items Deleted");
    }

    @RequestMapping("tryupdate")
    public void updateDB() {
        ArmorProperties ap = new ArmorProperties();
        ap.setArmorValue(500);
        ap.setArmorType("Test Type");
        Armor armor = new Armor("Plate Mail", null, null, ap);
        armor.setStats(getStatsList());
        armor.setId(1L);

        armorRepository.save(armor);
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
}
