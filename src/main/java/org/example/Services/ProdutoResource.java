package org.example.Services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Entities.Produto;
import org.example.Entities.Usuario;
import org.example.Infrastructure.Loggable;
import org.example.Repository.ProdutoRepository;
import org.example.Repository.UsuarioRepository;

import java.util.List;

@Path("/produto")
public class ProdutoResource implements Loggable{

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id")int id)
    {
        try{
            Produto produtos = ProdutoRepository.read(id);

            Loggable.logInfo("Buscador de produtos do usuario executado com sucesso!");

            return Response.ok(produtos).build();
        } catch (Exception e) {
            Loggable.logError("Não foi possível buscar os produtos" + e.getMessage());
            return Response.serverError().build();
        }
    }
}
