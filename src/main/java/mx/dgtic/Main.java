package mx.dgtic;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import mx.dgtic.dao.*;
import mx.dgtic.entity.Category;
import mx.dgtic.entity.Course;
import mx.dgtic.entity.Instructor;
import mx.dgtic.entity.Student;
import mx.dgtic.repository.CategoryRepository;
import mx.dgtic.repository.CourseRepository;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CourseRepository courseRepository = new CourseRepository();

        try{
            Course miCourse=new Course();
            miCourse.setTitle("Curso de PL/SQL");
            miCourse.setDescription("");

            courseRepository.insert(miCourse);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }



        /*CourseRepository courseRepository = new CourseRepository();
        var coursesByCategory = courseRepository.findByCategoryName("Programacion");
        coursesByCategory.size();
        var categoryDao = new CategoryRepository();
        var activeCategories = categoryDao.getActiveCategories();
        System.out.println("El total de categorias activas es: " + activeCategories);
        var totalCategories = categoryDao.getTotalCategories();
        System.out.println("El total de categorias es: " + totalCategories);*/


        //CourseDao courseDao = new CourseDao();
        //var miCurso = courseDao.findCourseTitleById(1);

        // System.out.println("Curso: " + miCurso.getTitle());
    }

    /*private static void crudCategory(){
        // CRUD Category
        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.findById(1);
        System.out.println("Name: " + category.getName() + " , Id " + category.getId());
    }
    private static void crudStudent(){
        // CRUD Students
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println("Name: " + student.getFirstName() + " , Id " + student.getId());
        }
    }
    private static void crudInstructor(){}
    private static void crudLevel(){}*/
}