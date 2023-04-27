package kz.kaz.univer.service.impl;

import kz.kaz.univer.entity.Role;
import kz.kaz.univer.entity.Student;
import kz.kaz.univer.entity.dto.StudentDto;
import kz.kaz.univer.repository.RoleRepository;
import kz.kaz.univer.repository.StudentRepository;
import kz.kaz.univer.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Optional<Student> findByLogin(String login) {
        return studentRepository.findByLogin(login);
    }

    @Override
    public Student save(StudentDto studentDto) {
        Student student = new Student();
        student.setLogin(student.getLogin());
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findRoleByName("ROLE_STUDENT"));
        student.setRoles(roles);
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

}
