package org.fsq.util;

import org.fsq.dto.types.ArmorTypesDto;
import org.fsq.entity.item.equipment.armor.Armor;
import org.fsq.entity.item.equipment.armor.detail.ArmorProperties;
import org.fsq.entity.item.equipment.types.ArmorTypes;
import org.fsq.entity.stats.armor.ArmorStatValues;
import org.fsq.dto.item.armor.ArmorDto;
import org.fsq.dto.item.armor.detail.ArmorPropertiesDto;
import org.fsq.dto.stats.armor.ArmorStatValuesDto;

import java.util.ArrayList;
import java.util.List;

public class TestArmorBuilder {
    public static Armor buildTestArmorWithStats(String name, Long id) {
        Armor result = buildTestArmor(name, id);
        result.setStats(getTestStats(id));
        return result;
    }

    public static Armor buildTestArmor(String name, Long id) {
        Armor result = buildTestArmor();
        result.setId(id);
        result.setNameUnique(name);
        return result;
    }

    private static Armor buildTestArmor() {
        Armor result = new Armor();
        result.setArmorProperties(buildArmorProperties());
        result.setStats(new ArrayList<>());
        return result;
    }

    private static ArmorProperties buildArmorProperties() {
        ArmorProperties armorProperties = new ArmorProperties();
        armorProperties.setArmorType(new ArmorTypes("Plate"));
        armorProperties.setArmorValue(10);

        return armorProperties;
    }

    private static List<ArmorStatValues> getTestStats(Long id) {
        List<ArmorStatValues> res = new ArrayList<>();
        res.add(new ArmorStatValues(id, 1, 2));
        res.add(new ArmorStatValues(id, 3, 4));
        return res;
    }


    public static ArmorDto buildTestArmorDtoWithStats(String name, Long id) {
        ArmorDto result = buildTestArmorDto(name, id);
        result.setStats(getDtoTestStats(id));
        return result;
    }

    public static ArmorDto buildTestArmorDto(String name, Long id) {
        ArmorDto result = buildTestArmorDto();
        result.setId(id);
        result.setNameUnique(name);
        return result;
    }

    private static ArmorDto buildTestArmorDto() {
        ArmorDto result = new ArmorDto();
        result.setArmorProperties(buildDtoArmorProperties());
        result.setStats(new ArrayList<>());
        return result;
    }

    private static ArmorPropertiesDto buildDtoArmorProperties() {
        ArmorPropertiesDto armorProperties = new ArmorPropertiesDto();
        armorProperties.setArmorType(new ArmorTypesDto("Plate"));
        armorProperties.setArmorValue(10);

        return armorProperties;
    }

    private static List<ArmorStatValuesDto> getDtoTestStats(Long id) {
        List<ArmorStatValuesDto> res = new ArrayList<>();
        res.add(new ArmorStatValuesDto(id, 1, 2));
        res.add(new ArmorStatValuesDto(id, 3, 4));
        return res;
    }
}
