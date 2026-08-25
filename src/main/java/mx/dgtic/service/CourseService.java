package mx.dgtic.service;

import mx.dgtic.dto.CourseDto;
import mx.dgtic.dto.CourseTopDto;

import java.util.List;

public interface CourseService {
    CourseDto getCourseById(int id);

    List<CourseDto> getAllCourses(boolean active);

    List<CourseDto> getAllCoursesByCategory(int categoryId);

    List<CourseTopDto> getTopPopularCourses(Integer limit);

    List<CourseDto> getAllCoursesByInstructor(String instructorId);

    void createCourse(CourseDto courseDto);
}
