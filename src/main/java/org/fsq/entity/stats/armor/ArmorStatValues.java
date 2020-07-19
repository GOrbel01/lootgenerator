package org.fsq.entity.stats.armor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity(name = "ArmorStats")
public class ArmorStatValues {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "armstatidgen")
    @SequenceGenerator(name="armstatidgen", sequenceName = "armstatid_seq", allocationSize=1)
    private Long Id;

    @Column(name = "armor_id")
    private Long armorId;

    @Column(name = "stat_type")
    private Integer stat;

    @Column(name = "stat_value")
    private Integer statValue;

    public ArmorStatValues() {

    }

    public ArmorStatValues(Integer stat, Integer statValue) {
        this.armorId = armorId;
        this.stat = stat;
        this.statValue = statValue;
    }

    public ArmorStatValues(Long armorId, Integer stat, Integer statValue) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArmorStatValues that = (ArmorStatValues) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
