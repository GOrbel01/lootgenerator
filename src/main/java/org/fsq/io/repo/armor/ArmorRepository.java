package org.fsq.io.repo.armor;

import org.fsq.entity.item.armor.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArmorRepository extends JpaRepository<Armor, Long> {
    @Query(value = "SELECT arm FROM Armor arm WHERE arm.Id = :id")
    Armor fetchArmor(Long id);
}