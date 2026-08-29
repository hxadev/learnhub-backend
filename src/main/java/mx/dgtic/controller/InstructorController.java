package mx.dgtic.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/instructors")
@Produces(MediaType.APPLICATION_JSON)
public class InstructorController {

    // Declare Service Layer here

    public InstructorController(){
        // Initialize Service Layer here
    }

    @GET
    public Response getInstructors() {
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response getInstructor(@PathParam("id") String id) {
        return Response.ok().build();
    }

    @GET
    @Path("/assigned-courses")
    public Response getInstructorsAssignedByCourse(){
        return Response.ok().build();
    }


}
