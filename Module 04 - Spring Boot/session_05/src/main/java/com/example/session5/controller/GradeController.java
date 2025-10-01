package com.example.session5.controller;

import com.example.session5.model.dto.GradeDTO;
import com.example.session5.model.entity.Grade;
import com.example.session5.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        return new ResponseEntity<>(gradeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Grade> addGrade(@RequestBody GradeDTO gradeDTO) {
        return new ResponseEntity<>(gradeService.save(gradeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody GradeDTO gradeDTO) {
        Grade updatedGrade = gradeService.update(id, gradeDTO);
        return ResponseEntity.ok(updatedGrade);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGrade(@PathVariable Long id) {
       return new ResponseEntity<>(gradeService.delete(id), HttpStatus.OK);
    }
}
