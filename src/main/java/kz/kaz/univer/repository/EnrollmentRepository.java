package kz.kaz.univer.repository;

import kz.kaz.univer.entity.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {
}
