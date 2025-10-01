package com.example.session5.service;

import com.example.session5.model.dto.EnrollmentDTO;
import com.example.session5.model.entity.Enrollment;
import com.example.session5.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public Enrollment findById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    public Enrollment save(EnrollmentDTO enrollmentDTO) {
        return enrollmentRepository.save(convertEnrollmentDTOToEnrollment(enrollmentDTO));
    }

    public Enrollment update(Long id, EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = findById(id);
        if (enrollment != null) {
           Enrollment newEnrollment = convertEnrollmentDTOToEnrollment(enrollmentDTO);
           enrollment.setId(id);
            return enrollmentRepository.save(newEnrollment);
        }else {
            return null;
        }

    }

    public String delete(Long id) {
        Enrollment enrollment = findById(id);
        if (enrollment != null) {
            try {
                enrollmentRepository.delete(enrollment);
                return "Enrollment deleted successfully";
            } catch (Exception e) {
                return "Error while deleting enrollment";
            }

        }else {
            return "Enrollment not found";
        }

    }

    public Enrollment convertEnrollmentDTOToEnrollment(EnrollmentDTO enrollmentDTO) {
        return Enrollment
                .builder()
                .enrollmentDate(LocalDate.now())
                .student(studentService.findById(enrollmentDTO.getStudentId()))
                .course(courseService.findById(enrollmentDTO.getCourseId()))
                .build();
    }
}