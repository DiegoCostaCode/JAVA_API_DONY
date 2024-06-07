package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Entities.Material;
import org.example.Config.Loggable;
import org.example.Repository.MaterialRepository;

@Path("/material")
public class MaterialResource implements Loggable<String> {

    MaterialRepository materialRepository = new MaterialRepository();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Material material)
    {
        try
        {
            materialRepository.Create(material);
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response read()
    {
        try{
            Loggable.logInfo("Buscador de materiais executado com sucesso!");

            return Response.ok(materialRepository.Read()).build();
        } catch (Exception e) {
            Loggable.logError("Não foi possível buscar os materiais" + e.getMessage());
            return Response.serverError().build();
        }
    }
}
