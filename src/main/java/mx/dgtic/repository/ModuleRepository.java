package mx.dgtic.repository;

import mx.dgtic.dao.ModuleDao;
import mx.dgtic.entity.Module;

import java.util.List;

public class ModuleRepository extends ModuleDao {

    public List<Module> findAllByCourseId(Integer courseId) {
        return entityManager.createQuery("FROM Module m WHERE m.course.id=:courseId ORDER BY m.position")
                .setParameter("courseId", courseId)
                .getResultStream()
                .toList();
    }

}
