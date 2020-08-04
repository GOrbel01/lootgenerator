package org.fsq.entity.item.equipment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eqtypeidgen")
    @SequenceGenerator(name="eqtypeidgen", sequenceName = "eqtype_seq", allocationSize=1)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
