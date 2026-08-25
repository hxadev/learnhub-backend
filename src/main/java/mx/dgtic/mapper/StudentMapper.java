package mx.dgtic.mapper;

import mx.dgtic.dto.StudentDto;
import mx.dgtic.entity.Student;

public class StudentMapper {

    public static StudentDto toDto(Student student) {
        return StudentDto
                .builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .birthDate(student.getBirthDate())
                .country(student.getCountry())
                .city(student.getCity())
                .state(student.getState())
                .active(student.getActive())
                .build();
    }

    public static Student toEntity(StudentDto dto) {
        return Student.builder()
                .id(dto.id())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .birthDate(dto.birthDate())
                .country(dto.country())
                .city(dto.city())
                .state(dto.state())
                .active(dto.active())
                .build();
    }

}
