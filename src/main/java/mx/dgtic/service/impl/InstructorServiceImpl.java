package mx.dgtic.service.impl;

import mx.dgtic.dto.CourseByInstructorDto;
import mx.dgtic.dto.InstructorDto;
import mx.dgtic.mapper.InstructorMapper;
import mx.dgtic.repository.InstructorRepository;
import mx.dgtic.service.InstructorService;

import java.util.List;
import java.util.Optional;

public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl() {
        this.instructorRepository = new InstructorRepository();
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        return instructorRepository.findAll()
                .stream()
                .map(InstructorMapper::toDto)
                .toList();
    }

    @Override
    public InstructorDto getInstructorById(String id) {
        return Optional.of(instructorRepository.findById(id))
                .map(InstructorMapper::toDto)
                .orElse(null);
    }


    @Override
    public List<CourseByInstructorDto> getInstructorAssignedCourses() {
        return instructorRepository.findAllCoursesByInstructor()
                .stream()
                .map(course -> {
                    return
                            CourseByInstructorDto.builder()
                                    .idInstructor((String) course.get("idInstructor"))
                                    .total((Long) course.get("total"))
                                    .build();
                })
                .toList();
    }
}
