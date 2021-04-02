package com.javamastermind.com.sms.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javamastermind.com.sms.domain.ErrorResponse;
import com.javamastermind.com.sms.domain.Student;
import com.javamastermind.com.sms.service.StudentService;
import com.javamastermind.com.sms.util.EndPoint;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //find all student
    @GetMapping(value = EndPoint.GETSTUDENT)
    public ResponseEntity<?> getAllStudentData() {
        return new ResponseEntity<>(studentService.getAllStudentData(), HttpStatus.ACCEPTED);
    }

    //save Student
    @PostMapping(value = EndPoint.SAVESTUDENT)
    public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student) {
        if (Objects.nonNull(studentService.getAllStudentData())) {
            return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    //find single student
    @GetMapping(value = EndPoint.FINDSTUDENT)
    public ResponseEntity<?> findStudent(@RequestParam int id) {
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.ACCEPTED);
    }

    //delete student
    @DeleteMapping(value = EndPoint.DELETESTUDENT)
    public ResponseEntity<?> deleteStudent(Student student) {
        System.out.println("hello");
        if (!studentService.deleteStudentData(student)) {
            return new ResponseEntity<>("Student "+student.getId() + "is successfully deleted!", HttpStatus.ACCEPTED);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode("400");
            errorResponse.setErrorDiscription("Student deletion unsuccessful!");
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }
    }

    //update student
    @PutMapping(value = EndPoint.UPDATESTUDENT)
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        if (Objects.nonNull(studentService.saveOrUpdateStudentData(student))) {
            return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode("400");
            errorResponse.setErrorDiscription("Invalid student data!");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
