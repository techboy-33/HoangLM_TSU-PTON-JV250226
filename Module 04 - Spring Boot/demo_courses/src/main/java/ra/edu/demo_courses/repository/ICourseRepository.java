package ra.edu.demo_courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.demo_courses.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {}
