package mx.dgtic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Pojo Course
 */
@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

