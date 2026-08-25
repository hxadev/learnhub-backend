package mx.dgtic.service.impl;

import mx.dgtic.dto.LevelDto;
import mx.dgtic.mapper.LevelMapper;
import mx.dgtic.repository.LevelRepository;
import mx.dgtic.service.LevelService;

import java.util.List;
import java.util.Optional;

public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    public LevelServiceImpl() {
        this.levelRepository = new LevelRepository();
    }

    @Override
    public LevelDto getLevelById(Integer levelId) {
        return Optional.of(levelRepository.findById(levelId)).map(LevelMapper::toDto).orElse(null);
    }

    @Override
    public List<LevelDto> getLevels() {
        return levelRepository.findAll().stream().map(LevelMapper::toDto).toList();
    }
}
