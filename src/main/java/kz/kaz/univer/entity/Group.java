package kz.kaz.univer.entity;

import jakarta.persistence.*;
import kz.kaz.univer.entity.abstracts.AuditableEntity;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "groups")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Group extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curator_id")
    @ToString.Exclude
    private Employee curator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "headman_id")
    @ToString.Exclude
    private Student headman;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @ToString.Exclude
    private Department department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Group group = (Group) o;
        return id != null && Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
