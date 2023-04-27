package kz.kaz.univer.entity;

import jakarta.persistence.*;
import kz.kaz.univer.entity.abstracts.AuditableEntity;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Degree extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String level;

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Employee> employees = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Degree degree = (Degree) o;
        return id != null && Objects.equals(id, degree.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

