package org.fsq.dto.stats;

public class StatDto {
    private Long Id;
    private String statName;

    public StatDto() {

    }

    public StatDto(String statName) {
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
