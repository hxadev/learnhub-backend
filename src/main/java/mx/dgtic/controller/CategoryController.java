package mx.dgtic.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryController {

    // Declare Service Layer here

    public CategoryController() {
        // Initialize Service Layer here
    }

    @GET
    public Response getCategories() {
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response getCategoryById(@PathParam("id") Integer id){
        return Response.ok().build();
    }

    @POST
    public Response addCategory(){
        return Response.ok().build();
    }

}
