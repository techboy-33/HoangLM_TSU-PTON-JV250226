package ra.edu.demo_courses.service;

import org.springframework.http.ResponseEntity;
import ra.edu.demo_courses.dto.DataResponse;
import ra.edu.demo_courses.entity.Course;
import ra.edu.demo_courses.exception.NotFoundException;

import java.util.List;

public interface ICourseService {
    DataResponse<List<Course>> getAllCourses();
    DataResponse<Course> getCourseById(Long id) throws NotFoundException;
    DataResponse<Course> createCourse(Course course);
    DataResponse<Course> updateCourse(Course course, Long id) throws NotFoundException;
    DataResponse<Object> deleteCourseById(Long id) throws NotFoundException;
}
