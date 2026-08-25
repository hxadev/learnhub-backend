package mx.dgtic.mapper;

import mx.dgtic.dto.ModuleDto;
import mx.dgtic.entity.Module;

public class ModuleMapper {
    public static ModuleDto toDto(Module module) {
        if (module == null) {
            return null;
        }
        return ModuleDto.builder()
                .id(module.getId())
                .title(module.getTitle())
                .description(module.getDescription())
                .position(module.getPosition())
                .idCourse(module.getCourse().getId())
                .build();
    }

    public static Module toEntity(ModuleDto moduleDto) {
        if (moduleDto == null) {
            return null;
        }

        return Module.builder()
                .id(moduleDto.id())
                .title(moduleDto.title())
                .description(moduleDto.description())
                .position(moduleDto.position())
                .build();

    }
}
