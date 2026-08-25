package mx.dgtic.dto;

import lombok.Builder;

@Builder
public record StudentByCityDto(String city, Long count) {

}
