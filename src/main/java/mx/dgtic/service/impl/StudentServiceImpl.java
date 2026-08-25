package mx.dgtic.service.impl;

import mx.dgtic.dto.StudentByCityDto;
import mx.dgtic.dto.StudentDto;
import mx.dgtic.mapper.StudentMapper;
import mx.dgtic.repository.StudentRespository;
import mx.dgtic.service.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private final StudentRespository studentRespository;

    public StudentServiceImpl() {
        this.studentRespository = new StudentRespository();
    }

    @Override
    public List<StudentDto> getStudents() {
        return studentRespository.findAll().stream().map(StudentMapper::toDto)
                .toList();
    }

    @Override
    public StudentDto getStudent(Integer id) {
        return Optional.ofNullable(studentRespository.findById(id))
                .map(StudentMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<StudentByCityDto> getCountStudentsByCity() {
        return studentRespository.findCountStudentsByCity().stream()
                .map(studentByCity -> StudentByCityDto.builder()
                        .city((String) studentByCity.get("city"))
                        .count(((Long) studentByCity.get("count")))
                        .build())
                .toList();
    }
}
