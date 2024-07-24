package com.krish.springbootjpa.practice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
//@Table(name = "T_STUDENT")  // to change table name in DB
public class Student {
    @Id
    @GeneratedValue()
    private Integer id;
    @Column(name = "FNAME", length = 20)  // changes column in DB
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile studentProfile;
    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;
    @Column(updatable = false)   // true by default
    private String someColumn;


    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSomeColumn() {
        return someColumn;
    }

    public void setSomeColumn(String someColumn) {
        this.someColumn = someColumn;
    }

    public Student(String firstName, String lastName, String email, int age, String someColumn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.someColumn = someColumn;
    }
}
