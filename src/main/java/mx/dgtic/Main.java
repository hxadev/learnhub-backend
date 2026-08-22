package mx.dgtic;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import mx.dgtic.dao.*;
import mx.dgtic.entity.Category;
import mx.dgtic.entity.Course;
import mx.dgtic.entity.Instructor;
import mx.dgtic.entity.Student;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         * Visualizacion ManyToMany Instructor - Courses
         */

        var courseDao = new CourseDao();

        System.out.println("=== Cursos de mi sistema ===");
        var allCourses = courseDao.findAll();

        // SELECT count(*) from Courses
        var totalCursos = allCourses.size();

        /*for (var course : allCourses) {
            System.out.println("*** Curso: " + course.getTitle());
            var instructorsByCourse = course.getInstructors();
            System.out.println("=== Instructores del curso ===");
            for (var instructor : instructorsByCourse) {
                System.out.println("=====================================");
                System.out.println("Nombre: " + instructor.getFirstName());
                System.out.println("Apellidos: " + instructor.getLastName());
                System.out.println("Email: " + instructor.getEmail());
                System.out.println("Especialidad: " + instructor.getSpeciality());
                System.out.println("=====================================");
            }
        }

        var instructorDao = new InstructorDao();

        var allInstructors = instructorDao.findAll();

        for (var instructor : allInstructors) {
            System.out.println("*** Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());

            var coursesByInstructor = instructor.getCourses();
            System.out.println("=== Courses del instructor ===");
            for (var course : coursesByInstructor) {
                System.out.println("====================================");
                System.out.println("Nombre: " + course.getTitle());
                System.out.println("Descripcion: " + course.getDescription());
                System.out.println("====================================");
            }
        }*/


















        /*var categoryDao = new CategoryDao();
        List<Integer> categoriesToDelete = List.of(12, 13);

        for (Integer id : categoriesToDelete) {
            var category = categoryDao.findById(id);
            if (category != null) {
                categoryDao.delete(category);
            }
        }*/
        /*CourseDao courseDao = new CourseDao();
        Course miCurso = courseDao.findById(1);
        System.out.println("==== Mi curso " + miCurso.getTitle());

        Category categoriaCurso = miCurso.getCategory();
        System.out.println("==== Categoria del curso " + categoriaCurso.getName());
        */

        // Category
        //var categoryDao = new CategoryDao();
        // Busca todas las categorias
        //var allCategories = categoryDao.findAll();

        /*var category = categoryDao.findById(1);
        System.out.println("==== Category: " + category.getName() + "=====");
        System.out.println("==== Courses: " + category.getCourses().size() + "=====");
        category.getCourses().forEach(course -> {
            System.out.println(course.getTitle());
        });*/


        /*allCategories.forEach(category -> {
            var courses = category.getCourses();
            System.out.println("=========== Category: " + category.getName() + " , Courses: " + courses.size()+"===========");
            courses.forEach(course -> {
                System.out.println("Course: " + course.getTitle());
            });
        });*/


        // select  from courses join categories on categor....

        /*var instructorDao = new InstructorDao();
        instructorDao.findAll();

        var levelDao = new LevelDao();
        levelDao.findAll();

        var studentDao = new StudentDao();
        studentDao.findAll();

        var courseDao = new CourseDao();
        var allCourses = courseDao.findAll();

        allCourses.forEach(course -> {
            System.out.println(course);
        });*/
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