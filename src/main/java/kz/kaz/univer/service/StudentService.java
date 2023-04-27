package kz.kaz.univer.service;

import kz.kaz.univer.entity.Student;
import kz.kaz.univer.entity.dto.StudentDto;

import java.util.Optional;

public interface StudentService {
    Optional<Student> findByLogin(String login);

    Student save(StudentDto studentDto);

    Optional<Student> findById(Long id);
}
