package com.campus.safety.repository;

import com.campus.safety.entity.Escort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EscortRepository extends JpaRepository<Escort, Long> {
    List<Escort> findByAvailableTrue();
}
