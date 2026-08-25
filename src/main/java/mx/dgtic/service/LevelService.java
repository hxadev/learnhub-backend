package mx.dgtic.service;

import mx.dgtic.dto.LevelDto;

import java.util.List;

public interface LevelService {
    LevelDto getLevelById(Integer levelId);

    List<LevelDto> getLevels();
}
