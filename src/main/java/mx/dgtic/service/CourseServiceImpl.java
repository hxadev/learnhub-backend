package mx.dgtic.service;

import mx.dgtic.dto.CourseDto;
import mx.dgtic.entity.Course;
import mx.dgtic.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

/*
/ Logica de Negocio => Service
* */
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl() {
        courseRepository = new CourseRepository();
    }

    @Override
    public List<CourseDto> getCourses() {
        // List<Course> => Lista de entidad
        var courses = courseRepository.findAll();

        // Mapper Entity => DTO
        // Transformar Entity => DTO
        List<CourseDto> courseDtos = new ArrayList<>();

        for (Course course : courses) {
            var courseDto = CourseDto.builder()
                    .id(course.getId())
                    .title(course.getTitle())
                    .description(course.getDescription())
                    .active(course.isActive())
                    .duration(course.getDuration())
                    .price(course.getPrice())
                    .build();

            courseDtos.add(courseDto);
        }

        return courseDtos;
    }

    @Override
    public CourseDto getCourseById(int id) {
        //
        Course course = this.courseRepository.findById(id);

        CourseDto courseDto = CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .active(course.isActive())
                .duration(course.getDuration())
                .price(course.getPrice())
                .build();

        return courseDto;
    }
}
