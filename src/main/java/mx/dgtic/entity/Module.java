package mx.dgtic.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Pojo Module
 */
@Entity
@Table(name = "modules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Module {

    @Id
    @Column(length = 15)
    private String id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Integer position;

    @Column
    private Integer duration;

    @Column
    private boolean active;

    /**
     * Relacion Many To One
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course", nullable = false)
    private Course course;

}

