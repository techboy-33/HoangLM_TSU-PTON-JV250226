package com.example.session5.controller;
import com.example.session5.model.dto.CourseDTO;
import com.example.session5.model.entity.Course;
import com.example.session5.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.save(courseDTO), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.update(id,courseDTO),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
       boolean result = courseService.delete(id);
       if(result) {
           return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
       }else {
           return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
       }
    }
}
