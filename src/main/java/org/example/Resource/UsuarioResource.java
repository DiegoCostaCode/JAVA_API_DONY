package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Entities.Usuario;
import org.example.Config.Loggable;
import org.example.Repository.UsuarioRepository;

@Path("/usuario")
public class UsuarioResource implements Loggable{
    UsuarioRepository usuarioRepository = new UsuarioRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Usuario usuario)
    {
        try
        {
            usuarioRepository.Create(usuario);
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
            Loggable.logInfo("Buscador de usuarios executado com sucesso!");

            return Response.ok(usuarioRepository.Read()).build();
        } catch (Exception e) {
            Loggable.logError("Não foi possível buscar os cadastros" + e.getMessage());
            return Response.serverError().build();
        }
    }
}
