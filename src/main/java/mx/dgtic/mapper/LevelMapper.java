package mx.dgtic.mapper;

import mx.dgtic.dto.LevelDto;
import mx.dgtic.entity.Level;

public class LevelMapper {
    public static LevelDto toDto(Level level) {
        if (level == null) {
            return null;
        }
        return LevelDto.builder()
                .id(level.getId())
                .title(level.getTitle())
                .description(level.getDescription())
                .active(level.isActive())
                .build();
    }

    public static Level toEntity(LevelDto levelDto) {
        if (levelDto == null) {
            return null;
        }
        return Level.builder()
                .id(levelDto.id())
                .title(levelDto.title())
                .description(levelDto.description())
                .active(levelDto.active())
                .build();
    }
}
