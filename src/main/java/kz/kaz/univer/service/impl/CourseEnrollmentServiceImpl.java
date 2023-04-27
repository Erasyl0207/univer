package kz.kaz.univer.service.impl;

import kz.kaz.univer.entity.CourseEnrollment;
import kz.kaz.univer.repository.EnrollmentRepository;
import kz.kaz.univer.service.CourseEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseEnrollmentServiceImpl implements CourseEnrollmentService {

    private final EnrollmentRepository courseEnrollmentRepository;

    @Override
    public List<CourseEnrollment> getAllCourseEnrollments() {
        return courseEnrollmentRepository.findAll();
    }

    @Override
    public CourseEnrollment getCourseEnrollmentById(Long id) {
        return courseEnrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public CourseEnrollment saveCourseEnrollment(CourseEnrollment enrollment) {
        return courseEnrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteCourseEnrollment(Long id) {
        courseEnrollmentRepository.deleteById(id);
    }
}
