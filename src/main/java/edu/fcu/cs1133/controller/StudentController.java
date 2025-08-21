//package edu.fcu.cs1133.controller;
//
//import edu.fcu.cs1133.Service.StudentService;
//import edu.fcu.cs1133.model.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
////使用 @tag 撰寫 student API 說明文字
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//@Tag(name = "Student API", description = "Operations related to students")
//
//@RestController
//@RequestMapping("/api/students")
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//
//    @GetMapping
//    public List<Student> getAllStudents() {
//        return studentService.getAllStudents();
//    }
//
//    @PostMapping
//    public Student createStudent(@RequestBody Student student) {
//        return studentService.createStudent(student);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
//        Student updatedStudent = studentService.updateStudent(id, studentDetails);
//        return ResponseEntity.ok(updatedStudent);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
//        studentService.deleteStudent(id);
//        return ResponseEntity.noContent().build();
//    }
//}
