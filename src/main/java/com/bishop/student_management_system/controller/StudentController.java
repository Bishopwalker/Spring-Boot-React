package com.bishop.student_management_system.controller;

import com.bishop.student_management_system.entity.Student;
import com.bishop.student_management_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
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

    @PostMapping("/students/new")
    public String createStudentForm(@RequestBody Student student){
        //create new student object to hold new student data
       ;
        log.info("New student object created"+student);
        studentService.addStudent(student);
        return "student/new";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        log.info("Deleting student with id {}", id);
        studentService.deleteStudent(id);
    }

    //Pagination
    @GetMapping("/students/page/{page}/{size}")
    public Page<Student> getAllStudentsPaged(@PathVariable int page, @PathVariable int size){
     int pageNumber= page ;
        int pageSize =size==0?10 : size;
        log.warn("Page number: {}", pageNumber);
        log.warn("Page size: {}", pageSize);
        return studentService.getAllStudentsPaged(pageNumber, pageSize);


    }
}
