package mx.dgtic.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.dgtic.dto.LevelDto;
import mx.dgtic.service.LevelService;
import mx.dgtic.service.impl.LevelServiceImpl;

@Path("/levels")
@Produces(MediaType.APPLICATION_JSON)
public class LevelController {

    private final LevelService levelService;

    public LevelController() {
        this.levelService = new LevelServiceImpl();
    }

    @GET
    public Response getLevels() {
        return Response.ok(levelService.getLevels()).build();
    }

    @GET
    @Path("/{id}")
    public LevelDto getLevel(@PathParam("id") Integer id) {
        return levelService.getLevelById(id);
    }
}
