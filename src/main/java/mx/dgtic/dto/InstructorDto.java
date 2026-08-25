package mx.dgtic.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record InstructorDto(
        String id,
        String firstName,
        String lastName,
        String email,
        String bio,
        String speciality,
        boolean active,
        Date createdAt
) {
}
