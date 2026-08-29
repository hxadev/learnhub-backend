package mx.dgtic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
public class CourseDto {
    private int id;
    private String title;
    private String description;
    private BigDecimal price;
    private int duration;
    private boolean active;
}
