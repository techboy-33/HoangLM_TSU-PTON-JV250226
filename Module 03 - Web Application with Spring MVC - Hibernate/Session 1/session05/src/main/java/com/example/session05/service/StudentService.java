package com.example.session05.service;

import com.example.session05.model.Student;
import com.example.session05.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(String search , String sort) {
        return studentRepository.getStudents(search, sort);
    }

    public boolean addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public boolean updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public boolean deleteStudentById(Long id) {
        return studentRepository.deleteStudentById(id);
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }
}
