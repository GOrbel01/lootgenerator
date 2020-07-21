package org.fsq.dto.stats.armor;

import java.io.Serializable;

public class ArmorStatValuesDto implements Serializable {
    private Long Id;
    private Long armorId;
    private Integer stat;
    private Integer statValue;

    public ArmorStatValuesDto() {

    }

    public ArmorStatValuesDto(Long armorId, Integer stat, Integer statValue) {
        this.armorId = armorId;
        this.stat = stat;
        this.statValue = statValue;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getArmorId() {
        return armorId;
    }

    public void setArmorId(Long armorId) {
        this.armorId = armorId;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getStatValue() {
        return statValue;
    }

    public void setStatValue(Integer statValue) {
        this.statValue = statValue;
    }
}
