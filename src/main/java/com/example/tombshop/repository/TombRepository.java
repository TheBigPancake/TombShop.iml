package com.example.tombshop.repository;

import com.example.tombshop.model.Master;
import com.example.tombshop.model.Tomb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TombRepository extends JpaRepository<Tomb, Integer> {
    @Query(value =
            "SELECT * FROM tombs " +
                    "WHERE tomb_id IN " +
                    "(SELECT tomb_id FROM order_tombs " +
                    "WHERE order_id = :order_id);",
            nativeQuery = true)
    List<Tomb> getOrderTombs(Integer order_id);
}
