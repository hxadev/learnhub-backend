package mx.dgtic.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record StudentDto(
        String id,
        String firstName,
        String lastName,
        String email,
        Date birthDate,
        String country,
        String city,
        String state,
        boolean active
) {
}
