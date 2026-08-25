package mx.dgtic.dto;

import mx.dgtic.entity.Enrollment;
import mx.dgtic.utils.EnrollmentStatus;

import java.math.BigDecimal;
import java.util.Date;

public record EnrollmentDto(
        Integer id,
        String idStudent,
        Integer idCourse,
        Date enrollmentDate,
        BigDecimal grade,
        EnrollmentStatus status,
        Date completionDate
) {
}
