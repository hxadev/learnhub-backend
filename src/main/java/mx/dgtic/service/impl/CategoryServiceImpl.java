package mx.dgtic.service.impl;

import mx.dgtic.dao.CategoryDao;
import mx.dgtic.dto.CategoryDto;
import mx.dgtic.mapper.CategoryMapper;
import mx.dgtic.repository.CategoryRepository;
import mx.dgtic.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl() {
        this.categoryRepository = new CategoryRepository();
    }

    @Override
    public List<CategoryDto> getCategories() {
        return
                Optional.of(categoryRepository.findAll())
                        .orElse(List.of())
                        .stream()
                        .map(CategoryMapper::toDto)
                        .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        return Optional.of(categoryRepository.findById(id)).map(CategoryMapper::toDto).orElse(null);
    }
}
