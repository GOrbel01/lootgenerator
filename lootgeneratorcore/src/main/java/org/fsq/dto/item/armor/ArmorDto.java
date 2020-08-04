package org.fsq.dto.item.armor;

import org.fsq.dto.item.armor.detail.ArmorPropertiesDto;
import org.fsq.dto.stats.armor.ArmorStatValuesDto;

import java.io.Serializable;
import java.util.List;

public class ArmorDto implements Serializable {
    private Long Id;
    private String nameUnique;
    private String namePrefix;
    private String nameMiddle;
    private String nameSuffix;
    private ArmorPropertiesDto armorProperties;
    private List<ArmorStatValuesDto> stats;

    public ArmorDto() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNameUnique() {
        return nameUnique;
    }

    public void setNameUnique(String nameUnique) {
        this.nameUnique = nameUnique;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getNameMiddle() {
        return nameMiddle;
    }

    public void setNameMiddle(String nameMiddle) {
        this.nameMiddle = nameMiddle;
    }

    public String getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public ArmorPropertiesDto getArmorProperties() {
        return armorProperties;
    }

    public void setArmorProperties(ArmorPropertiesDto armorProperties) {
        this.armorProperties = armorProperties;
    }

    public List<ArmorStatValuesDto> getStats() {
        return stats;
    }

    public void setStats(List<ArmorStatValuesDto> stats) {
        this.stats = stats;
    }
}
