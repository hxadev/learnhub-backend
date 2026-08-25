package mx.dgtic.dto;

import lombok.Builder;

@Builder
public record LevelDto(
    Integer id,
    String title,
    String description,
    boolean active
) {
}
