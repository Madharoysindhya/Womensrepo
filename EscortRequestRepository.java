package com.campus.safety.repository;

import com.campus.safety.entity.EscortRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EscortRequestRepository extends JpaRepository<EscortRequest, Long> {
    @Query("select r from EscortRequest r where lower(r.studentName) like lower(concat('%', :keyword, '%')) " +
           "or lower(r.studentId) like lower(concat('%', :keyword, '%')) " +
           "or lower(r.pickupLocation) like lower(concat('%', :keyword, '%')) " +
           "or lower(r.destination) like lower(concat('%', :keyword, '%'))")
    List<EscortRequest> search(@Param("keyword") String keyword);
}
