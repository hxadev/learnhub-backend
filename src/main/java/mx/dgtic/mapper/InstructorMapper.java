package mx.dgtic.mapper;

import mx.dgtic.dto.InstructorDto;
import mx.dgtic.entity.Instructor;

public class InstructorMapper {
    public static InstructorDto toDto(final Instructor instructor) {
        return InstructorDto.builder()
                .id(instructor.getId())
                .firstName(instructor.getFirstName())
                .lastName(instructor.getLastName())
                .email(instructor.getEmail())
                .bio(instructor.getBio())
                .speciality(instructor.getSpeciality())
                .active(instructor.isActive())
                .createdAt(instructor.getCreatedAt())
                .build();
    }

    public static Instructor toEntity(final InstructorDto instructorDto) {
        return Instructor.builder()
                .id(instructorDto.id())
                .firstName(instructorDto.firstName())
                .lastName(instructorDto.lastName())
                .email(instructorDto.email())
                .bio(instructorDto.bio())
                .speciality(instructorDto.speciality())
                .active(instructorDto.active())
                .createdAt(instructorDto.createdAt())
                .build();
    }
}
