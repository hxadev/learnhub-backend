package mx.dgtic.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Getter;
import mx.dgtic.dto.CourseDto;
import mx.dgtic.service.EnrollmentService;
import mx.dgtic.service.impl.EnrollmentServiceImpl;
import mx.dgtic.utils.EnrollmentStatus;

import java.util.List;

@Path("/enrollments")
@Produces(MediaType.APPLICATION_JSON)
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController() {
        this.enrollmentService = new EnrollmentServiceImpl();
    }

    @GET
    public Response getEnrollments() {
        return Response.ok(enrollmentService.getEnrollments()).build();
    }

    @GET
    @Path("/{id}")
    public Response getEnrollmentById(@PathParam("id") Integer id) {
        return Response.ok(enrollmentService.getEnrollmentById(id)).build();
    }

    @GET
    @Path("/student/{studentId}")
    public Response getEnrollmentsByStudentId(@PathParam("studentId") String studentId) {
        return Response.ok(enrollmentService.getEnrollmentByStudentId(studentId)).build();
    }

    @GET
    @Path("/course/{courseId}")
    public Response getEnrollmentsByCourseId(@PathParam("courseId") String courseId) {
        return Response.ok(enrollmentService.getEnrollmentByCourseId(courseId)).build();
    }

    @GET
    @Path("/status/{status}")
    public Response getEnrollmentsByStatus(@PathParam("status") EnrollmentStatus status) {
        return Response.ok(enrollmentService.getEnrollmentsByStatus(status)).build();
    }
}
