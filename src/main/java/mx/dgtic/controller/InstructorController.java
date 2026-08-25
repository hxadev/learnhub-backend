package mx.dgtic.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.dgtic.dto.InstructorDto;
import mx.dgtic.service.InstructorService;
import mx.dgtic.service.impl.InstructorServiceImpl;

import java.util.List;

@Path("/instructors")
@Produces(MediaType.APPLICATION_JSON)
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(){
        this.instructorService = new InstructorServiceImpl();
    }

    @GET
    public Response getInstructors() {
        return Response.ok(instructorService.getAllInstructors()).build();
    }

    @GET
    @Path("/{id}")
    public Response getInstructor(@PathParam("id") String id) {
        return Response.ok(instructorService.getInstructorById(id)).build();
    }

    @GET
    @Path("/assigned-courses")
    public Response getInstructorsAssignedByCourse(){
        return Response.ok(instructorService.getInstructorAssignedCourses()).build();
    }


}
