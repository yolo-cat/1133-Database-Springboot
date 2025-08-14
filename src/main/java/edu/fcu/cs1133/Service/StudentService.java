package edu.fcu.cs1133.Service;

import edu.fcu.cs1133.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String dateOfBirthbirth = rs.getString("date_of_birth");

        Student student = new Student(studentId, firstName, lastName, email, dateOfBirthbirth);
//        student.setStudentId(rs.getInt("student_id"));
//        student.setFirstName(rs.getString("first_name"));
//        student.setLastName(rs.getString("last_name"));
//        student.setBirthday(rs.getString("date_of_birth"));
//        student.setEmail(rs.getString("email"));
//        student.setAddress(rs.getString("address"));
        students.add(student);
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return students;
  }
}
