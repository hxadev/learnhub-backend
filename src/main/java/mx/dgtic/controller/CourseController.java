package mx.dgtic.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.dgtic.service.CourseService;
import mx.dgtic.service.CourseServiceImpl;

// http://localhost:8080/api/courses/health
// http://localhost:8080/api/courses
// http://localhost:8080/api/courses/5

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
public class CourseController {

    // Declare Service Layer here
    private CourseService courseService;

    public CourseController() {
        // Initialize Service Layer here
        courseService = new CourseServiceImpl();
    }

    @GET
    @Path("/health")
    public Response healthCheck() {

        return Response.ok("Hola mundo!").build();
    }

    @POST
    public Response createCourse() {
        // Code Here
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response getCourseById(@PathParam("id") Integer id) {
        // Code Here
        return Response.ok(this.courseService.getCourseById(id)).build();
    }

    @GET
    public Response getAllCourses(
            @QueryParam("active") @DefaultValue("true") boolean active,
            @QueryParam("category") String categoryName
    ) {
        // Code Here
        return Response.ok(this.courseService.getCourses()).build();
    }

    @GET
    @Path("/category/{categoryId}")
    public Response getAllCoursesByCategory(@PathParam("categoryId") Integer categoryId) {
        // Code Here
        return Response.ok().build();
    }

    @GET
    @Path("/top-popular")
    public Response getAllTopPopularCourses(@PathParam("limit") @DefaultValue("10") Integer limit) {
        // Code Here
        return Response.ok().build();
    }

    @GET
    @Path("/instructor/{instructorId}")
    public Response getAllCoursesByInstructor(@PathParam("instructorId") String instructorId) {
        // Code Here
        return Response.ok().build();
    }

}
