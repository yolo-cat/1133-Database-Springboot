package edu.fcu.cs1133.repository;

import edu.fcu.cs1133.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
    // JpaRepository already provides methods for CRUD operations
    // You can define custom query methods here if needed
    Optional<Student> findByUsername(String username);
}
