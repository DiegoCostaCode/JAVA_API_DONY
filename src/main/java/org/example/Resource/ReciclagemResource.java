package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Infrastructure.Loggable;
import org.example.Repository.ReciclagemRepository;

@Path("/produto")
public class ReciclagemResource implements Loggable<String>{

    ReciclagemRepository reciclagemRepository = new ReciclagemRepository();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id")int id)
    {
        try{

            Loggable.logInfo("Buscador de produtos do usuario executado com sucesso!");

            return Response.ok(reciclagemRepository.SearchById(id)).build();
        } catch (Exception e) {
            Loggable.logError("Não foi possível buscar os produtos" + e.getMessage());
            return Response.serverError().build();
        }
    }
}
