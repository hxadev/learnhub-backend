package mx.dgtic.repository;

import mx.dgtic.dao.InstructorDao;
import mx.dgtic.entity.Instructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InstructorRepository extends InstructorDao {

    public List<Instructor> findAllByCourseId(String courseId){
        return entityManager
                .createQuery("SELECT i FROM Course c JOIN c.instructors i WHERE c.id= :courseId")
                .setParameter("courseId", courseId)
                .getResultList();
    }

    public List<Map<String,Object>> findAllCoursesByInstructor(){
        return entityManager
                .createQuery("SELECT COUNT(c.id) as total, i.id as idInstructor FROM Instructor i JOIN i.courses c GROUP BY c.id", Object[].class)
                .getResultList()
                .stream()
                .map(row -> {
                    Object[] values = (Object[]) row;
                    Map<String, Object> map = new HashMap<>();
                    map.put("total", values[0]);
                    map.put("idInstructor", values[1]);
                    return map;
                })
                .collect(Collectors.toList());
    }

}
