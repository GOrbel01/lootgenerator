package org.fsq.entity.stats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Stat {
    @Id
    private Long Id;

    @Column(name = "stat_name")
    private String statName;

    public Stat() {

    }

    public Stat(String statName) {
        this.statName = statName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    @Override
    public String toString() {
        return statName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stat stat = (Stat) o;
        return Objects.equals(Id, stat.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
