package com.bishop.student_management_system.service.impl;

import com.bishop.student_management_system.entity.Student;
import com.bishop.student_management_system.exception.StudentException;
import com.bishop.student_management_system.repository.StudentRepository;
import com.bishop.student_management_system.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        log.info("Fetching all students");
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()){
            log.info("No students found");
            throw new StudentException("You ain't got no students");
        }
        log.info("Found {} students", students.size());
        return students;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        log.info("Fetching student with id {}", id);
      Optional<Student> student = studentRepository.findById(id);
      student.orElseThrow(() -> new StudentException("Student not found"));
        log.info("Student found");
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        log.info("Adding student {}", student);
     return  studentRepository.save(student);

    }

}
