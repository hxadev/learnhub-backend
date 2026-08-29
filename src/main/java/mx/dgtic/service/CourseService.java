package mx.dgtic.service;

import mx.dgtic.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getCourses();
    CourseDto getCourseById(int id);
}
