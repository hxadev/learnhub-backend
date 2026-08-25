package mx.dgtic.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record CourseTopDto(CourseDto course, Integer enrollments) implements Serializable {
}
