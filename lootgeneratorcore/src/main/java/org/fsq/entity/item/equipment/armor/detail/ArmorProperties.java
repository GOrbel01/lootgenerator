package org.fsq.entity.item.equipment.armor.detail;

import org.fsq.entity.item.equipment.types.ArmorTypes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ArmorProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "armpropidgen")
    @SequenceGenerator(name="armpropidgen", sequenceName = "armpropid_seq", allocationSize=1)
    private Long Id;

    @Column(name = "armor_value")
    private Integer armorValue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "armor_type_id", referencedColumnName = "id")
    private ArmorTypes armorType;

    public ArmorProperties() {

    }

    public ArmorProperties(Integer armorValue, ArmorTypes armorType) {
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

    public ArmorTypes getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorTypes armorType) {
        this.armorType = armorType;
    }

}
