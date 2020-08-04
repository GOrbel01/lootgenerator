package org.fsq.entity.item.equipment.armor;

import org.fsq.entity.item.equipment.armor.detail.ArmorProperties;
import org.fsq.entity.stats.armor.ArmorStatValues;
import org.fsq.entity.item.equipment.EquipmentType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.util.List;
import java.util.Objects;

@Entity(name = "Armor")
public class Armor {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "armidgen")
    @SequenceGenerator(name="armidgen", sequenceName = "armid_seq", allocationSize=1)
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equip_type", referencedColumnName = "id")
    private EquipmentType equipmentType;

    @Column(name = "name_unique")
    private String nameUnique;

    @Column(name = "name_prefix")
    private String namePrefix;

    @Column(name = "name_middle")
    private String nameMiddle;

    @Column(name = "name_suffix")
    private String nameSuffix;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "armor_properties_id", referencedColumnName = "id")
    private ArmorProperties armorProperties;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "armor_id", referencedColumnName = "id")
    private List<ArmorStatValues> stats;

    public Armor() {

    }

    public Armor(String nameUnique, String namePrefix, String nameSuffix, ArmorProperties armorProperties, List<ArmorStatValues> stats) {
        this.nameUnique = nameUnique;
        this.namePrefix = namePrefix;
        this.nameSuffix = nameSuffix;
        this.armorProperties = armorProperties;
        this.stats = stats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Armor(ArmorProperties armorProperties) {
        this.armorProperties = armorProperties;
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

    public ArmorProperties getArmorProperties() {
        return armorProperties;
    }

    public void setArmorProperties(ArmorProperties armorProperties) {
        this.armorProperties = armorProperties;
    }

    public List<ArmorStatValues> getStats() {
        return stats;
    }

    public void setStats(List<ArmorStatValues> stats) {
        this.stats = stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armor armor = (Armor) o;
        return Objects.equals(id, armor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
