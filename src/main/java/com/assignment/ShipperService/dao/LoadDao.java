package com.assignment.ShipperService.dao;

import com.assignment.ShipperService.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadDao extends JpaRepository<Load, Integer> {
    @Query("SELECT * FROM load WHERE shipper_id=shipperId")
    List<Load> findAllByShipperId(@Param(value = "shipperId") Integer shipperId);
}
