package kz.kaz.univer.entity;

import jakarta.persistence.*;
import kz.kaz.univer.entity.abstracts.AuditableEntity;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "departments")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Department extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<Employee> employees;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<Course> courses;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<Group> groups;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<Student> students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Department that = (Department) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}