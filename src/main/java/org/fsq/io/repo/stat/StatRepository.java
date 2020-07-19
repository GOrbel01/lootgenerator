package org.fsq.io.repo.stat;

import org.fsq.entity.stats.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Long> {

}
