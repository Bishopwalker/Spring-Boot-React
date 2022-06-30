package com.bishop.student_management_system;

import com.bishop.student_management_system.entity.Student;
import com.bishop.student_management_system.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

   // @Bean
CommandLineRunner run(StudentService studentService) {
        return args -> {
            studentService.addStudent(new Student(null, "Johnny","Big-John","smoke.gov"));
            studentService.addStudent(new Student(null, "John","Lil-John", "email.gov"));
            studentService.addStudent(new Student(null, "Jane","Jane-Jane", "email.gov"));
            studentService.addStudent(new Student(null, "Jenny","Jenny-Jenny", "email.gov"));
        };
    }
}
