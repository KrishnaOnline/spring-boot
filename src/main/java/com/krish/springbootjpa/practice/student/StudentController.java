package com.krish.springbootjpa.practice.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.HashMap;

@RestController
public class StudentController {
    // Constructor Injection (RECOMMENDED)
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto createStudent(
        @Valid @RequestBody StudentDto studentDto
    ) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() {
        return this.studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto getStudentById(@PathVariable("student-id") Integer id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-email}")
    public List<StudentResponseDto> findStudentsByEmail(@PathVariable("student-email") String mail) {
        return studentService.findStudentsByEmail(mail);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("student-id") Integer id) {
        this.studentService.deleteStudentById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException exception
    ) {
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors()
                                    .forEach(error -> {
                                        var fieldName = ((FieldError) error).getField();
                                        var errorMessage = error.getDefaultMessage();
                                        errors.put(fieldName, errorMessage);
                                    });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
