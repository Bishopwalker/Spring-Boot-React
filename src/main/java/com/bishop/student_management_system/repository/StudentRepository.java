package com.bishop.student_management_system.repository;

import com.bishop.student_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository  extends JpaRepository<Student, Long> {

void deleteById(Long id);

@Query("SELECT s FROM Student s WHERE s.firstName = ?1")
Optional<Student> findByName(String name);


@Override
Optional<Student> findById(Long id);

@Override
Student save(Student student);

}
