package com.javamastermind.com.sms.service.impl;

import java.util.List;
import java.util.Optional;

import com.javamastermind.com.sms.Repository.StudentRepository;
import com.javamastermind.com.sms.domain.Student;
import com.javamastermind.com.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudentData() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean saveOrUpdateStudentData(Student student) {
        return studentRepository.save(student) != null;
    }

    @Override
    public boolean deleteStudentData(Student student) {
        if (studentRepository.findById(student.getId()).isPresent()) {
            studentRepository.delete(student);
            return true;
        } else {
            return false;
        }
    }

}
