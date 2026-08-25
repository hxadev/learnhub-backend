package mx.dgtic.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.dgtic.dto.CategoryDto;
import mx.dgtic.repository.CategoryRepository;
import mx.dgtic.service.CategoryService;
import mx.dgtic.service.impl.CategoryServiceImpl;

import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryController {
    private final CategoryService categoryRepository;
    public CategoryController() {
        this.categoryRepository = new CategoryServiceImpl();
    }

    @GET
    public Response getCategories() {
        return Response.ok(categoryRepository.getCategories()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCategoryById(@PathParam("id") Integer id){
        return Response.ok(categoryRepository.getCategoryById(id)).build();
    }

}
