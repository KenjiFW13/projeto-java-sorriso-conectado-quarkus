package br.com.fiap.resources;

import br.com.fiap.bo.FuncionarioTdbBO;
import br.com.fiap.entities.FuncionarioTdb;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;

@Provider

@Path("/funcionariotdb")
public class FuncionarioTdbResource {

    private FuncionarioTdbBO funcionarioTdbBO = new FuncionarioTdbBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(FuncionarioTdb funcionarioTdb, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        funcionarioTdbBO.inserirBO(funcionarioTdb);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(funcionarioTdb.getIdFuncionarioTdb()));
        return Response.created(builder.build()).build();
    }
}
