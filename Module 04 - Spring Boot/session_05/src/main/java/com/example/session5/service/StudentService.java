package com.example.session5.service;

import com.example.session5.model.dto.StudentDTO;
import com.example.session5.model.entity.Student;
import com.example.session5.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student save(StudentDTO studentDTO) {
        return studentRepository.save(convertStudentDTOToStudent(studentDTO));
    }

    public Student update(Long id, StudentDTO studentDTO) {
        Student student = findById(id);
        if (student != null) {
            Student updatedStudent = convertStudentDTOToStudent(studentDTO);
            updatedStudent.setId(id);
            return studentRepository.save(updatedStudent);
        }else {
            return null;
        }
    }

    public String delete(Long id) {
        Student student = findById(id);
        if (student != null) {
            try {
                studentRepository.delete(student);
                return "Student deleted successfully";
            }catch (Exception e) {
                return "Student delete failed";
            }
        }else {
            return "Student not found";
        }

    }

    public Student convertStudentDTOToStudent(StudentDTO studentDTO) {
        return Student
                .builder()
                .email(studentDTO.getEmail())
                .name(studentDTO.getName())
                .phoneNumber(studentDTO.getPhoneNumber())
                .build();
    }
}
