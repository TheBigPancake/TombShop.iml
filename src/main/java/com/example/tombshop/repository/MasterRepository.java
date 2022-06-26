package com.example.tombshop.repository;


import com.example.tombshop.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterRepository extends JpaRepository<Master, Integer> {
    @Query(value =
            "SELECT * FROM masters " +
                    "WHERE master_id IN " +
                    "(SELECT master_id FROM tomb_masters " +
                    "WHERE tomb_id = :tomb_id);",
            nativeQuery = true)
    List<Master> getTombMasters(Integer tomb_id);
}
