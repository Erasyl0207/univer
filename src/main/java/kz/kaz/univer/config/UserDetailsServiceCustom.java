package kz.kaz.univer.config;

import kz.kaz.univer.entity.Employee;
import kz.kaz.univer.entity.Student;
import kz.kaz.univer.repository.EmployeeRepository;
import kz.kaz.univer.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> student = studentRepository.findByLogin(username);
        if (student.isPresent()) {
            return student.get();
        } else {
            Optional<Employee> employee = employeeRepository.findByLogin(username);
            return employee.orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        }
    }
}