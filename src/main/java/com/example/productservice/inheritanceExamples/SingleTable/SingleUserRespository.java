package com.example.productservice.inheritanceExamples.SingleTable;

import com.example.productservice.inheritanceExamples.joinedTable.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SingleUserRespository extends JpaRepository<User,Long> {

    User save(User user);

    Optional<User> findById(Long id) ;
}
