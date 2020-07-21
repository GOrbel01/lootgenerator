package org.fsq.dto.item.armor.detail;

import org.fsq.dto.types.ArmorTypesDto;

public class ArmorPropertiesDto {
    private Long Id;
    private Integer armorValue;
    private ArmorTypesDto armorType;

    public ArmorPropertiesDto() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(Integer armorValue) {
        this.armorValue = armorValue;
    }

    public ArmorTypesDto getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorTypesDto armorType) {
        this.armorType = armorType;
    }
}
