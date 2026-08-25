package mx.dgtic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Pojo Course
 */
@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(precision = 38, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer duration = 0;

    @Column(nullable = false)
    private boolean active = true;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIME)
    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private Date updatedAt;

    @Column
    private Short ranking;

    /*
        LAZY = -> getCategory() -> SELECT * FROM Categories

        EAGER = -> new Course() -> SELECT * FROM Courses INNER JOIN Categories ON .. INNER JOIN Level ON INNER JOIN Ranking ON ...
        Courses + Categories + Level + Ranking + =====> N+1 => Low Performance
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id") // INNER JOIN
    private Category category;

    /**
     * ManyToMany - instructor_courses
     * Anotacion @ManyToMany
     * Anotacion @JoinTable - Define el nombre de la tabla pivote/intermedia
     * joinColumns = Define el nombre del atributo de la entidad padre en la tabla intermedia
     * inverseJoinColumns = Define el nombre del atributo de la entidad inversa
     */
    @ManyToMany
    @JoinTable(
            name = "instructors_courses",
            joinColumns = @JoinColumn(name = "id_course"),
            inverseJoinColumns = @JoinColumn(name = "id_instructor")
    )
    private List<Instructor> instructors = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Module> module;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @OneToMany(mappedBy="course")
    private List<Enrollment> enrollments;

}

