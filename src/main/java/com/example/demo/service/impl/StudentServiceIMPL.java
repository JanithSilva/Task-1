package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepository StudentRepository;

    @Override
    public List<Student> getAllStudents() {
        return  StudentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        StudentRepository.save(student);
    }
}
