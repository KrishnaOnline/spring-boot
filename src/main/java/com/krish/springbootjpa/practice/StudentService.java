package com.krish.springbootjpa.practice;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
            StudentDto studentDto
    ) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponse(savedStudent);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(Integer id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    public List<Student> findStudentsByEmail(String mail) {
        return studentRepository.findAllByEmailContaining(mail);
    }

    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
