package kz.kaz.univer.controller;

import kz.kaz.univer.entity.CourseEnrollment;
import kz.kaz.univer.service.CourseEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-enrollments")
@RequiredArgsConstructor
public class CourseEnrollmentController {

    private final CourseEnrollmentService courseEnrollmentService;

    @GetMapping
    public ResponseEntity<List<CourseEnrollment>> getAllCourseEnrollments() {
        return ResponseEntity.ok(courseEnrollmentService.getAllCourseEnrollments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEnrollment> getCourseEnrollmentById(@PathVariable Long id) {
        return  ResponseEntity.ok(courseEnrollmentService.getCourseEnrollmentById(id));
    }

    @PostMapping
    public ResponseEntity<CourseEnrollment> createEnrollment(@RequestBody CourseEnrollment courseEnrollment) {
        return ResponseEntity.ok(courseEnrollmentService.saveCourseEnrollment(courseEnrollment));
    }

    @PutMapping("/{id}")
    public CourseEnrollment updateEnrollment(@PathVariable Long id, @RequestBody CourseEnrollment courseEnrollment) {
        CourseEnrollment existingEnrollment = courseEnrollmentService.getCourseEnrollmentById(id);
        if (existingEnrollment == null) {
            return null;
        }
        existingEnrollment.setStudent(courseEnrollment.getStudent());
        existingEnrollment.setCourseSchedule(courseEnrollment.getCourseSchedule());
        existingEnrollment.setEnrollmentDate(courseEnrollment.getEnrollmentDate());
        existingEnrollment.setGroup(courseEnrollment.getGroup());
        return courseEnrollmentService.saveCourseEnrollment(existingEnrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        courseEnrollmentService.deleteCourseEnrollment(id);
    }
}
