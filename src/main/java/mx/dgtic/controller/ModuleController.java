package mx.dgtic.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.dgtic.dto.ModuleDto;
import mx.dgtic.service.ModuleService;
import mx.dgtic.service.impl.ModuleServiceImpl;

import java.util.List;

@Path("/modules")
@Produces(MediaType.APPLICATION_JSON)
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController() {
        moduleService = new ModuleServiceImpl();
    }

    @GET
    public Response getModules() {
        List<ModuleDto> modules = moduleService.getModules();
        return Response.ok(modules).build();
    }

    @GET
    @Path("{id}")
    public Response getModule(@PathParam("id") Integer id) {
        ModuleDto moduleDto = moduleService.getModuleById(id);
        return Response.ok(moduleDto).build();
    }

    @GET
    @Path("/course/{courseId}")
    public Response getModulesByCourse(@PathParam("courseId") Integer courseId) {
        List<ModuleDto> modules = moduleService.getModulesByCourse(courseId);
        return Response.ok(modules).build();
    }
}
