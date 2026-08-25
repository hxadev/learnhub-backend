package mx.dgtic.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.dgtic.dto.CourseDto;
import mx.dgtic.service.CourseService;
import mx.dgtic.service.impl.CourseServiceImpl;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
public class CourseController {

    private final CourseService courseService;

    public CourseController() {
        courseService = new CourseServiceImpl();
    }

    @GET
    @Path("/health")
    public Response healthCheck() {
        return Response.ok("Up").build();
    }

    @POST
    public Response createCourse(CourseDto courseDto) {
        courseService.createCourse(courseDto);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response getCourseById(@PathParam("id") Integer id) {
        return Response.ok(courseService.getCourseById(id)).build();
    }

    @GET
    public Response getAllCourses(
            @QueryParam("active") @DefaultValue("true") boolean active,
            @QueryParam("category") String categoryName
    ) {
        return Response.ok(courseService.getAllCourses(active)).build();
    }

    @GET
    @Path("/category/{categoryId}")
    public Response getAllCoursesByCategory(@PathParam("categoryId") Integer categoryId) {
        return Response.ok(courseService.getAllCoursesByCategory(categoryId)).build();
    }

    @GET
    @Path("/top-popular")
    public Response getAllTopPopularCourses(@PathParam("limit") @DefaultValue("10") Integer limit) {
        return Response.ok(courseService.getTopPopularCourses(limit)).build();
    }

    @GET
    @Path("/instructor/{instructorId}")
    public Response getAllCoursesByInstructor(@PathParam("instructorId") String instructorId) {
        return Response.ok(courseService.getAllCoursesByInstructor(instructorId)).build();
    }

}
