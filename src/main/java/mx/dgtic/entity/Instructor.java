package mx.dgtic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Pojo Instructor
 */
@Entity
@Table(name = "instructors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {
    // atributos encapsulados
    @Id
    @Column(length = 10)
    private String id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(length = 30)
    private String speciality;

    @Column
    private boolean active;

    @Column(name = "created_at")
    private Date createdAt;

    /**
     * @ManyToMany mappedBy = nombre del atributo que mapea la relación en la otra entidad (Course)
     */
    @ManyToMany(mappedBy = "instructors")
    private List<Course> courses;

}

