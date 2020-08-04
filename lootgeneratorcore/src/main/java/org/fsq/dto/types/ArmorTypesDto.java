package org.fsq.dto.types;

public class ArmorTypesDto {
    private Long Id;
    private String type;

    public ArmorTypesDto() {

    }

    public ArmorTypesDto(String type) {
        this.type = type;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
