package com.example.session5.repository;

import com.example.session5.model.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
