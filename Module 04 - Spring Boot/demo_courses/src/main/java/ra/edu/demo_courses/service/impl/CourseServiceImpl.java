package ra.edu.demo_courses.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.demo_courses.dto.DataResponse;
import ra.edu.demo_courses.entity.Course;
import ra.edu.demo_courses.exception.NotFoundException;
import ra.edu.demo_courses.repository.ICourseRepository;
import ra.edu.demo_courses.service.ICourseService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;
    @Override
    public DataResponse<List<Course>> getAllCourses() {
        return DataResponse.<List<Course>>builder()
                .success(true)
                .message("Hiển thị danh sách thành công")
                .data(courseRepository.findAll())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public DataResponse<Course> getCourseById(Long id) throws NotFoundException {
        return DataResponse.<Course>builder()
                .success(true)
                .message("Hiển thị khóa học thành công")
                .data(courseRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy id: " + id)))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public DataResponse<Course> createCourse(Course course) {
        Course newCourse = courseRepository.save(course);
        return DataResponse.<Course>builder()
                .success(true)
                .message("Thêm khóa học thành công")
                .data(newCourse)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public DataResponse<Course> updateCourse(Course course, Long id) throws NotFoundException {
        Course old = courseRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy id: " + id));
        old.setTitle(course.getTitle());
        old.setDescription(course.getDescription());
        old.setPrice(course.getPrice());
        old.setDurationHours(course.getDurationHours());
        old.setStatus(course.getStatus());
        return DataResponse.<Course>builder()
                .success(true)
                .message("Cập nhật khóa học thành công")
                .data(courseRepository.save(old))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public DataResponse<Object> deleteCourseById(Long id) throws NotFoundException {
        Course deleteItem = courseRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy id: " + id));
        courseRepository.delete(deleteItem);
        return DataResponse.builder()
                .success(true)
                .message("Xóa khóa học thành công")
                .data(null)
                .timestamp(LocalDateTime.now())
                .build();
    }



}
