package mx.dgtic.mapper;

import mx.dgtic.dto.CourseDto;
import mx.dgtic.entity.Category;
import mx.dgtic.entity.Course;
import mx.dgtic.entity.Level;

import java.util.Date;

public class CourseMapper {
    public static CourseDto toDto(Course  course) {
        return CourseDto
                .builder()
                .title(course.getTitle())
                .description(course.getDescription())
                .active(course.isActive())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .duration(course.getDuration())
                .price(course.getPrice())
                .ranking(course.getRanking().intValue())
                .levelId(course.getLevel().getId())
                .categoryId(course.getCategory().getId())
                .build();
    }

    public static Course toEntity(CourseDto courseDto) {
        return Course.builder()
                .title(courseDto.title())
                .description(courseDto.description())
                .active(courseDto.active())
                .updatedAt(new Date())
                .duration(courseDto.duration())
                .price(courseDto.price())
                .ranking(courseDto.ranking().shortValue())
                .level(new Level(courseDto.levelId()))
                .category(new Category(courseDto.categoryId()))
                .build();

    }
}
