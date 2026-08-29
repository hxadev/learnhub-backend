package mx.dgtic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

/**
 * Estructura Student Profile
 * id: Integer PK
 * bio: String
 * avatarUrl: String
 * linkedinUrl: String
 * instagramUrl: String
 * preferredLanguage: char MAX 4
 */

@Entity
@Table(name = "student_profiles")
@Data
@Builder
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(length = 500, nullable = false)
    @Min(value = 10, message = "Bio must be at least 10 characters long")
    @Max(value = 500, message = "Bio cannot exceed 500 characters")
    private String bio;

    @Column(name = "avatar_url",  nullable = true, length = 255)
    private String avatarUrl;

    @Column(name = "linkedin_url",  nullable = true, length = 255)
    private String linkedinUrl;

    @Column(name = "instagram_url",  nullable = true, length = 255)
    private String instagramUrl;

    @Column(name = "github_url",  nullable = true, length = 255)
    private String githubUrl;

    @Column(length = 4, name = "preferred_language")
    private char preferredLanguage;

    @OneToOne(mappedBy="studentProfile")
    private Student student;
}
