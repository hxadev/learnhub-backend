package mx.dgtic.mapper;

import mx.dgtic.dto.CategoryDto;
import mx.dgtic.entity.Category;

public class CategoryMapper {
    public static CategoryDto toDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .active(category.isActive())
                .build();
    }

    public static Category toEntity(CategoryDto dto){
        return Category.builder()
                .id(dto.id())
                .name(dto.name())
                .description(dto.description())
                .active(dto.active())
                .build();
    }
}
