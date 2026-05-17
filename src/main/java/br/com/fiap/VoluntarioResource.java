package br.com.fiap;

import br.com.fiap.bo.VoluntarioBO;
import br.com.fiap.entities.Voluntario;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;

@Provider

@Path("/voluntario")
public class VoluntarioResource {

    private VoluntarioBO voluntarioBO = new VoluntarioBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Voluntario voluntario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        voluntarioBO.inserirBO(voluntario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(voluntario.getIdVoluntario()));
        return Response.created(builder.build()).build();
    }
}
