package mx.dgtic.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public record CourseDto(
        String title,
        String description,
        BigDecimal price,
        Integer duration,
        boolean active,
        Date createdAt,
        Date updatedAt,
        Integer ranking,
        Integer levelId,
        Integer categoryId

) {
}
