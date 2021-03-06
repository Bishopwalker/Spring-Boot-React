package com.bishop.student_management_system.service;

import com.bishop.student_management_system.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

   Optional<Student> getStudentById(Long id);

    Student addStudent(Student student);   //add student to database

    void deleteStudent(Long id);

    Page<Student> getAllStudentsPaged(int page, int size);
}
