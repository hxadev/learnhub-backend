package mx.dgtic.repository;

import mx.dgtic.dao.EnrollmentDao;
import mx.dgtic.entity.Enrollment;
import mx.dgtic.utils.EnrollmentStatus;

import java.util.List;
import java.util.Optional;

public class EnrollmentRepository extends EnrollmentDao {
    public List<Enrollment> findAllByStudentId(String studentId) {
        return entityManager.createQuery("FROM Enrollment e WHERE e.student.id=:studentId")
                .setParameter("studentId", studentId)
                .getResultStream()
                .toList();
    }

    public List<Enrollment> findAllByCourseId(String courseId) {
        return entityManager.createQuery("FROM Enrollment e WHERE e.course.id=:courseId")
                .setParameter("courseId", courseId)
                .getResultStream()
                .toList();
    }

    public List<Enrollment> findAllByStatus(EnrollmentStatus status) {
        return entityManager.createQuery("FROM Enrollment e WHERE e.status=:status")
                .setParameter("status", status)
                .getResultStream()
                .toList();
    }
}
