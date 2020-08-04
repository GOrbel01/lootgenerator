package org.fsq.mapper.item.armor;

import org.fsq.entity.item.equipment.armor.Armor;
import org.fsq.dto.item.armor.ArmorDto;
import org.fsq.util.TestArmorBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {org.fsq.mapper.item.armor.ArmorMapperImpl.class})
public class ArmorMapperTest {

    @Autowired
    private ArmorMapper armorMapper;

    @Test
    public void testArmorToArmorDtoMapping() {
        Long testId = 1L;
        String testName = "Test Armor";
        String testType = "Plate";
        Armor source = TestArmorBuilder.buildTestArmorWithStats(testName, testId);
        ArmorDto dto = armorMapper.
                armorToArmorDto(source);
        Assert.assertNotNull(dto);
        Assert.assertNotNull(dto.getStats());
        assertEquals(testName, dto.getNameUnique());
        assertEquals(testType, dto.getArmorProperties().getArmorType().getType());
        assertEquals(testId, dto.getId());
        assertEquals(Integer.valueOf(1), dto.getStats().get(0).getStat());
    }

    @Test
    public void testArmorDtoToArmorMapping() {
        Long testId = 1L;
        String testName = "Test Armor";
        String testType = "Plate";

        ArmorDto dto = TestArmorBuilder.buildTestArmorDtoWithStats(testName, testId);
        Armor armor = armorMapper.armorDtoToArmor(dto);
        Assert.assertNotNull(armor);
        Assert.assertNotNull(armor.getStats());
        Assert.assertEquals(testName, armor.getNameUnique());
        Assert.assertEquals(testType, armor.getArmorProperties().getArmorType().getType());
        Assert.assertEquals(testId, armor.getId());
        Assert.assertEquals(Integer.valueOf(1), armor.getStats().get(0).getStat());
    }
}
