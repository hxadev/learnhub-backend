package mx.dgtic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @Column
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

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



}
