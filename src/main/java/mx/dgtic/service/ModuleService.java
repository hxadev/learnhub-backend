package mx.dgtic.service;

import mx.dgtic.dto.ModuleDto;

import java.util.List;

public interface ModuleService {
    List<ModuleDto> getModules();
    ModuleDto getModuleById(Integer id);
    List<ModuleDto> getModulesByCourse(Integer courseId);
}
