package ra.edu.demo_courses.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.demo_courses.dto.DataResponse;
import ra.edu.demo_courses.entity.Course;
import ra.edu.demo_courses.exception.NotFoundException;
import ra.edu.demo_courses.service.ICourseService;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final ICourseService courseService;
//    lấy danh sách
    @GetMapping
    public ResponseEntity<DataResponse<List<Course>>> getAllCourses(){
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

//    lấy Id
    @GetMapping("/{course_id}")
    public ResponseEntity<DataResponse<Course>> getCourseById(@PathVariable Long course_id) throws NotFoundException {
        return new ResponseEntity<>(courseService.getCourseById(course_id), HttpStatus.OK);
    }
//    thêm mới
    @PostMapping
    public ResponseEntity<DataResponse<Course>> createCourse(@Valid @RequestBody Course course) {
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }
//    cập nhật
    @PutMapping("/{course_id}")
    public ResponseEntity<DataResponse<Course>> updateCourse(@Valid @RequestBody Course course, @PathVariable Long course_id) throws NotFoundException {
        return new ResponseEntity<>(courseService.updateCourse(course, course_id), HttpStatus.CREATED);
    }
//    xóa

    @DeleteMapping("/{course_id}")
    public ResponseEntity<DataResponse<Objects>> deleteCourse(@PathVariable Long course_id) throws NotFoundException {
        courseService.deleteCourseById(course_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
