package com.example.session5.controller;

import com.example.session5.model.dto.InstructorDTO;
import com.example.session5.model.entity.Instructor;
import com.example.session5.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Instructor> addInstructor(@RequestBody InstructorDTO instructorDTO) {
        return new ResponseEntity<>(instructorService.save(instructorDTO), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody InstructorDTO instructorDTO) {
        Instructor updatedInstructor = instructorService.update(id, instructorDTO);
        return ResponseEntity.ok(updatedInstructor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long id) {
       return new ResponseEntity<>(instructorService.delete(id), HttpStatus.OK);
    }
}
