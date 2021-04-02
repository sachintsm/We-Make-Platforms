package com.javamastermind.com.sms.service;

import java.util.List;
import java.util.Optional;

import com.javamastermind.com.sms.domain.Student;
import org.springframework.stereotype.Service;


public interface StudentService {

	public List<Student> getAllStudentData();

	public Optional<Student> findStudentById(int id);

	public boolean saveOrUpdateStudentData(Student student);

	public boolean deleteStudentData(Student student);
}
