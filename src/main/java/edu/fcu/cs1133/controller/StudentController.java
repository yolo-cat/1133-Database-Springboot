package edu.fcu.cs1133.controller;

import edu.fcu.cs1133.Service.StudentService;
import edu.fcu.cs1133.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {


  @Autowired
  StudentService studnetService;

  @GetMapping
  public List<Student> getAllStudents() {
    return studnetService.getAllStudents();
  }


  //    private List<Student> students = new ArrayList<>();

//    public StudentController() {
//        students.add(new Student(1, "Tom", "Chen", "tom@fcu.edu.tw", "2000-01-01"));
//    }
//
//    @PostMapping
//    public Student createStudent(@RequestBody Student student) {
//        student.setStudentId (students.size() + 1);
//        students.add(student);
//        return student;
//    }
//
//    @GetMapping("/{id}")
//    public Student getStudent(@PathVariable int id) {
//        for (Student student: students) {
//            if (student.getStudentId() == id) {
//                return student;
//            }
//        }
//        return null;
//    }
//
//    @GetMapping
//    public List<Student> getAllStudents() {
//        return students;
//    }
//
//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
//        for (Student student: students) {
//            if (student.getStudentId() == id) {
//                student.setFirstName(studentDetails.getFirstName());
//                student.setLastName(studentDetails.getLastName());
//                student.setEmail(studentDetails.getEmail());
//                student.setBirthday(studentDetails.getBirthday());
//                return student;
//            }
//        }
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteStudent(@PathVariable int id) {
//        for (Student student: students) {
//            if (student.getStudentId() == id) {
//                students.remove(student);
//                return;
//            }
//        }
//    }
}
