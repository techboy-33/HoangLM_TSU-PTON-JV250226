package com.example.session5.controller;

import com.example.session5.model.dto.EnrollmentDTO;
import com.example.session5.model.entity.Enrollment;
import com.example.session5.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return new ResponseEntity<>( enrollmentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        return new ResponseEntity<>(enrollmentService.save(enrollmentDTO), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody EnrollmentDTO enrollmentDTO) {
        Enrollment updatedEnrollment = enrollmentService.update(id, enrollmentDTO);
        return ResponseEntity.ok(updatedEnrollment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id) {
      return new ResponseEntity<>(enrollmentService.delete(id), HttpStatus.OK);
    }
}
