package mx.dgtic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/*
Student debe de tener un Perfil
El perfil debe de contener las redes sociales
y informacion de social del estudiante

El perfil se llamara

Student 1..1 StudentProfile

 */

@Entity
@Table(name="students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "country")
    private String country;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private Boolean active;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    @OneToOne
    @JoinColumn(name="student_profile_id")
    private StudentProfile studentProfile;



}
