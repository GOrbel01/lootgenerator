package org.fsq.io.repo.armor;

import org.fsq.entity.item.equipment.armor.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArmorRepository extends JpaRepository<Armor, Long> {
    @Query(value = "SELECT arm FROM Armor arm WHERE arm.id = :id")
    Armor fetchArmor(@Param("id") Long id);
}
