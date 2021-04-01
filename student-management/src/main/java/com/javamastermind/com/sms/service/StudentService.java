package com.javamastermind.com.sms.service;

import java.util.Set;

import com.javamastermind.com.sms.domain.Student;

public interface StudentService {

	public Set<Student> getAllStudentData();

	public Student findStudentById(int id);

	public boolean saveOrUpdateStudentData(Student student);

	public boolean deleteStudentData(Student student);
}
