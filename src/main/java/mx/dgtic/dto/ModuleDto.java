package mx.dgtic.dto;

import lombok.Builder;

@Builder
public record ModuleDto(String id,
                        String title,
                        String description,
                        Integer position,
                        Integer duration,
                        boolean active,
                        Integer idCourse) {
}
