package br.com.fiap;

import br.com.fiap.bo.DentistaBO;
import br.com.fiap.entities.Dentista;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;

@Provider

@Path("/dentista")
public class DentistaResource {

    private DentistaBO dentistaBO = new DentistaBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Dentista dentista, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        dentistaBO.inserirBO(dentista);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(dentista.getIdDentista()));
        return Response.created(builder.build()).build();
    }
}
