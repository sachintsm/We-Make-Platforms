package com.javamastermind.com.sms.controller;

import java.util.*;

import com.javamastermind.com.sms.domain.SuccessResponse;
import com.javamastermind.com.sms.util.ResponseCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javamastermind.com.sms.domain.ErrorResponse;
import com.javamastermind.com.sms.domain.Student;
import com.javamastermind.com.sms.service.StudentService;
import com.javamastermind.com.sms.util.EndPoint;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // find all student
    @GetMapping(value = EndPoint.GETSTUDENT)
    public ResponseEntity<?> getAllStudentData() {
        return new ResponseEntity<>(studentService.getAllStudentData(), HttpStatus.ACCEPTED);
    }

    // find single student
    @GetMapping(value = EndPoint.FINDSTUDENT)
    public ResponseEntity<?> findStudent(@RequestParam int id) {
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.ACCEPTED);
    }

    // save Student
    @PostMapping(value = EndPoint.SAVESTUDENT)
    public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student) {
        System.out.println(student);
        System.out.println(student.toString());
        studentService.saveOrUpdateStudentData(student);
//        if (Objects.nonNull(studentService.getAllStudentData())) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setResponseCode(ResponseCodes.succefullyAdded);
            successResponse.setMessage("Student data successfully saved!");
            return new ResponseEntity<>(successResponse, HttpStatus.ACCEPTED);
//        } else {
//            ErrorResponse errorResponse = new ErrorResponse();
//            errorResponse.setResponseCode(ResponseCodes.failiureToAdd);
//            errorResponse.setMessage("Student data saving unsuccessful!");
//            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//        }
    }

    // delete student
    @DeleteMapping(value = EndPoint.DELETESTUDENT)
    public ResponseEntity<?> deleteStudent(Student student) {
        if (!studentService.deleteStudentData(student)) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setResponseCode(ResponseCodes.successfullyDeleted);
            successResponse.setMessage("Student successfully deleted!");
            return new ResponseEntity<>(successResponse, HttpStatus.ACCEPTED);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setResponseCode(ResponseCodes.failiureToDelete);
            errorResponse.setMessage("Student deletion unsuccessful!");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    // update student
    @PutMapping(value = EndPoint.UPDATESTUDENT)
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        if (Objects.nonNull(studentService.saveOrUpdateStudentData(student))) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setResponseCode(ResponseCodes.successfullyUpdated);
            successResponse.setMessage("Student successfully updated!");

            Set<Object> studentSet = new HashSet<>();
            studentSet.add(student);
            successResponse.setResponseObject(studentSet);

            return new ResponseEntity<>(successResponse, HttpStatus.ACCEPTED);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setResponseCode(ResponseCodes.failiureToUpdate);
            errorResponse.setMessage("Invalid student data!");

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
