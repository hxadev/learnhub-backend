package mx.dgtic.service.impl;

import mx.dgtic.dto.ModuleDto;
import mx.dgtic.mapper.ModuleMapper;
import mx.dgtic.repository.ModuleRepository;
import mx.dgtic.service.ModuleService;

import java.util.List;
import java.util.Optional;

public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;

    public ModuleServiceImpl() {
        moduleRepository = new ModuleRepository();
    }

    @Override
    public List<ModuleDto> getModules() {
        return moduleRepository.findAll().stream()
                .map(ModuleMapper::toDto)
                .toList();
    }

    @Override
    public ModuleDto getModuleById(Integer id) {
        return Optional.of(moduleRepository.findById(id))
                .map(ModuleMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<ModuleDto> getModulesByCourse(Integer courseId) {
        return moduleRepository.findAllByCourseId(courseId).stream()
                .map(ModuleMapper::toDto)
                .toList();
    }
}
