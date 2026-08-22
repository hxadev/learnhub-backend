package mx.dgtic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Pojo Level
 */
@Entity
@Table(name = "levels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Level {
    // atributos encapsulados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private boolean active;


}
