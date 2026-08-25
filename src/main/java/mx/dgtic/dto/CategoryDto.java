package mx.dgtic.dto;

import lombok.Builder;

@Builder
public record CategoryDto (
        Integer id,
        String name,
        String description,
        boolean active
){

}
