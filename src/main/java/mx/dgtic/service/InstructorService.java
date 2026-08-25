package mx.dgtic.service;

import mx.dgtic.dto.CourseByInstructorDto;
import mx.dgtic.dto.InstructorDto;

import java.util.List;

public interface InstructorService {

    List<InstructorDto> getAllInstructors();

    InstructorDto getInstructorById(String id);

    List<CourseByInstructorDto> getInstructorAssignedCourses();

}
