package mx.dgtic.repository;

import com.sun.jdi.ObjectReference;
import mx.dgtic.dao.CourseDao;
import mx.dgtic.entity.Course;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CourseRepository extends CourseDao {
    // Implementa operaciones de negocio para acceder a los datos

    public Course findCourseTitleById(Object id) {
        // NamedParam = :<NombreParam> >> SQL Injections | Script Injection
        var jpql = "SELECT c.id, c.title FROM Course c WHERE c.id = :id";
        return entityManager.createQuery(jpql, Course.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public int getTotalCourses() {
        return entityManager.createQuery("SELECT COUNT(c) FROM Course c", Long.class)
                .getSingleResult().intValue();
    }

    public List<Course> findByCategoryName(String categoryName) {
        return entityManager.createQuery(
                        "SELECT c FROM Course c WHERE c.category.name = :catName"
                ).setParameter("catName", categoryName)
                .getResultList();
    }

    public List<Course> findAllActiveCourses() {
        return entityManager.createQuery(
                "SELECT c FROM Course c WHERE c.active = true"
        ).getResultList();
    }

    public List<Course> findAllCoursesByCategory(int categoryId) {
        return entityManager.createQuery(
                        "FROM Course c WHERE c.category.id = :catId"
                ).setParameter("catId", categoryId)
                .getResultList();
    }

    public void enableCourses() {

    }

    public List<Map<String, Object>> findTopPopularCourses(Integer limit) {
        return entityManager.createQuery(
                        "SELECT e.course, COUNT(e) FROM Enrollment e GROUP BY e.course ORDER BY COUNT(e) DESC",
                        Object[].class
                )
                .setMaxResults(limit)
                .getResultList()
                .stream()
                .map(result -> Map.<String, Object>of(
                        "course", result[0],
                        "enrollments", result[1]
                ))
                .toList();
    }

    public List<Course> findAllCoursesByInstructor(String instructorId) {
        return entityManager.createQuery(
                        "SELECT c FROM Course c JOIN c.instructors i WHERE i.id = :instructorId",
                        Course.class
                )
                .setParameter("instructorId", instructorId)
                .getResultList();
    }
}
