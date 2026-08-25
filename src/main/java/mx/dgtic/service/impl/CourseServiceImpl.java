package mx.dgtic.service.impl;

import mx.dgtic.dto.CourseDto;
import mx.dgtic.dto.CourseTopDto;
import mx.dgtic.entity.Course;
import mx.dgtic.mapper.CourseMapper;
import mx.dgtic.repository.CourseRepository;
import mx.dgtic.service.CourseService;

import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;


    public CourseServiceImpl() {
        courseRepository = new CourseRepository();
    }

    @Override
    public CourseDto getCourseById(int id) {
        return Optional.of(courseRepository.findById(id)).map(CourseMapper::toDto).orElse(null);
    }

    @Override
    public List<CourseDto> getAllCourses(boolean active) {
        if(active) {
            return courseRepository.findAllActiveCourses().stream().map(CourseMapper::toDto).toList();
        }
        return courseRepository.findAll().stream().map(CourseMapper::toDto).toList();
    }

    @Override
    public List<CourseDto> getAllCoursesByCategory(int categoryId) {
        return courseRepository.findAllCoursesByCategory(categoryId).stream().map(CourseMapper::toDto).toList();
    }

    @Override
    public List<CourseTopDto> getTopPopularCourses(Integer limit) {
        return courseRepository.findTopPopularCourses(limit).stream().map(
                topCourse-> CourseTopDto
                        .builder()
                        .course(CourseMapper.toDto((Course) topCourse.get("course")))
                        .enrollments(((Long) topCourse.get("enrollments")).intValue())
                        .build()
        ).toList();
    }

    @Override
    public List<CourseDto> getAllCoursesByInstructor(String instructorId) {
        return courseRepository.findAllCoursesByInstructor(instructorId).stream().map(CourseMapper::toDto).toList();
    }

    @Override
    public void createCourse(CourseDto courseDto) {
        Course course = CourseMapper.toEntity(courseDto);
        courseRepository.insert(course);
    }
}
