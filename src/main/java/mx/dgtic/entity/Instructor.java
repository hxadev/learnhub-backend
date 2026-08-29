package mx.dgtic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
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
public class Instructor {
    // atributos encapsulados
    @Id
    @Size(min = 5, message = "El campo Id debe de contener mimino 5 carácteres")
    @Column(length = 10)
    private String id;

    @Size(min = 2, max = 50, message = "El firstName debe de contener entre 2 y 50 catácteres")
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Size(min = 2, max = 100, message = "El lastName debe de contener entre 2 y 100 carácteres.")
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "El campo bio es obligatorio y no puede ir vacio")
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

