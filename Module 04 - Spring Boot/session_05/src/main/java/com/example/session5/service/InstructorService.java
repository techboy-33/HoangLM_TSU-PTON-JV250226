package com.example.session5.service;

import com.example.session5.model.dto.InstructorDTO;
import com.example.session5.model.entity.Instructor;
import com.example.session5.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private DepartmentService departmentService;

    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    public Instructor findById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public Instructor save(InstructorDTO instructorDTO) {
        return instructorRepository.save(convertInstructorDTOToInstructor(instructorDTO));
    }

    public Instructor update(Long id, InstructorDTO instructorDTO) {
        Instructor instructor = findById(id);
        if (instructor != null) {
            Instructor updatedInstructor = convertInstructorDTOToInstructor(instructorDTO);
            updatedInstructor.setId(id);
            return instructorRepository.save(updatedInstructor);
        }else {
            return null;
        }

    }

    public String delete(Long id) {
        Instructor instructor = findById(id);
        if (instructor != null) {
            try {
                instructorRepository.delete(instructor);
                return "Instructor deleted";
            }catch (Exception e) {
                return "Instructor delete failed";
            }
        }else {
            return "Instructor not found";
        }

    }

    public Instructor convertInstructorDTOToInstructor(InstructorDTO instructorDTO) {
        return Instructor
                .builder()
                .name(instructorDTO.getName())
                .email(instructorDTO.getEmail())
                .department(departmentService.findById(instructorDTO.getDepartmentId()))
                .build();
    }
}
