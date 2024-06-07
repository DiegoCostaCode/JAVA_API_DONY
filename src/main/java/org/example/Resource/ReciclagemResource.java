package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Entities.Reciclagem;
import org.example.Config.Loggable;
import org.example.Repository.ReciclagemRepository;

@Path("/reciclagem")
public class ReciclagemResource implements Loggable<String>{

    ReciclagemRepository reciclagemRepository = new ReciclagemRepository();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Reciclagem reciclagem)
    {
        try
        {
            reciclagemRepository.Create(reciclagem);
            Loggable.logInfo("Enviando ao banco de dados...");
            return Response.status(Response.Status.CREATED).build();
        }
        catch(IllegalArgumentException e)
        {
            Loggable.logError("Cadastro feito!"+e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

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
