package com.example.productservice.inheritanceExamples.joinedTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JTUserRespository extends JpaRepository<User,Long> {

    User save(User user);

    Optional<User> findById(Long id) ;
}
