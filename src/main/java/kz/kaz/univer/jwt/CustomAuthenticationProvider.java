package kz.kaz.univer.jwt;

import kz.kaz.univer.entity.Employee;
import kz.kaz.univer.entity.Role;
import kz.kaz.univer.entity.Student;
import kz.kaz.univer.repository.EmployeeRepository;
import kz.kaz.univer.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("Start actual authentication");
        final String username = authentication.getName();

        final String password = authentication.getCredentials().toString();

        Optional<Student> student = studentRepository.findByLogin(username);
        if (student.isPresent()) {
            final List<GrantedAuthority> authorities = getAuthorities(student.get().getRoles().stream().toList());
            final Authentication auth = new UsernamePasswordAuthenticationToken(username, password, authorities);
            log.info("End actual authentication");
            return auth;
        } else {
            Optional<Employee> employee = employeeRepository.findByLogin(username);
            if (employee.isPresent()) {
                final List<GrantedAuthority> authorities = getAuthorities(employee.get().getRoles().stream().toList());
                final Authentication auth = new UsernamePasswordAuthenticationToken(username, password, authorities);
                log.info("End actual authentication");
                return auth;
            } else {
                throw new UsernameNotFoundException("{}User's not found");
            }
        }
    }

    private List<GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> result = new ArrayList<>();
        Set<String> permissions = new HashSet<>();

        if (!ObjectUtils.isEmpty(roles)) {
            roles.forEach(r -> permissions.add(r.getName()));
        }

        permissions.forEach(p -> result.add(new SimpleGrantedAuthority(p)));
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}