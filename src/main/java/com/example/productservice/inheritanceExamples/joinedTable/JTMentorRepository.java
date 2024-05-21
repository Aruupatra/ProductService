package com.example.productservice.inheritanceExamples.joinedTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JTMentorRepository extends JpaRepository<Mentor,Long> {

    Mentor save(Mentor mentor);
    Optional<Mentor> findById(Long id);
}
