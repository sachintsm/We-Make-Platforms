package com.javamastermind.com.sms.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javamastermind.com.sms.domain.ErrorResponse;
import com.javamastermind.com.sms.domain.Student;
import com.javamastermind.com.sms.service.StudentService;
import com.javamastermind.com.sms.util.EndPoint;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping(value = EndPoint.GETSTUDENT)
	public ResponseEntity<?> addAllStudentData(Student student) {

		if (Objects.nonNull(studentService.getAllStudentData())) {

			return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
		} else {
			ErrorResponse errorResponse = new ErrorResponse();
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
	}

}
