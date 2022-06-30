package com.bishop.student_management_system.controller;

import com.bishop.student_management_system.entity.Student;
import com.bishop.student_management_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001", allowedHeaders = "*")
public class StudentController {


    private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    //handler method to handle list of students and return mode and view
    @GetMapping("/students")
    public List<Student> listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return studentService.getAllStudents();

    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //create new student object to hold new student data
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/new";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }
}
