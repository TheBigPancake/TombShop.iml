package com.example.tombshop.repository;

import com.example.tombshop.model.Tomb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TombRepository extends JpaRepository<Tomb, Long> {

}
