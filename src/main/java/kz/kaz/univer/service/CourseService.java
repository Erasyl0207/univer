package kz.kaz.univer.service;

import kz.kaz.univer.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();

    Optional<Course> getCourseById(Long courseId);

    Course saveCourse(Course course);

    void deleteCourseById(Long courseId);
}
