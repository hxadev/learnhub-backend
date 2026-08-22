package mx.dgtic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Pojo Category
 */
@Entity
@Table(name = "categories")
@Getter // get
@Setter // set
@NoArgsConstructor // Category()
@AllArgsConstructor // Category(...)
@ToString // toString()
public class Category {
    // atributos encapsulados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private boolean active;
    @Column(name = "created_at")
    private Date createdAt;

    @OneToMany(mappedBy = "category")
    private List<Course> courses;

}
