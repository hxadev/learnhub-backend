package mx.dgtic.service;

import mx.dgtic.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();

    /**
     * @param id
     * @return
     */
    CategoryDto getCategoryById(Integer id);
}
