package com.javamastermind.com.sms.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.javamastermind.com.sms.Repository.StudentRepository;
import com.javamastermind.com.sms.controller.StudentController;
import com.javamastermind.com.sms.domain.Student;
import com.javamastermind.com.sms.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LogManager.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudentData() {
        logger.info("Return students data to StudentController.class");
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(int id) {
        logger.info("Return student id {} data to StudentController.class", id);
        return studentRepository.findById(id);
    }

    @Override
    public boolean saveOrUpdateStudentData(Student student) {
        logger.info("Save or Update student data to the database.");
        return Objects.nonNull(studentRepository.save(student));
    }

    @Override
    public boolean deleteStudentData(int id) {
        try {
            studentRepository.deleteById(id);
            logger.info("Delete student id {} data in the database.", id);
            return true;
        } catch (Exception e) {
            logger.error("Exception occur when deleting student id {} data. Coursed by, {}", id, e);
            return false;
        }

    }

}
