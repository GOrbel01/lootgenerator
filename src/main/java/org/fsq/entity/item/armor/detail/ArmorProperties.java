package org.fsq.entity.item.armor.detail;

import org.fsq.entity.stats.armor.ArmorStatValues;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Entity
public class ArmorProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "armpropidgen")
    @SequenceGenerator(name="armpropidgen", sequenceName = "armpropid_seq", allocationSize=1)
    private Long Id;

    @Column(name = "armor_value")
    private Integer armorValue;

    @Column(name = "armor_type")
    private String armorType;

    public ArmorProperties() {

    }

    public ArmorProperties(Integer armorValue, String armorType, List<ArmorStatValues> stats) {
        this.armorValue = armorValue;
        this.armorType = armorType;
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

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

}
