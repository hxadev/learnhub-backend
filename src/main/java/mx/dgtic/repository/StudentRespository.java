package mx.dgtic.repository;

import mx.dgtic.dao.StudentDao;
import mx.dgtic.dto.StudentByCityDto;

import java.util.List;
import java.util.Map;

public class StudentRespository extends StudentDao {

    public List<Map<String, Object>> findCountStudentsByCity() {
        return em.createQuery("SELECT s.city as city, COUNT(s) as count FROM Student s GROUP BY s.city", Object[].class)
                .getResultList()
                .stream()
                .map(result -> Map.<String, Object>of(
                        "city", result[0],
                        "count", result[1]
                ))
                .toList();
    }

}
