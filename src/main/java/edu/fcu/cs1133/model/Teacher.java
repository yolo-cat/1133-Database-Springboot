package edu.fcu.cs1133.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "teacher_id")
  private int teacherId;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "age")
  private int age;

//  public Teacher() {}
//  public Teacher(int teacherId, String name, String email, int age) {
//    this.teacherId = teacherId;
//    this.name = name;
//    this.email = email;
//    this.age = age;
//  }
}
