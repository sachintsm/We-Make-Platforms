package com.javamastermind.com.sms.controller;

import java.util.*;

import com.javamastermind.com.sms.domain.SuccessResponse;
import com.javamastermind.com.sms.util.ResponseCodes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    // find all student
    @GetMapping(value = EndPoint.GETSTUDENT)
    public ResponseEntity<?> getAllStudentData() {
        logger.info("Request initiate to get all student. Url {}", EndPoint.GETSTUDENT);
        return new ResponseEntity<>(studentService.getAllStudentData(), HttpStatus.ACCEPTED);
    }

    // find single student
    @GetMapping(value = EndPoint.FINDSTUDENT)
    public ResponseEntity<?> findStudent(@RequestParam int id) {
        logger.info("Request initiate to get student, student id {}. Url {}", id, EndPoint.FINDSTUDENT);
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.ACCEPTED);
    }

    // save Student
    @PostMapping(value = EndPoint.SAVESTUDENT)
    public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student) {
        logger.info("Request initiate to save new student. Url {}", EndPoint.SAVESTUDENT);

        if (studentService.saveOrUpdateStudentData(student)) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setResponseCode(ResponseCodes.succefullyAdded);
            successResponse.setMessage("Student data successfully saved!");

            logger.info("Student successfully saved! Data {}", student.toString());

            return new ResponseEntity<>(successResponse, HttpStatus.ACCEPTED);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setResponseCode(ResponseCodes.failiureToAdd);
            errorResponse.setMessage("Student data saving unsuccessful!");

            logger.error("Student data saving unsuccessful! Data {}", student.toString());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    // delete student
    @DeleteMapping(value = EndPoint.DELETESTUDENT)
    public ResponseEntity<?> deleteStudent(@RequestParam("id") int id) {
        logger.info("Request initiate to delete student id {}.", id);
        logger.info("Request url {} ", EndPoint.DELETESTUDENT);
        if (studentService.deleteStudentData(id)) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setResponseCode(ResponseCodes.successfullyDeleted);
            successResponse.setMessage("Student successfully deleted!");

            logger.info("Student successfully deleted!");

            return new ResponseEntity<>(successResponse, HttpStatus.ACCEPTED);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setResponseCode(ResponseCodes.failiureToDelete);
            errorResponse.setMessage("Student deletion unsuccessful!");
            logger.error("Student deletion unsuccessful!");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    // update student
    @PutMapping(value = EndPoint.UPDATESTUDENT)
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        logger.info("Request initiate to update student {}.", student.toString());
        logger.info("Request url {} ", EndPoint.UPDATESTUDENT);
        if (Objects.nonNull(studentService.saveOrUpdateStudentData(student))) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setResponseCode(ResponseCodes.successfullyUpdated);
            successResponse.setMessage("Student successfully updated!");

            Set<Object> studentSet = new HashSet<>();
            studentSet.add(student);
            successResponse.setResponseObject(studentSet);
            logger.info("Student successfully updated! Data {}", student.toString());
            return new ResponseEntity<>(successResponse, HttpStatus.ACCEPTED);
        } else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setResponseCode(ResponseCodes.failiureToUpdate);
            errorResponse.setMessage("Invalid student data!");
            logger.error("Invalid student data! Data : {}", student.toString());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
