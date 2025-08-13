package edu.fcu.cs1133.model;

import lombok.Data;

@Data
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String birthday;
    
    public Student() {}

    public Student(int studentId, String firstName, String lastName, String email, String birthday) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }
}   