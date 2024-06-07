package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Config.Loggable;
import org.example.Repository.NoticiaRepository;

@Path("/noticia")
public class NoticiaResource implements Loggable<String>{

    NoticiaRepository noticiaRepository = new NoticiaRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response read()
    {
        try{

            Loggable.logInfo("Buscador de noticias do usuario executado com sucesso!");

            return Response.ok(noticiaRepository.Read()).build();
        } catch (Exception e) {
            Loggable.logError("Não foi possível buscar os produtos" + e.getMessage());
            return Response.serverError().build();

        }
    }
}
