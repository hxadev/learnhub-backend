package mx.dgtic.service.impl;

import mx.dgtic.dto.EnrollmentDto;
import mx.dgtic.entity.Enrollment;
import mx.dgtic.mapper.EnrollmentMapper;
import mx.dgtic.repository.EnrollmentRepository;
import mx.dgtic.service.EnrollmentService;
import mx.dgtic.utils.EnrollmentStatus;

import java.util.List;
import java.util.Optional;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl() {
        this.enrollmentRepository = new EnrollmentRepository();
    }

    public List<EnrollmentDto> getEnrollments() {
        return enrollmentRepository.findAll()
                .stream().map(EnrollmentMapper::toDto)
                .toList();
    }

    @Override
    public EnrollmentDto getEnrollmentById(Integer id) {
        return Optional.of(enrollmentRepository.findById(id)).map(EnrollmentMapper::toDto).orElse(null);
    }

    @Override
    public List<EnrollmentDto> getEnrollmentByStudentId(String studentId) {
        return enrollmentRepository.findAllByStudentId(studentId).stream()
                .map(EnrollmentMapper::toDto)
                .toList();
    }

    @Override
    public List<EnrollmentDto> getEnrollmentByCourseId(String courseId) {
        return enrollmentRepository.findAllByCourseId(courseId).stream()
                .map(EnrollmentMapper::toDto)
                .toList();
    }

    @Override
    public List<EnrollmentDto> getEnrollmentsByStatus(EnrollmentStatus status) {
        return enrollmentRepository.findAllByStatus(status).stream()
                .map(EnrollmentMapper::toDto)
                .toList();
    }


}
