package com.example.tombshop.repository;

import com.example.tombshop.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    @Query(value =
            "SELECT * FROM tags " +
                    "WHERE tag_id IN " +
                    "(SELECT tag_id FROM tomb_tags " +
                    "WHERE tomb_id = :tomb_id);",
            nativeQuery = true)
    List<Tag> getTombTags(Integer tomb_id);
}
