package com.example.productservice.inheritanceExamples.tablePerClass;

import com.example.productservice.inheritanceExamples.joinedTable.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableMentorRepository extends JpaRepository<Mentor,Long> {

    Mentor save(Mentor mentor);
    Optional<Mentor> findById(Long id);
}
