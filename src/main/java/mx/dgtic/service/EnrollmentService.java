package mx.dgtic.service;

import mx.dgtic.dto.EnrollmentDto;
import mx.dgtic.utils.EnrollmentStatus;

import java.util.List;

public interface EnrollmentService {

    List<EnrollmentDto> getEnrollments();

    EnrollmentDto getEnrollmentById(Integer id);

    List<EnrollmentDto> getEnrollmentByStudentId(String studentId);

    List<EnrollmentDto> getEnrollmentByCourseId(String courseId);

    List<EnrollmentDto> getEnrollmentsByStatus(EnrollmentStatus status);
}
