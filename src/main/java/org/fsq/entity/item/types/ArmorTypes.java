package org.fsq.entity.item.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArmorTypes {
    @Id
    private Long Id;

    @Column(name = "type_name")
    private String type;

    public ArmorTypes() {

    }

    public ArmorTypes(String type) {
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
