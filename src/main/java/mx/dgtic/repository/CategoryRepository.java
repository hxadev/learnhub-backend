package mx.dgtic.repository;

import mx.dgtic.dao.CategoryDao;

public class CategoryRepository extends CategoryDao {


    public int getTotalCategories(){
        return entityManager.createNamedQuery("Category.getTotalCategories", Long.class)
                .getSingleResult().intValue();
    }

    public int getActiveCategories(){
        return entityManager
                .createNamedQuery("Category.getActiveCategories",Long.class)
                .getSingleResult()
                .intValue();
    }

}
