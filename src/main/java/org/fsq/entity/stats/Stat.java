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
}
