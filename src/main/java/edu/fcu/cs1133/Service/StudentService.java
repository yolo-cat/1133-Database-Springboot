package edu.fcu.cs1133.Service;

import edu.fcu.cs1133.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

  @Autowired
  private DatabaseService dbService;

  public List<Student> getAllStudents() {
    List<Student> students = new ArrayList<>();
    String sql = "SELECT * FROM Student";
    try (Connection conn = dbService.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
      while (rs.next()) {
        int studentId = rs.getInt("student_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        String dateOfBirth = rs.getString("date_of_birth");
        Student student = new Student(studentId, firstName, lastName, email, dateOfBirth);
        students.add(student);
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return students;
  }

  public Student createStudent(Student student) {
    String sql = "INSERT INTO Student(first_name, last_name, email, date_of_birth) VALUES(?, ?, ?, ?)";
    try (Connection conn = dbService.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      pstmt.setString(1, student.getFirstName());
      pstmt.setString(2, student.getLastName());
      pstmt.setString(3, student.getEmail());
      pstmt.setString(4, student.getBirthday());
      int affectedRows = pstmt.executeUpdate();
      if (affectedRows > 0) {
        try (ResultSet rs = pstmt.getGeneratedKeys()) {
          if (rs.next()) {
            student.setStudentId(rs.getInt(1));
          }
        }
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return student;
  }

  public Student updateStudent(int id, Student student) {
    String sql = "UPDATE Student SET first_name = ?, last_name = ?, email = ?, date_of_birth = ? WHERE student_id = ?";
    try (Connection conn = dbService.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, student.getFirstName());
      pstmt.setString(2, student.getLastName());
      pstmt.setString(3, student.getEmail());
      pstmt.setString(4, student.getBirthday());
      pstmt.setInt(5, id);
      pstmt.executeUpdate();
      student.setStudentId(id);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return student;
  }

  public void deleteStudent(int id) {
    String sql = "DELETE FROM Student WHERE student_id = ?";
    try (Connection conn = dbService.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }
}
