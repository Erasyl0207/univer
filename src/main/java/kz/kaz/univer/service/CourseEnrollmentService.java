package kz.kaz.univer.service;

import kz.kaz.univer.entity.CourseEnrollment;

import java.util.List;

public interface CourseEnrollmentService {
    List<CourseEnrollment> getAllCourseEnrollments();
    CourseEnrollment getCourseEnrollmentById(Long id);
    CourseEnrollment saveCourseEnrollment(CourseEnrollment enrollment);
    void deleteCourseEnrollment(Long id);
}
