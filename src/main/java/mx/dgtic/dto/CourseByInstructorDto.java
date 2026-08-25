package mx.dgtic.dto;

import lombok.Builder;

@Builder
public record CourseByInstructorDto(Long total, String idInstructor) {
}
