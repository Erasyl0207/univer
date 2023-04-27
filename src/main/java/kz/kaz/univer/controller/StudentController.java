package kz.kaz.univer.controller;

import kz.kaz.univer.entity.Student;
import kz.kaz.univer.entity.dto.StudentDto;
import kz.kaz.univer.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.save(studentDto));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id).orElse(null));
    }
}
