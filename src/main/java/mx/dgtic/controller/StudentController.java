package mx.dgtic.controller;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.dgtic.service.StudentService;
import mx.dgtic.service.impl.StudentServiceImpl;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
public class StudentController {
    private final StudentService studentService;

    public StudentController() {
        this.studentService = new StudentServiceImpl();
    }

    @GET
    public Response getStudents(){
        return Response.ok(studentService.getStudents()).build();
    }

    @GET
    @Path("/{id}")
    public Response getStudent(@PathParam("id") Integer id){
        return Response.ok(studentService.getStudent(id)).build();
    }


    @GET
    @Path("/by-city")
    public Response getStudentsByCity(){
        return Response.ok(studentService.getCountStudentsByCity()).build();
    }

}
