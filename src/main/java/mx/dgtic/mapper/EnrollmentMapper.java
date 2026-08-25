package mx.dgtic.mapper;

import mx.dgtic.dto.EnrollmentDto;
import mx.dgtic.entity.Enrollment;

import java.math.BigDecimal;

public class EnrollmentMapper {
    public static Enrollment toEntity(EnrollmentDto dto) {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(dto.id());
        enrollment.setEnrollmentDate(dto.enrollmentDate());
        enrollment.setGrade(dto.grade());
        enrollment.setStatus(dto.status());
        enrollment.setCompletionDate(dto.completionDate());
        return enrollment;
    }

    public static EnrollmentDto toDto(Enrollment enrollment) {
        return new EnrollmentDto(
                enrollment.getId(),
                enrollment.getStudent().getId(),
                enrollment.getCourse().getId(),
                enrollment.getEnrollmentDate(),
                enrollment.getGrade(),
                enrollment.getStatus(),
                enrollment.getCompletionDate()
        );
    }
}
